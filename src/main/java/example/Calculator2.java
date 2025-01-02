package example;

import java.util.Scanner;

public class Calculator2 {

    int num1, num2;
    char operator;

    Calculator2(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
    // 덧셈
    static int plus(int num1, int num2) {
        return num1 + num2;
    }
    // 뺄셈
    static int minus(int num1, int num2) {
        return num1 - num2;
    }

    // 곱셈
    static int multiplication(int num1, int num2){
        return num1 * num2;
    }

    // 나눗셈
    static int division(int num1, int num2){
        return num1 % num2;
    }

    // 사칙연산 구분하기
    static void result(int num1, int num2, char operator){
        switch (operator){
            case '+' :
                System.out.println("결과 : " + plus(num1 , num2));
                break;
            case '-' :
                System.out.println("결과 : " + minus(num1, num2));
                break;
            case '*' :
                System.out.println("결과 : " + multiplication(num1, num2));
                break;
            case '%' :
                System.out.println("결과 : " + division(num1, num2));
                break;
            default:
                System.out.println("잘못된 연산자를 입력하셨습니다.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            // 양의 정수2, 사칙연산 기호 입력받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            if(num1 < 0 || num2 < 0){
                System.out.println("첫 번째 또는 두 번째 숫자가 0보다 작은 수가 입력되었습니다.");
                break;

            }else{
                result(num1, num2, operator);
            }

            // 종료 여부 체크
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String endYn = sc.next();
            if(endYn.equals("exit")){
                break;
            }
        }

    }
}
