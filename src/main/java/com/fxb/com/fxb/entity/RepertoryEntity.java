package com.fxb.com.fxb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_repertoty")
public class RepertoryEntity {
    @Id
    @GenericGenerator(name="gid",strategy = "uuid")
    @GeneratedValue(generator = "gid")
    @Column(length = 32)
    private  String id;
    @Column(length = 48)
    private  String goodsType;
    private int goodsNum;
    private int nowGoodsNum;
}
