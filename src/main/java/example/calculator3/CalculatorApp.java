package example.calculator3;

import java.util.Scanner;

public class CalculatorApp {
    //제네릭 호출
    // main에서 startApp을 호출시마다 calculator 재할당하지 않도록, static final 추가
    static final ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

    public static boolean startApp() throws Exception{
        Scanner sc = new Scanner(System.in);
        String operatorInput;

        System.out.print("첫 번째 숫자를 입력하세요: ");
        Double num1 = calculator.parseNum(sc.nextLine());

        System.out.print("두 번째 숫자를 입력하세요: ");
        Double num2 = calculator.parseNum(sc.nextLine());

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

        // 정수 실수 체크
        System.out.print("결과 : ");
        // 결과값이 정수인 경우
        if(calculator.isInteger(calculator.getLastValue())){
            System.out.println(calculator.getLastValue().intValue());
        // 결과값이 실수인 경우
        }else{
            System.out.println(calculator.getLastValue());
        }

        if(calculator.getList().isEmpty()){
            System.out.println("해당 연산 값 보다 더 큰 저장된 연산 결과는 존재하지 않습니다.");
        }else {
            System.out.println("해당 연산 값 보다 더 큰 저장된 연산 결과: " + calculator.getList());
        }

        // 삭제 여부 체크
        System.out.println("저장된 결과값을 삭제하시겠습니까? (yes 입력시 가장 처음 저장된 결과값인 제거)");
        String delYn = sc.next();
        if (delYn.equals("yes")) {
            System.out.println("삭제된 값 : " + calculator.delete());
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
