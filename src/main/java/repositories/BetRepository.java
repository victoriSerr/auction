package repositories;

import models.Bet;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BetRepository implements CrudRepository<Bet, Long> {
    Connection connection;
    public BetRepository(Connection connection) {
        this.connection = connection;
    }

    private final String SQL_SAVE_BET = "insert into bet VALUES (?, ?, ?, ?);";


    private RowMapper<Bet> betRowMapper = row -> {
        Long id = row.getLong("id");
        Long lotId = row.getLong("lot_id");
        Date date = row.getDate("date");
        Long pBuyerId = row.getLong("p_buyer_id");
        Long betVal = row.getLong("bet_val");
        return new Bet(id, lotId, date, pBuyerId, betVal);
    };
    @Override
    public void save(Bet model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_BET, Statement.RETURN_GENERATED_KEYS);

            statement.setLong(1, model.getLotId());
            statement.setDate(2, (java.sql.Date) model.getDate());
            statement.setLong(3, model.getpBuyerId());
            statement.setLong(4, model.getBetValue());

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

    public Bet findLatest() {
        Bet bet = null;

        try {
            //в PreparedStatement statement посылается строка SQL_FIND_USER, содержащая SQL запрос на поиск пользователя по id

            Statement statement = connection.createStatement();

            //посылается соответствующее значение на место вопроса
            ResultSet resultSet = statement.executeQuery("select * from bet where date = (select max(date) from bet);");

            if(resultSet.next())
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
