package com.example.oopproject;

import java.io.*;
import java.util.ArrayList;


public class FileData {

    public static void writeToFile(String fileName, UserInfo user) {
        File file = new File(fileName);
        System.out.println("I am in write to file");
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
//            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("I am in try catch block");
            oos.writeObject(user);

            oos.close();
//            bos.close();
            fos.close();

            System.out.println("File closed ");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static  ArrayList<UserInfo> readFromFile(String fileName){

        ArrayList<UserInfo> user1 = new ArrayList<>();

        try {

            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = null;
            while (fis.available() > 0) {
                ois = new ObjectInputStream(fis);
                user1.add((UserInfo)ois.readObject());
            }
            ois.close();

           fis.close();


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user1;
    }

}
