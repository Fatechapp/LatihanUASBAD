package main;

import connection.DatabaseConnection;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class halamanDua {
    private ComboBox<String> comBox;
    private TableView<kategori> tableKategori;

    public Scene halamanKeDua (Stage newWindow){

        //Gridpane
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20, 20, 20, 20));
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);

        //Menubar
        MenuBar mb = new MenuBar();
        Menu menuSatu = new Menu("Satu");
        Menu menuDua = new Menu("Dua");
        mb.getMenus().addAll(menuSatu, menuDua);

//        Judul
        Label lbl_title_dua = new Label("Halaman Dua");
        lbl_title_dua.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        gp.add(lbl_title_dua, 5, 0);

        //ComboBox
        comBox = new ComboBox<String>();
        populateComboBox();
        gp.add(comBox, 5,10);

        //Table View
        tableKategori = new TableView<>();
        fillTableKategori();
        gp.add(tableKategori, 5, 20);

        //Vbox
        VBox vBox = new VBox();
        vBox.getChildren().addAll(mb, gp);

        VBox.setVgrow(mb, Priority.ALWAYS);
        VBox.setVgrow(gp, Priority.ALWAYS);

        return new Scene(vBox, 800, 400);
    }
    private void populateComboBox() {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String query = "SELECT Nm_Kategori FROM kategori";
            try (PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
                ObservableList<String> figureNames = FXCollections.observableArrayList();

                while (rs.next()) {
                    String figurename = rs.getString("Nm_Kategori");
                    figureNames.add(figurename);
                }
                comBox.setItems(figureNames);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void fillTableKategori() {
        tableKategori = new TableView<>();
        ObservableList<kategori> data = FXCollections.observableArrayList();

        // Kolom Kd_Kategori
        TableColumn<kategori, String> kdKategoriCol = new TableColumn<>("Kd_Kategori");
        kdKategoriCol.setCellValueFactory(new PropertyValueFactory<>("Kd_Kategori"));

        // Kolom Nm_Kategori
        TableColumn<kategori, String> nmKategoriCol = new TableColumn<>("Nm_Kategori");
        nmKategoriCol.setCellValueFactory(new PropertyValueFactory<>("Nm_Kategori"));

        tableKategori.getColumns().addAll(kdKategoriCol, nmKategoriCol);

        // Mengambil data dari MySQL dan menambahkannya ke ObservableList
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT Kd_Kategori, Nm_Kategori FROM kategori";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String kdKategori = resultSet.getString("Kd_Kategori");
                    String nmKategori = resultSet.getString("Nm_Kategori");
                    data.add(new kategori(kdKategori, nmKategori));
                }
                tableKategori.setItems(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
