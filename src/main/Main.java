package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        //layout
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20,20,20,20));
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);

        //label
        Label lbl_title = new Label("Action Figure Shop");
        lbl_title.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        gp.add(lbl_title, 15, 0);

        //name
        Label lbl_name = new Label("Name :");
        TextField tf_name = new TextField();
        gp.add(lbl_name, 15, 1);
        gp.add(tf_name, 15, 2);

        //adress
        Label lbl_address = new Label("Address : ");
        TextArea ta_address = new TextArea();
        ta_address.setWrapText(true);
        gp.add(lbl_address, 15, 3);
        gp.add(ta_address, 15, 4);

        //menubar
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        Menu logout = new Menu("Logout");
        MenuItem menuItem = new MenuItem("Cart");
        MenuItem logoutBut = new MenuItem("logout");
        menu.getItems().add(menuItem);
        logout.getItems().add(logoutBut);
        menuBar.getMenus().addAll(menu, logout);

        logoutBut.setOnAction(actionEvent -> {
            Platform.exit();
        });

        //button
        Button exitButton = new Button("Exit");
        gp.add(exitButton, 10, 10);
        exitButton.setOnAction(actionEvent -> {
            Platform.exit();
        });

        //button
        Button popupButton = new Button("Exit");
        gp.add(popupButton, 10, 11);
        popupButton.setOnAction(actionEvent -> {
            showAlertDialog();
        });

        Button pindahKeDua = new Button("Hal 2");
        pindahKeDua.setOnAction(actionEvent -> {
            halamanDua dua = new halamanDua();
            Scene sceneDua = dua.halamanKeDua(stage);
            stage.setScene(sceneDua);
        });
        gp.add(pindahKeDua, 10, 15);

        //layout menubar
        VBox vBox = new VBox();
        vBox.getChildren().addAll(menuBar, gp);

        VBox.setVgrow(menuBar, Priority.ALWAYS);
        VBox.setVgrow(gp, Priority.ALWAYS);

        stage.setTitle("Stage");
        Scene sc = new Scene(vBox, 800, 400);
        stage.setScene(sc);
        stage.show();
    }
    public static void saveData() {
        try {
            Connection connection = new DatabaseConnection().getConnection();

        } catch (SQLException e) {

        }
    }
    private void showAlertDialog() {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("This is an example of JavaFX Alert.");

        // Menambahkan tombol OK
        ButtonType okButton = new ButtonType("OK");
        alert.getButtonTypes().setAll(okButton);

        // Menampilkan dialog dan menunggu respons pengguna
        alert.showAndWait();
    }

}

//package main;
//
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.collections.ObservableList;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//import connection.DatabaseConnection;
//
//import java.sql.*;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class Main extends Application{
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        HBox hBox = new HBox();
//        ComboBox<String> kategoriComboBox = new ComboBox<>();
//        comboBoxFillNm_Kategori(kategoriComboBox);
//
//        GridPane gridPane = new GridPane();
//        Label kategoriLabel = new Label("Kategori");
//        Label kodeBarangLabel = new Label("Kode Barang");
//        Label namaLabel = new Label("Nama");
//        Label hargaLelangLabel = new Label("Harga Lelang");
//        Label blank = new Label();
//        Label blank1 = new Label();
//
//        TextField kodeBarangTextField = new TextField();
//        TextField namaTextField = new TextField();
//        TextField hargaLelangTextField = new TextField();
//
//        kodeBarangTextField.setPrefWidth(250);
//        namaTextField.setPrefWidth(250);
//        hargaLelangTextField.setPrefWidth(250);
//
//        Button backButton = new Button("Back");
//        Button saveButton = new Button("Save");
//
//        backButton.setOnAction(actionEvent -> {
//            Platform.exit();
//        });
//        saveButton.setOnAction(actionEvent -> {
//            try {
//                String kdKategori = getKdKategoriFromComboBox(kategoriComboBox);
//                String tanggal = getCurrentDate();
//                String kdBarang = kodeBarangTextField.getText();
//                String nmCustomer = namaTextField.getText();
//                int kosong = 1;
//                int hargaLelang = Integer.parseInt(hargaLelangTextField.getText());
//
//                String url = "jdbc:mysql://localhost:3306/variasi3";
//                String username = "root";
//                String password = "";
//                Connection connection = DriverManager.getConnection(url, username, password);
//
//                String sql = "INSERT INTO lelang (kd_kategori, Tanggal, Kd_barang, Nm_customer, Quantity, Harga) VALUES (?, ?, ?, ?, ?, ?)";
//                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                    preparedStatement.setString(1, kdKategori);
//                    preparedStatement.setString(2, tanggal);
//                    preparedStatement.setString(3, kdBarang);
//                    preparedStatement.setString(4, nmCustomer);
//                    preparedStatement.setInt(5, kosong);
//                    preparedStatement.setInt(6, hargaLelang);
//
//                    int rowsAffected = preparedStatement.executeUpdate();
//                    if (rowsAffected > 0) {
//                        System.out.println("Data inserted successfully.");
//                    } else {
//                        System.out.println("Failed to insert data.");
//                    }
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid number format for 'hargaLelang'.");
//            }
//        });
//
//        gridPane.setHgap(10);
//        gridPane.setVgap(10);
//
//        gridPane.add(backButton, 0, 15);
//        gridPane.add(blank, 1, 0);
//        gridPane.add(kategoriLabel, 1, 1);
//        gridPane.add(kodeBarangLabel, 1, 2);
//        gridPane.add(namaLabel, 1, 3);
//        gridPane.add(hargaLelangLabel, 1, 4);
//
//        gridPane.add(blank1, 2, 0);
//        gridPane.add(kategoriComboBox, 2, 1);
//        gridPane.add(kodeBarangTextField, 2, 2);
//        gridPane.add(namaTextField, 2, 3);
//        gridPane.add(hargaLelangTextField, 2, 4);
//        gridPane.add(saveButton, 3, 15);
//
//        hBox.getChildren().add(gridPane);
//        hBox.setAlignment(Pos.CENTER);
//
//        Scene scene = new Scene(hBox, 450, 300);
//        stage.setScene(scene);
//        stage.setTitle("Input Data");
//        stage.show();
//    }
//    public void comboBoxFillNm_Kategori(ComboBox<String> comboBox) {
//        ObservableList<String> kategoriList = DatabaseConnection.fillComboBox();
//        comboBox.setItems(kategoriList);
//    }
//    public static String getKdKategoriByNmKategori(String nmKategori) {
//        String kdKategori = null;
//        DatabaseConnection dbc = new DatabaseConnection();
//        Connection connection;
//
//        try {
//            connection = DriverManager.getConnection(dbc.getUrl(), dbc.getUsername(), dbc.getPassword());
//            String query = "SELECT Kd_Kategori FROM kategori WHERE Nm_Kategori = ?";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, nmKategori);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                kdKategori = resultSet.getString("Kd_Kategori");
//            }
//
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return kdKategori;
//    }
//    private String getKdKategoriFromComboBox(ComboBox<String> comboBox) {
//        String selectedKategori = comboBox.getValue();
//        return getKdKategoriByNmKategori(selectedKategori);
//    }
//    private String getCurrentDate() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return LocalDate.now().format(formatter);
//    }
//}
