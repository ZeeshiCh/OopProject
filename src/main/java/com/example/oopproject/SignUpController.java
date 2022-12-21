package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class SignUpController {
    public Hyperlink BackButton;
    @FXML
    private Text userSignUp;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField user_Name;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Button signUpButton;
    @FXML
    private Hyperlink alreadyHaveAccount;


  // static ArrayList<UserInfo> users = new ArrayList<>();
   public void buttonOnAction(ActionEvent event) {
       if(firstName.getText()!=null && lastName.getText()!=null && user_Name.getText()!=null && password.getText()!=null && confirmPassword.getText()!=null) {
           if (password.getText().equals(confirmPassword.getText())) {
               UserInfo newUser = new UserInfo(firstName.getText(), lastName.getText(), user_Name.getText(), password.getText(), confirmPassword.getText());
              // FileData.writeToFile("src/main/java/com/example/oopproject/UserData.txt", newUser);
               FileHandling.writeToFile("src/main/java/com/example/oopproject/UserData.txt", newUser);
               try {

                   FXMLLoader fxmlLoader2 = new FXMLLoader(SignUpController.class.getResource("Login.fxml"));
                   Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
                   HelloApplication.stage1.setScene(scene2);
               } catch (Exception e) {
               }
           }
           else
               System.out.println("Password didnt match");
       }
   }

   public  void alreadyHaveAnAccount(){
       try{
           FXMLLoader fxmlLoader2 = new FXMLLoader(SignUpController.class.getResource("Login.fxml"));
           Scene scene2 = new Scene(fxmlLoader2.load(),600,400);
           HelloApplication.stage1.setScene(scene2);
       }
       catch (Exception e){}
   }

   public void BackOnAction(){
       try{
           FXMLLoader fxmlLoader2 = new FXMLLoader(SignUpController.class.getResource("User.fxml"));
           Scene scene2 = new Scene(fxmlLoader2.load(),600,400);
           HelloApplication.stage1.setScene(scene2);
       }
       catch (Exception e){}
   }




}
