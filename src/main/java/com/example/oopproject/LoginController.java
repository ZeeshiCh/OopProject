package com.example.oopproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoginController {
    @FXML
    private Text userLogin;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    public Button loginButton;

UserInfo user = new UserInfo("Ali","1234");

public void loginBtnAction() throws IOException, ClassNotFoundException {
//    String UserName = userName.getText();
//    String passWord = password.getText();
//    FileInputStream fis = new FileInputStream("src/main/java/com/example/oopproject/UserData.txt");
//    ObjectInputStream ois = new ObjectInputStream(fis);
    //    readDataFromFile.add((UserInfo) ois.readObject());
    //

    //(user.compare(user,u)==0)||

//    UserInfo user = new UserInfo(userName.getText(),password.getText());
    ArrayList<UserInfo> readDataFromFile = FileHandling.readFromFile("src/main/java/com/example/oopproject/UserData.txt");

    for (UserInfo u:readDataFromFile) {

       if (userName.getText().equals(u.getUsername())&& password.getText().equals(u.getPassword())||(userName.getText().equals("Admin") && password.getText().equals("oopProject")))
        {
            try{
                FXMLLoader fxmlLoader1 = new FXMLLoader(LoginController.class.getResource("User.fxml"));
                Scene scene1 = new Scene(fxmlLoader1.load(),600,400);
                HelloApplication.stage1.setScene(scene1);
                break;
            }
            catch (Exception e){}
        }

    }

   }


   }

