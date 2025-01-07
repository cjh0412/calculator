package example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private int num1, num2;
    private char operator;
    //    private Queue<Integer> queue = new LinkedList<>();
    // list 생성
    List<Integer> list = new ArrayList<>();

    // 생성자
    Calculator() {
    }

    Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    Calculator(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    Calculator(List<Integer> list) {
        this.list = list;
    }

    // 컬렉션 getter, setter
    public Integer getList() {
        return list.get(list.size() - 1);
    }

    public void setList(int result) {
        list.add(result);
    }

    int delete() {
        return list.remove(0);
    }

    // 메서드
    // 덧셈
    int plus(int num1, int num2) {
        return num1 + num2;
    }

    // 뺄셈
    int minus(int num1, int num2) {
        return num1 - num2;
    }

    // 곱셈
    int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    // 나눗셈
    int division(int num1, int num2) {
        return num1 / num2;
    }

    // 사칙연산 구분하기
    int result(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = plus(num1, num2);
                break;
            case '-':
                result = minus(num1, num2);
                break;
            case '*':
                result = multiplication(num1, num2);
                break;
            case '/':
                result = division(num1, num2);
                break;
        }
        return result;
    }

}
