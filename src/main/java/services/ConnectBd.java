package services;

import repositories.BetRepository;
import repositories.LotRepository;
import repositories.ProductRepository;
import repositories.UserRepository;
import models.User;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectBd {
    public UserRepository userRepository;
    public LotRepository lotRepository;
    public ProductRepository productRepository;
    public BetRepository betRepository;

    public ConnectBd() {
        main();
    }

    private void main() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("/home/victory/Projects/auction/db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        String url = properties.getProperty("db.url");

        Connection connection;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        userRepository = new UserRepository(connection);
        lotRepository = new LotRepository(connection);
        productRepository = new ProductRepository(connection);
        betRepository = new BetRepository(connection);
    }

}
