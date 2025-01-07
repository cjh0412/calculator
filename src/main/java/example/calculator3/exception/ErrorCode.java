package example.calculator3.exception;

import java.nio.file.Watchable;
import java.security.PublicKey;

public enum ErrorCode {
      WRONG_TYPE("입력된 값이 숫자가 아닙니다.")
    , WRONG_DIVISION("나눗셈 연산시 분모(두번째 숫자)는 0을 입력할 수 없습니다.")
    , WRONG_OPERATOR("연산자는 +, -, *, / 중 하나를 입력해야합니다.") ;

    private final String error;

    ErrorCode(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }
}

