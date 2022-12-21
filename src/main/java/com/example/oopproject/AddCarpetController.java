package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddCarpetController {


    public Label AddCarpetID;
    public Label AddCarpetColour;
    public Label AddCarpetSize;
    public Label AddCarpetPrice;

    public TextField AddCarpetIDTF;
    public TextField AddCarpetColourTX;
    public TextField AddCarpetSizeTX;
    public TextField AddCarpetPriceTX;
    public Button AddCarpetAddButton;
    public Button UserDeleteButton;
    public Button UserShowDetails;
    public Button UserLogOut;
    public Label AddCarpetStock;
    public TextField AddCarpetStockTF;
    public Button AddCarpetButton;
    public Label AddCarpetName;
    public TextField AddCarpetNameTF;
    public Button ShowHistoryButton;
    public Button SignUp;

    public void UserDeleteButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(DeleteCarpetControler.class.getResource("DeleteCarpet.fxml"));
            Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
            HelloApplication.stage1.setScene(scene2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void UserShowDetailsOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(ShowDetailsController.class.getResource("ShowDetail.fxml"));
            Scene scene = new Scene(fxmlLoader2.load(), 600, 400);
            HelloApplication.stage1.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void UserShowHistory(ActionEvent event){
        ShowHistoryButton.setStyle("-fx-background-color:  #960000; ");

        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(ShowHistoryController.class.getResource("ShowHistory.fxml"));
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


    public void AddCarpetData(ActionEvent event) {
        if (AddCarpetNameTF.getText() != null && AddCarpetColourTX.getText() != null && AddCarpetIDTF.getText() != null && AddCarpetSizeTX.getText() != null && AddCarpetPrice.getText() != null && AddCarpetStockTF.getText() != null) {
            Carpets newCarpet = new Carpets(AddCarpetNameTF.getText(),Double.parseDouble(AddCarpetPriceTX.getText()),AddCarpetColourTX.getText(),AddCarpetSizeTX.getText(),Integer.parseInt(AddCarpetIDTF.getText()),Integer.parseInt(AddCarpetStockTF.getText()));
            FileHandling.writeToFile("src/main/java/com/example/oopproject/CarpetData.txt",newCarpet);
            FileHandling.writeToFile("src/main/java/com/example/oopproject/CarpetHistory.txt",newCarpet);
            AddCarpetNameTF.setText(" ") ;
            AddCarpetIDTF.setText(" ");
            AddCarpetSizeTX.setText(" ");
            AddCarpetColourTX.setText(" ");
            AddCarpetStockTF.setText(" ");
            AddCarpetPriceTX.setText(" ");
        }



    }





}
