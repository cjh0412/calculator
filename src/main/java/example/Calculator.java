package example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        while (true){
            // 양의 정수2, 사칙연산 기호 입력받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            if(!sc.hasNextInt() ){
                System.out.println("입력된 값이 숫자가 아닙니다.");
                break;
            }else{
                num1 = sc.nextInt();
                if(num1 < 0){
                    System.out.println("입력된 값이 0을 포함한 양의 정수가 아닙니다.");
                    break;
                }
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            if(!sc.hasNextInt() ){
                System.out.println("입력된 값이 숫자가 아닙니다.");
                break;
            }else{
                num2 = sc.nextInt();
                if(num2 < 0){
                    System.out.println("입력된 값이 0을 포함한 양의 정수가 아닙니다.");
                    break;
                }
            }
            System.out.print("사칙연산 기호를 입력하세요: ");
            if(num2 == 0){
                System.out.println("나눗셈 연산시 분모(두번째 숫자)는 0을 입력할 수 없습니다.");
                break;
            }
            char operator = sc.next().charAt(0);
                switch (operator){
                    case '+' :
                        System.out.println("결과 : " + (num1 + num2));
                        break;
                    case '-' :
                        System.out.println("결과 : " + (num1 - num2));
                        break;
                    case '*' :
                        System.out.println("결과 : " + (num1 * num2));
                        break;
                    case '/' :
                        System.out.println("결과 : " + (num1 / num2));
                        break;
                    default:
                        System.out.println("잘못된 연산자를 입력하셨습니다.");
                        break;
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
