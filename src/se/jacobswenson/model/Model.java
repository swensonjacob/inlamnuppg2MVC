package se.jacobswenson.model;

import se.jacobswenson.controller.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Model {


    public Model(Controller controller) {
        controller.setModel(this);
    }

    public String getNumber(int choice) {
       String filename;
       if (choice == 1) {
           filename = "src/se/jacobswenson/resources/one.txt";
       } else {
           filename = "src/se/jacobswenson/resources/two.txt";
       }
        String text="";
        try {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        text = reader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
