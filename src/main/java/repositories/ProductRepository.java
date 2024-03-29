package repositories;

import models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements CrudRepository<Product, Long> {
    Connection connection;

    private final String SQL_SAVE_PRODUCT = "insert into product (price,  name, description, images) values (?,?,?,?); ";
    private final String SQL_FIND_PRODUCT_BY_ID = "select * from product where id = ?;";

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<Product> productRowMapper = row -> {
        Long id = row.getLong("id");
        Long price = row.getLong("price");
        String[] b = (String[]) row.getArray("images").getArray();
        String name = row.getString("name");
        String description = row.getString("description");

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(b));
        return new Product(id, price, arrayList, name, description);
    };

    @Override
    public void save(Product model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_PRODUCT, Statement.RETURN_GENERATED_KEYS);

            Array array = connection.createArrayOf("VARCHAR", model.getImages().toArray());

            statement.setLong(1, model.getPrice());
            statement.setString(2, model.getName());
            statement.setString(3, model.getDescription());
            statement.setArray(4, array);

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
    public void update(Product model) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<Product> find(Long id) {
        Product product = null;
        try {
            //в PreparedStatement statement посылается строка SQL_FIND_USER, содержащая SQL запрос на поиск пользователя по id
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_PRODUCT_BY_ID);

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                product = productRowMapper.mapRow(resultSet);
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
