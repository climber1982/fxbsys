package com.fxb.com.fxb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
public class UserEntity {
    @Id
    @GenericGenerator(name = "useruuid",strategy = "uuid")
    @GeneratedValue(generator = "useruuid")
    @Column(length = 32)
    private String id;
    @Column(length = 48)
    private String carId;
    private int isPay;
    @Column(length = 48)
    private  String itName;
    @Column(length = 48)
    private  String qq;
    @Column(length = 13)
    private  String tel;
    @Column(length = 48)
    private String type;
    @Column(length = 48)
    private String userName;
    @ManyToOne
    @JoinColumn(name = "tr_id")
    private TravelEntity travelEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getIsPay() {
        return isPay;
    }

    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }

    public String getItName() {
        return itName;
    }

    public void setItName(String itName) {
        this.itName = itName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TravelEntity getTravelEntity() {
        return travelEntity;
    }

    public void setTravelEntity(TravelEntity travelEntity) {
        this.travelEntity = travelEntity;
    }
}
