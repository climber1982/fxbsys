package com.fxb.com.fxb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_order")
class RepertoryOrderEntity {
    @Id
    @GenericGenerator(name="oid",strategy = "uuid")
    @GeneratedValue(generator = "oid")
    @Column(length = 32)
    private  String id;
    @Column(length = 48)
    private String orderType;
    @Column(length = 48)
    private String activityName;
    private int outGoodsNum;
    private int inGoodsNum;
    private int zt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getOutGoodsNum() {
        return outGoodsNum;
    }

    public void setOutGoodsNum(int outGoodsNum) {
        this.outGoodsNum = outGoodsNum;
    }

    public int getInGoodsNum() {
        return inGoodsNum;
    }

    public void setInGoodsNum(int inGoodsNum) {
        this.inGoodsNum = inGoodsNum;
    }

    public int getZt() {
        return zt;
    }

    public void setZt(int zt) {
        this.zt = zt;
    }
}
