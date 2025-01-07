package example.calculator3;

import example.calculator3.exception.ErrorCode;
import example.calculator3.exception.ErrorException;

import java.util.Arrays;

// 연산자 구분
public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String type;

    OperatorType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // 연산 기호를 입력받아 type 매핑을 위한 메서드
    public static OperatorType changeType(String type) throws Exception {
        // values : OperatorType의 모든 값(+, -, *, /)
        return Arrays.stream(OperatorType.values())
                .filter(operator -> operator.getType().equals(type))
                .findAny()
                .orElseThrow(() -> new ErrorException(ErrorCode.WRONG_OPERATOR));
    }
}

