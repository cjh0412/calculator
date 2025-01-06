package example.calculator3;

// 연산자 구분
public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("%");

    private final String type;

    OperatorType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // 연산 기호를 입력받아 type 매핑을 위한 메서드
    public static OperatorType changeType(String type){
        // values : OperatorType의 모든 값(+, -, *, %)
        for(OperatorType operatorType : values()){
            if(operatorType.getType().equals(type)){
                return operatorType;
            }
        }
        throw new RuntimeException(new Exception().getMessage());
    }


}

