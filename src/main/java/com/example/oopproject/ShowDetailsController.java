package com.example.oopproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowDetailsController implements Initializable {

    public Button UserAddButton;
    public Button UserDeleteButton;
    public Button UserShowDetails;
    public Button UserLogOut;
    public TableView<Carpets> tableShowDetails;
    public Button ShowHistoryButton;
    public Button SignUp;
    @FXML
    private TableColumn<Carpets, String> ColorColumn;
    @FXML
    private TableColumn<Carpets, Integer> IDColoumn;
    @FXML
    private TableColumn<Carpets, String> NameColoumn;
    @FXML
    private TableColumn<Carpets, Double> PriceColoumn;
    @FXML
    private TableColumn<Carpets, String> SizeColoumn;
    @FXML
    private TableColumn<Carpets, Integer> StockColoumn;


    public void UserAddButtonOnAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(LoginController.class.getResource("AddCarpet.fxml"));
            Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
            HelloApplication.stage1.setScene(scene2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void UserDeleteButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(LoginController.class.getResource("DeleteCarpet.fxml"));
            Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
            HelloApplication.stage1.setScene(scene2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void UserShowHistory(ActionEvent event){
        ShowHistoryButton.setStyle("-fx-background-color:  #960000; ");

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(LoginController.class.getResource("ShowHistory.fxml"));
            Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
            HelloApplication.stage1.setScene(scene2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void CreateAdminOnAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(SignUpController.class.getResource("SignUp.fxml"));
            Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
            HelloApplication.stage1.setScene(scene2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void UserLogOutOnAction(ActionEvent event) {

        try {
            if (Boxes.confirmBox("Logout", "Do you want to log out?")) {
                FXMLLoader fxmlLoader2 = new FXMLLoader(LoginController.class.getResource("Login.fxml"));
                Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
                HelloApplication.stage1.setScene(scene2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Carpets> readCarpetFromFile =FileHandling.readFromFile("src/main/java/com/example/oopproject/CarpetData.txt");
        ObservableList<Carpets> obList = FXCollections.observableList(readCarpetFromFile);
        IDColoumn.setCellValueFactory(new PropertyValueFactory<Carpets,Integer>("ID"));
        NameColoumn.setCellValueFactory(new PropertyValueFactory<Carpets,String>("name"));
        ColorColumn.setCellValueFactory(new PropertyValueFactory<Carpets,String>("color"));
        SizeColoumn.setCellValueFactory(new PropertyValueFactory<Carpets,String>("size"));
        PriceColoumn.setCellValueFactory(new PropertyValueFactory<Carpets,Double>("price"));
        StockColoumn.setCellValueFactory(new PropertyValueFactory<Carpets,Integer>("stock"));

        tableShowDetails.setItems(obList);



    }
}