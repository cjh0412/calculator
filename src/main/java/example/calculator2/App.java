package example.calculator2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Calculator2 calculator = new Calculator2();
        Scanner sc = new Scanner(System.in);
        int num1, num2, result;
        char operator ;

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
            operator = sc.next().charAt(0);
            if(num2 == 0 && operator == '%'){
                System.out.println("나눗셈 연산시 분모(두번째 숫자)는 0을 입력할 수 없습니다.");
                break;
            };

            if(operator != '+' && operator != '-' && operator != '*' && operator != '%'){
                System.out.println("연산자는 +, -, *, % 중 하나를 입력해야합니다.");
                break;
            }

            result = calculator.result(num1, num2, operator);
            System.out.println("결과 : " + result);
            // 결과값 저장
            calculator.setQueue(result);

            // 삭제 여부 체크
            System.out.println("저장된 결과값을 삭제하시겠습니까? (yes 입력시 가장 처음 저장된 결과값 제거)");
            String delYn = sc.next();
            if(delYn.equals("yes")){
                System.out.println("삭제된 값 : " + calculator.getQueue());
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
