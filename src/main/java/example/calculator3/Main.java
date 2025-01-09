package example.calculator3;

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

