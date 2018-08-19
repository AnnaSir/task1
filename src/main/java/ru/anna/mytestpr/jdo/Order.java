package ru.anna.mytestpr.jdo;

import java.util.Date;

public class Order {

    private Long orderId;
    private Long userId;
    private Long tourId;
    private Boolean confirmed;
    private Date timeKey;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Date getTimeKey() {
        return timeKey;
    }

    public void setTimeKey(Date time_key) {
        this.timeKey = time_key;
    }
}
