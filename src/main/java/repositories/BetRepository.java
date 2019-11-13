package repositories;

import models.Bet;

import java.sql.*;
import java.util.*;
import java.util.Date;

import static java.util.Calendar.*;

public class BetRepository implements CrudRepository<Bet, Long> {
    Connection connection;

    public BetRepository(Connection connection) {
        this.connection = connection;
    }

    private final String SQL_SAVE_BET = "insert into bet(lot_id, p_buyer_id, bet_val, date) VALUES (?, ?, ?, ?);";


    private RowMapper<Bet> betRowMapper = row -> {
        Long id = row.getLong("id");
        Long lotId = row.getLong("lot_id");
        Timestamp date = row.getTimestamp("date");
        Long pBuyerId = row.getLong("p_buyer_id");
        Long betVal = row.getLong("bet_val");
        return new Bet(id, lotId, date, pBuyerId, betVal);
    };

    @Override
    public void save(Bet model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_BET, Statement.RETURN_GENERATED_KEYS);

            statement.setLong(1, model.getLotId());
            statement.setLong(2, model.getpBuyerId());
            statement.setLong(3, model.getBetValue());
            statement.setTimestamp(4, model.getDate());

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
    public void update(Bet model) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<Bet> find(Long aLong) {
        return Optional.empty();
    }

    public Bet findLatest(Long id) {
        Bet bet = null;

        try {
            //в PreparedStatement statement посылается строка SQL_FIND_USER, содержащая SQL запрос на поиск пользователя по id

            PreparedStatement statement = connection.prepareStatement("select * from bet where date = (select max(date) from bet where lot_id = ?);");
            statement.setLong(1, id);

            //посылается соответствующее значение на место вопроса
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
                bet = betRowMapper.mapRow(resultSet);
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return bet;
    }

    @Override
    public List<Bet> findAll() {
        return null;
    }
}
