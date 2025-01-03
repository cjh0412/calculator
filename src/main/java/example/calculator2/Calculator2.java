package example.calculator2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator2 {

    private int num1, num2;
    private char operator;
    // 컬렉션 getter, setter 생성
    private Queue<Integer> queue = new LinkedList<>();
    // 생성자
    Calculator2() {
    }

    Calculator2(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    Calculator2(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    Calculator2(Queue<Integer> queue) {
        this.queue = queue;
    }

    // 컬렉션 getter, setter
    public Integer getQueue() {
        return queue.poll();
    }

    public void setQueue(int result) {
        queue.add(result);
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
    int multiplication(int num1, int num2){
        return num1 * num2;
    }

    // 나눗셈
    int division(int num1, int num2){
        return num1 / num2;
    }

    // 사칙연산 구분하기
    int result(int num1, int num2, char operator){
        switch (operator){
            case '+' :
                return plus(num1 , num2);
            case '-' :
                return minus(num1 , num2);
            case '*' :
                return multiplication(num1 , num2);
            case '%' :
                return division(num1, num2);
            default:
                System.out.println("잘못된 연산자를 입력하였습니다.");
                return 0;
        }
    }
}
