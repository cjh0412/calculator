package example.calculator3;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalculatorApp {
    //제네릭 호출
    // main에서 startApp을 호출시마다 calculator 재할당하지 않도록, static final 추가
    static final ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

    public static boolean startApp() throws Exception{
        Scanner sc = new Scanner(System.in);
        String operatorInput;

        System.out.print("첫 번째 숫자를 입력하세요: ");
        double num1 = calculator.isNumber(sc.nextLine());

        System.out.print("두 번째 숫자를 입력하세요: ");
        double num2 = calculator.isNumber(sc.nextLine());

        // 연산 숫자 저장
        calculator.setNum(num1, num2);

        System.out.print("사칙연산 기호를 입력하세요: ");
        operatorInput = sc.next();
        // 연산자 체크
        OperatorType operator = OperatorType.changeType(operatorInput);

        // 나눗셈 분모 체크
        calculator.chkDivide(operatorInput);

        // 사칙연산 진행 및 저장
        calculator.setList(calculator.result(calculator.getNum1(), calculator.getNum2(), operator));

        // 결과 값 불러오기
        calculator.getLastValue();

        // 특정값 입력
        System.out.print("특정 값을 입력하세요 : ");
        double comPareValue = calculator.isNumber(sc.next());
        calculator.getList(comPareValue);

        // 삭제 여부 체크
        System.out.println("저장된 결과값을 삭제하시겠습니까? (yes 입력시 가장 처음 저장된 결과값인 제거)");
        String delYn = sc.next();
        if (delYn.equals("yes")) {
            calculator.delete();
        }

        // 종료 여부 체크
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        String endYn = sc.next();

        if(endYn.equals("exit")) {
            return false;
        }

        return true;
    }
}
