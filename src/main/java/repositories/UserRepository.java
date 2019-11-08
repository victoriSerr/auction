package repositories;

import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements CrudRepository<User, Long> {
    private Connection connection;

    //language=SQL
    private final String SQL_SAVE_USER = "insert into \"user\" (login, email, password) values (?, ?, ?);";
    private final String SQL_UPDATE_USER = "update \"user\" set login = ?, email = ?, password = ? where id = ?;";
    private final String SQL_FIND_USER_BY_LOGIN = "select * from \"user\" where login = ?;";
    private final String SQL_FIND_USER_BY_ID = "select * from \"user\" where id = ?;";
//    private final String SQL_DELETE_USER = "delete from User where id = ?;";

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<User> userRowMapper = row -> {
        Long id = row.getLong("id");
        String login = row.getString("login");
        String email = row.getString("email");
        String password = row.getString("password");
        return new User(id, login, password, email);
    };


    @Override
    public void save(User model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_USER, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, model.getLogin());
            statement.setString(2, model.getEmail());
            statement.setString(3, model.getHashPassword());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException();
            }

            ResultSet generatesKeys = statement.getGeneratedKeys();

            if (generatesKeys.next()) {
                model.setId(generatesKeys.getLong("id"));
            } else {
                throw new SQLException();
            }
            statement.close();
            generatesKeys.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(User model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER);

            //посылаются соответствующие значения на место вопросов
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getEmail());
            statement.setString(3, model.getHashPassword());
            statement.setLong(4, model.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }

            statement.close();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }


    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<User> find(Long id) {
        User user = null;
        try {
            //в PreparedStatement statement посылается строка SQL_FIND_USER, содержащая SQL запрос на поиск пользователя по id
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_ID);

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                user = userRowMapper.mapRow(resultSet);
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return Optional.ofNullable(user);
    }

    public User findByLogin(String login) {
        User user = null;
        try {
            //в PreparedStatement statement посылается строка SQL_FIND_USER, содержащая SQL запрос на поиск пользователя по id
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_LOGIN);

            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            user = userRowMapper.mapRow(resultSet);
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        try {
            //в PreparedStatement statement посылается строка SQL_FIND_USER, содержащая SQL запрос на поиск пользователя по id

            Statement statement = connection.createStatement();

            //посылается соответствующее значение на место вопроса
            ResultSet resultSet = statement.executeQuery("select * from \"user\";");
            while (resultSet.next()) {
                User user = userRowMapper.mapRow(resultSet);
                result.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }
}
