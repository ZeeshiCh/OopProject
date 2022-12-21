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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DeleteCarpetControler implements Initializable {
    public Button UserAddButton;
    public Button UserDeleteButton;
    public Button UserShowDetails;
    public Button UserLogOut;

    public TableView<Carpets> tableShowDetails;
    public TextField DeleteCarpetIDTf;
    public Button DeleteCarpetSearchButton;
    public Text notFoundText;
    public HBox HideVBox;
    public Button DeleteButtonDC;
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


    public void UserAddButtonOnAction(ActionEvent event){

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(LoginController.class.getResource("AddCarpet.fxml"));
            Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
            HelloApplication.stage1.setScene(scene2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void UserShowDetailsOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(LoginController.class.getResource("ShowDetail.fxml"));
            Scene scene = new Scene(fxmlLoader2.load(), 600, 400);
            HelloApplication.stage1.setScene(scene);
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

        NameColoumn.setCellValueFactory(new PropertyValueFactory<Carpets,String>("name"));
        ColorColumn.setCellValueFactory(new PropertyValueFactory<Carpets,String>("color"));
        SizeColoumn.setCellValueFactory(new PropertyValueFactory<Carpets,String>("size"));
        PriceColoumn.setCellValueFactory(new PropertyValueFactory<Carpets,Double>("price"));
        StockColoumn.setCellValueFactory(new PropertyValueFactory<Carpets,Integer>("stock"));
        IDColoumn.setCellValueFactory(new PropertyValueFactory<Carpets,Integer>("ID"));
        HideVBox.setVisible(false);
        notFoundText.setVisible(false);

    }

    @FXML
    void SearchIdOnAction(ActionEvent event) {
        ArrayList<Carpets> deleteData = FileHandling.readFromFile("src/main/java/com/example/oopproject/CarpetData.txt");
        ObservableList<Carpets> obList = FXCollections.observableList(deleteData);

        boolean status = false;

        for (Carpets c : deleteData) {
            if (Integer.parseInt(DeleteCarpetIDTf.getText())==c.getID()) {
                tableShowDetails.getItems().add(c);
                HideVBox.setVisible(true);
                notFoundText.setVisible(false);
                status = true;
                break;
            }
        }
        if (!status) {
            notFoundText.setVisible(true);
            HideVBox.setVisible(false);
        }

    }

    @FXML
    void DeleteButtonOnAction(ActionEvent event) {
        ArrayList<Carpets> deleteDataFromFile = FileHandling.readFromFile("src/main/java/com/example/oopproject/CarpetData.txt");

        for (Carpets c : deleteDataFromFile) {
            if (Integer.parseInt(DeleteCarpetIDTf.getText()) == c.getID()) {
                if (Boxes.confirmBox("Delete Data", "Do you want to delete this item?")) {
                    deleteDataFromFile.remove(c);
                    HideVBox.setVisible(false);
                    break;
                }
            }
        }
        File file1 = new File("src/main/java/com/example/oopproject/CarpetData.txt");
        file1.delete();
        for (Carpets cr : deleteDataFromFile) {
            FileHandling.writeToFile("src/main/java/com/example/oopproject/CarpetData.txt", cr);
        }

    }



}
