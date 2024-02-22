package desafio.picPay.domain.enums;

public enum Type {
    CUSTOMER(1),
    SELLER(2);

    private int code;

    private Type(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Type valueOf(int code){
        for (Type value : Type.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Type code!");
    }
}