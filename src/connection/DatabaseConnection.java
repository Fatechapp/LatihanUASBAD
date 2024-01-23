package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static String DB_URL = "jdbc:mysql://localhost:3306/variasi3";
    static String DB_USER = "root";
    static String DB_PASS = "";

    public static String getDbUrl() {
        return DB_URL;
    }

    public static void setDbUrl(String dbUrl) {
        DB_URL = dbUrl;
    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static void setDbUser(String dbUser) {
        DB_USER = dbUser;
    }

    public static String getDbPass() {
        return DB_PASS;
    }

    public static void setDbPass(String dbPass) {
        DB_PASS = dbPass;
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}

//package connection;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.control.ComboBox;
//
//import java.sql.*;
//import java.text.SimpleDateFormat;
//
//public class DatabaseConnection {
//    static String url = "jdbc:mysql://localhost:3306/variasi3";
//    static String username = "root";
//    static String password = "";
//    public static Connection connection;
//
//    public static String getUrl() {
//        return url;
//    }
//
//    public static void setUrl(String url) {
//        DatabaseConnection.url = url;
//    }
//
//    public static String getUsername() {
//        return username;
//    }
//
//    public static void setUsername(String username) {
//        DatabaseConnection.username = username;
//    }
//
//    public static String getPassword() {
//        return password;
//    }
//
//    public static void setPassword(String password) {
//        DatabaseConnection.password = password;
//    }
//
//    public static Connection getConnection() {
//        return connection;
//    }
//
//    public static void setConnection(Connection connection) {
//        DatabaseConnection.connection = connection;
//    }
//
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            connection = DriverManager.getConnection(url, username, password);
//
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from kategori");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
//            }
//            connection.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    public static ObservableList<String> fillComboBox() {
//        ObservableList<String> kategoriList = FXCollections.observableArrayList();
//
//        String url = "jdbc:mysql://localhost:3306/variasi3";
//        String username = "root";
//        String password = "";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT Nm_Kategori FROM kategori");
//
//            while (resultSet.next()) {
//                kategoriList.add(resultSet.getString("Nm_Kategori"));
//            }
//
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return kategoriList;
//    }
//
//
//
//}
//
