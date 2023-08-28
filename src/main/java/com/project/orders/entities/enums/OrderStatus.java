package com.project.orders.entities.enums;

public enum OrderStatus {
    
    PENDING_PAYMENT(1),
    PAID(2),
    CANCELED(3);

    private int code;

    private OrderStatus(int code){
            this.code = code;
        }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(Integer code){
        for (OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code!");
    }
}
