package example.calculator3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean calculateEnded = true;
        while (calculateEnded) {
            try {
                calculateEnded = CalculatorApp.startApp();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                calculateEnded = false;
            }
        }
    }
}

