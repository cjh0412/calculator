package example.calculator3;

import example.calculator3.exception.ErrorCode;
import example.calculator3.exception.ErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// 정규표현식을 다루는 패키지


public class ArithmeticCalculator<T extends Number> {
    // 실수형 체크 정규표현식
    private static final String NUMBER_REG = "^-?[0-9]+(\\.[0-9]+)?$";

    // input 값은 숫자 타입에 관계없이 저장
    private T num1, num2;
    private List<T> list = new ArrayList<>();

    public void setNum(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public T getNum1() {
        return num1;
    }

    public T getNum2() {
        return num2;
    }

    // 가장 마지막에 저장된 값 출력
    void getLastValue() {
        System.out.print("결과 : ");
        isInteger(list.get(list.size() - 1));
    }

    // 삭제
    void delete() {
        System.out.print("삭제된 값 : ");
        isInteger(list.remove(0));
    }

    // 저장
    public void setList(T result) {
        list.add(result);
    }

    public void getList(T compareValue) {
        // 마지막에 입력된 값보다 큰 값 출력
//      오류 원인 1. T는 Number를 상속 받았더라도 추상적인 형태를 지님
//               2. 숫자타입이 아닌 T의 경우 연산자(+,-,*,/,>,>= ....)를 사용하기 위해선 기본타입 int, double 등으로 변경 필요!
//               3. mapToDouble(Double::parseDouble) :  String -> double형태로 변환하는 것이기 때문에 오류 발생
//        list.stream().filter(i -> i > getList()).mapToDouble(Double::parseDouble).toList();

// return list.stream().filter(i -> i.doubleValue() > compareValue.doubleValue()).toList();
        printList(
                list.stream()
                .filter(i -> i.doubleValue() > compareValue.doubleValue()) // 입력값과 비교
                .map(i -> { // 정수 실수 구분
                    if(i.doubleValue() == i.intValue()){
                        return i.intValue();
                    }else {
                        return i.doubleValue() ;
                    }
                })
                .toList()
        );
        
    }

    // 숫자여부 체크(num1, num2)
    public double isNumber(String num) throws Exception {
        if (!Pattern.matches(NUMBER_REG, String.valueOf(num))) {
            throw new ErrorException(ErrorCode.WRONG_TYPE);
        }

        return Double.parseDouble(num);
    }

    // 나눗셈 분모 체크
    public void chkDivide(String operatorIntput) throws Exception {
        if ((getNum2().doubleValue() == 0) && operatorIntput.equals("/")) {
            throw new ErrorException(ErrorCode.WRONG_DIVISION);
        }
    }

    // 정수 여부 체크
    public void isInteger(T result) {
        boolean integerYn = result.doubleValue() == result.intValue();
        
        //결과값 출력
        printValue(integerYn, result);
    }

    // 사칙 연산시 제네릭 타입의 경우 연산 불가
    // double형으로 변환 뒤 연산
    double result(T num1, T num2, OperatorType operator) {
        double result = 0;
        switch (operator) {
            case PLUS:
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case MINUS:
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case MULTIPLY:
                result = num1.doubleValue() * num2.doubleValue();
                break;
            case DIVIDE:
                result = num1.doubleValue() / num2.doubleValue();
                break;
        }
        return roundValue(result);
    }

    // 소수점 2자리수 이상은 반올림한다
    double roundValue(double result) {
        return (double) Math.round(result * 100) / 100;
    }

    // 정수여부 체크후 결과값 출력
    void printValue(boolean integerYn, T result){
        if(integerYn){
            System.out.println(result.intValue());;
        }else {
            System.out.println(result.doubleValue());
        }
    }

    // 리스트 출력
    // <? extends Number> intList, doubleList 등 다양한 리스트를 하나의 메서드에서 처리하고 싶을때 사용
    void printList(List<? extends Number> resultList){
        if(resultList.isEmpty()){
            System.out.println("해당 연산 값 보다 더 큰 저장된 연산 결과는 존재하지 않습니다.");
        }
        System.out.println("해당 연산 값 보다 더 큰 저장된 연산 결과: " + resultList);
    }

}
