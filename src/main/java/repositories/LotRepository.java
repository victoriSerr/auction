package repositories;

import models.Lot;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class LotRepository implements CrudRepository<Lot, Long> {
    private Connection connection;

    //language=SQL
    private final String SQL_SAVE_LOT = "insert into lot (owner_id, " +
            "status, buyer_id, start_date, finish_date, transaction_status, product_id) values (?, ?, ?, ?, ? ,?, ?);";

    private final String SQL_FIND_LOT_USERA = "select * from lot where buyer_id = ?;";
    private final String SQL_FIND_LOT_BY_ID = "select * from lot where id = ?;";
    private final String SQL_UPDATE_LOT = "update lot set status = ?, buyer_id = ?, transaction_status = ? where id = ?;";


    public LotRepository(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<Lot> lotRowMapper = row -> {
        Long id = row.getLong("id");
        Long ownerId = row.getLong("owner_id");
        Boolean status = row.getBoolean("status");
        Long buyerId = row.getLong("buyer_id");
        Timestamp startDate = row.getTimestamp("start_date");
        Timestamp finishDate = row.getTimestamp("finish_date");
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
            statement.setNull(3, Types.BIGINT);
            statement.setTimestamp(4, model.getStartDate());
            statement.setTimestamp(5, model.getFinishDate());
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
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_LOT, Statement.RETURN_GENERATED_KEYS);

            statement.setBoolean(1, model.getStatus());
            if (model.getBuyerId() == null) {
                statement.setNull(2, Types.BIGINT);
            } else {
                statement.setLong(2, model.getBuyerId());
            }
            statement.setBoolean(3, model.getTransactionStatus());
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
    public Optional<Lot> find(Long id) {
        Lot lot = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_LOT_BY_ID);

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                lot = lotRowMapper.mapRow(resultSet);
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return Optional.ofNullable(lot);
    }

    public List<Lot> findUsersLot(Long id) {
        List<Lot> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_LOT_USERA);
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
