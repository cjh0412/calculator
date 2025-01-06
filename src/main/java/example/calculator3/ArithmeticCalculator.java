package example.calculator3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator <T extends Number> {
    // input 값은 숫자 타입에 관계없이 저장
    private T num1 , num2;
    List<T> list = new ArrayList<>();


    public void setNum1(T num1) {
        this.num1 = num1;
    }

    public void setNum2(T num2) {
        this.num2 = num2;
    }

    public T getNum1() {
        return num1;
    }

    public T getNum2() {
        return num2;
    }

    // 가장 마지막에 저장된 값 출력
    public T getList(){
        return list.get(list.size()-1);
    }

    // 삭제
    T delete(){
        return list.remove(0);
    }

    // 저장
    public void setList(T result) {
        list.add(result);
    }

    public List<T> getChkList(){
        // 마지막에 입력된 값보다 큰 값 출력
//      오류 원인 1. T는 Number를 상속 받았더라도 추상적인 형태를 지님
//               2. 숫자타입이 아닌 T의 경우 연산자(+,-,*,/,>,>= ....)를 사용하기 위해선 기본타입 int, double 등으로 변경 필요!
//               3. mapToDouble(Double::parseDouble) :  String -> double형태로 변환하는 것이기 때문에 오류 발생
//        list.stream().filter(i -> i > getList()).mapToDouble(Double::parseDouble).toList();
        return list.stream().filter(i -> i.doubleValue() > getList().doubleValue()).toList();
    }

    // 사칙 연산시 제네릭 타입의 경우 연산 불가
    // double형으로 변환 뒤 연산
    double result(T num1, T num2, OperatorType operator){
        double result = 0;
        switch (operator){
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
        return result;
    }

}