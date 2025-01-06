package example.calculator3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //제네릭 호출
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<Double>();
        Scanner sc = new Scanner(System.in);
        String operatorIntput;

        while (true) {
            // 양의 정수2, 사칙연산 기호 입력받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            if (!sc.hasNextDouble()) {
                System.out.println("입력된 값이 숫자가 아닙니다.");
                break;
            } else {
                calculator.setNum1(sc.nextDouble());

                if (calculator.getNum1() < 0) {
                    System.out.println("입력된 값이 0을 포함한 양의 정수가 아닙니다.");
                    break;
                }
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            if (!sc.hasNextDouble()) {
                System.out.println("입력된 값이 숫자가 아닙니다.");
                break;
            } else {
                calculator.setNum2(sc.nextDouble());
                if (calculator.getNum2() < 0) {
                    System.out.println("입력된 값이 0을 포함한 양의 정수가 아닙니다.");
                    break;
                }
            }
            System.out.print("사칙연산 기호를 입력하세요: ");
            operatorIntput = sc.next();
            if (calculator.getNum2() == 0 && operatorIntput == "%") {
                System.out.println("나눗셈 연산시 분모(두번째 숫자)는 0을 입력할 수 없습니다.");
                break;
            }
            ;

            if (operatorIntput.equals("+") && operatorIntput.equals("-") && operatorIntput.equals("*") && operatorIntput.equals("%")) {
                System.out.println("연산자는 +, -, *, % 중 하나를 입력해야합니다.");
                break;
            }

            // 연산자 체크
            OperatorType operator = OperatorType.changeType(operatorIntput);

            // 사칙연산 진행 및 저장
            calculator.setList(calculator.result(calculator.getNum1(), calculator.getNum2(), operator));

            // 결과 값 불러오기
            System.out.println("결과 : " + calculator.getList());
            System.out.println("해당 연산 값 보다 더 큰 저장된 연산 결과: " + calculator.getChkList());

            // 삭제 여부 체크
            System.out.println("저장된 결과값을 삭제하시겠습니까? (yes 입력시 가장 처음 저장된 결과값인 제거)");
            String delYn = sc.next();
            if (delYn.equals("yes")) {
                System.out.println("삭제된 값 : " + calculator.delete());
            }

            // 종료 여부 체크
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String endYn = sc.next();

            if (endYn.equals("exit")) {
                break;
            }
        }

    }
}

