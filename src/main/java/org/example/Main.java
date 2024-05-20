package org.example;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {

        UserInterface userInterface = new UserInterface();
        while (true) {
            userInterface.init();
            userInterface.display();
        }


    }
}