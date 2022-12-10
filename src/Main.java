

import javafx.concurrent.Task;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task1();
    }
    public static void Task1() {
        StringBuilder stringBuilder = new StringBuilder();
        int max = 100;
        for(int i = 0; i < max; i++) {
            stringBuilder.append("TEST");
        }
        try {
            FileWriter fr = new FileWriter("file.txt");
            fr.write(stringBuilder.toString());
            fr.flush();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}