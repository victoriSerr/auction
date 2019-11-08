package repositories;

import models.Lot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LotRepository implements CrudRepository<Lot, Long> {
    private Connection connection;

    //language=SQL
    private final String SQL_SAVE_LOT = "insert into lot (owner_id, " +
            "status, buyer_id, start_date, finish_date, transaction_status, product_id) values (?, ?, ?, ?, ? ,?, ?);";

    private final String SQL_FIND_LOT_USERA = "select * from lot where buyer_id = ?;";
    public LotRepository(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<Lot> lotRowMapper = row -> {
        Long id = row.getLong("id");
        Long ownerId = row.getLong("owner_id");
        Boolean status = row.getBoolean("status");
        Long buyerId = row.getLong("buyer_id");
        String startDate = row.getString("start_date");
        String finishDate = row.getString("finish_date");
        Boolean transactionStatus = row.getBoolean("transaction_status");
        Long productId = row.getLong("product_id");
        return new Lot(id, ownerId, status,
                buyerId, startDate, finishDate, transactionStatus, productId);
    };

    @Override
    public void save(Lot model) {

        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_LOT, Statement.RETURN_GENERATED_KEYS);

            statement.setLong(1, model.getOwnerId());
            statement.setBoolean(2, model.getStatus());
            statement.setLong(3, model.getBuyerId());
            statement.setString(4, model.getStartDate());
            statement.setString(5, model.getFinishDate());
            statement.setBoolean(6, model.getTransactionStatus());
            statement.setLong(7, model.getProductId());

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
    public void update(Lot model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Lot> find(Long aLong) {
        return Optional.empty();
    }

    public List<Lot> findUsersLot(Long id) {
        List<Lot> result = null;
        try {
            //в PreparedStatement statement посылается строка SQL_FIND_USER, содержащая SQL запрос на поиск пользователя по id

            PreparedStatement statement = connection.prepareStatement(SQL_FIND_LOT_USERA);
            //посылается соответствующее значение на место вопроса
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Lot lot = lotRowMapper.mapRow(resultSet);
                result.add(lot);
            }
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return result;

    }

    @Override
    public List<Lot> findAll() {
        List<Lot> result = new ArrayList<>();
        try {
            //в PreparedStatement statement посылается строка SQL_FIND_USER, содержащая SQL запрос на поиск пользователя по id

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from lot");
            while (resultSet.next()) {
                Lot lot = lotRowMapper.mapRow(resultSet);
                result.add(lot);
            }
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }
}
