package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;

public class UserController {


    public Button UserAddButton;
    public Button UserDeleteButton;
    public Button UserShowDetails;
    public Button UserLogOut;
    public Button ShowHistoryButton;
    public Button SignUp;

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

    public void UserShowDetailsOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(LoginController.class.getResource("ShowDetail.fxml"));
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

    public void UserLogOutOnAction(ActionEvent event) {
        UserLogOut.setStyle("-fx-background-color:  #960000; ");

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


    public void CreateAdminOnAction(ActionEvent event) {

        try {
                FXMLLoader fxmlLoader2 = new FXMLLoader(SignUpController.class.getResource("SignUp.fxml"));
                Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
                HelloApplication.stage1.setScene(scene2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





}
