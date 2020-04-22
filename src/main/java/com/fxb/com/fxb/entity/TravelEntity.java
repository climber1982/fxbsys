package com.fxb.com.fxb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_travel")
public class TravelEntity {
    @Id
    @GenericGenerator(name="tid",strategy = "uuid")
    @GeneratedValue(generator = "tid")
    @Column(length = 32)
    private  String id;
    @Column(length = 48)
    private String endT;
    @Column(length = 48)
    private String lead;
    @Column(length = 48)
    private String startT;
    @Column(length = 48,name ="travelName" )
    private String travelName;
    @Column(length = 2)
    private String type;
    @Column(length = 48,name = "yearStr")
    private String yearStr;

    private int zt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndT() {
        return endT;
    }

    public void setEndT(String endT) {
        this.endT = endT;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public String getStartT() {
        return startT;
    }

    public void setStartT(String startT) {
        this.startT = startT;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYearStr() {
        return yearStr;
    }

    public void setYearStr(String yearStr) {
        this.yearStr = yearStr;
    }

    public int getZt() {
        return zt;
    }

    public void setZt(int zt) {
        this.zt = zt;
    }

}
