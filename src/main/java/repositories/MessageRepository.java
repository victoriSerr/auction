package repositories;

import models.Lot;
import models.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageRepository  implements CrudRepository<Message, Long>{
    Connection connection;

    private final String SQL_FIND_MESSAGE_USERA = "select * from message where to_user_id = ?;";
    private final String SQL_SAVE_MESSAGE = "insert into message(from_user_id, to_user_id, message) VALUES (?, ?, ?);";

    public MessageRepository(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<Message> messageRowMapper = row -> {
        Long id = row.getLong("id");
        Long formId = row.getLong("from_user_id");
        Long toId = row.getLong("to_user_id");
        String message = row.getString("message");

        return new Message(id, formId, toId, message);
    };


    @Override
    public void save(Message model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_MESSAGE, Statement.RETURN_GENERATED_KEYS);

            statement.setLong(1, model.getFromUserId());
            statement.setLong(2, model.getToUserId());
            statement.setString(3, model.getMessage());

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
    public void update(Message model) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<Message> find(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Message> findAll() {
        return null;
    }

    public List<Message> findAllMessages(Long id) {
        List<Message> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_MESSAGE_USERA);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Message message = messageRowMapper.mapRow(resultSet);
                result.add(message);
            }
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }
}
