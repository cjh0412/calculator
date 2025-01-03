package example.calculator2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator2 {

    private int num1, num2;
    private char operator;
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
    // 수정
    public Integer getQueue() {
        return queue.poll();
    }
    // 삭제
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
        int result = 0;
        switch (operator){
            case '+' :
                result=  plus(num1 , num2);
            case '-' :
                result=  minus(num1 , num2);
            case '*' :
                result=  multiplication(num1 , num2);
            case '%' :
                result=  division(num1, num2);
        }
        return result;
    }
}
