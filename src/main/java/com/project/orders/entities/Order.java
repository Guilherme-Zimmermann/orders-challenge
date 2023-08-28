package com.project.orders.entities;

import java.io.Serializable;
import java.time.Instant;

import com.project.orders.entities.enums.OrderStatus;

public class Order implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Instant moment;

    private Integer orderStatus;

    public Order(){
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

    public void setOrderStatus(OrderStatus orderStatus){
        if (orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
