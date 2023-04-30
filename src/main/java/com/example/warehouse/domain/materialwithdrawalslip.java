package com.example.warehouse.domain;

import jakarta.persistence.*;
@Entity
@Table(name = "materialwithdrawalslip")
public class materialwithdrawalslip {
    @Id
    private int productionorderid;
    private int production_quantity;
    private String date	;
    private String issue_by;
    private String received_by;
    private String location;
    private String status_material;

    public materialwithdrawalslip() {
        super();
    }

    public materialwithdrawalslip(int productionorderid,
                                  int production_quantity,
                                  String date,
                                  String issue_by,
                                  String received_by,
                                  String location,
                                  String status_material) {
        this.productionorderid = productionorderid;
        this.production_quantity = production_quantity;
        this.date = date;
        this.issue_by = issue_by;
        this.received_by = received_by;
        this.location = location;
        this.status_material = status_material;
    }

    public int getProductionorderid() {
        return productionorderid;
    }

    public int getProduction_quantity() {
        return production_quantity;
    }

    public String getDate() {
        return date;
    }

    public String getIssue_by() {
        return issue_by;
    }

    public String getReceived_by() {
        return received_by;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus_material() {
        return status_material;
    }

    public void setProductionorderid(int productionorderid) {
        this.productionorderid = productionorderid;
    }

    public void setProduction_quantity(int production_quantity) {
        this.production_quantity = production_quantity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIssue_by(String issue_by) {
        this.issue_by = issue_by;
    }

    public void setReceived_by(String received_by) {
        this.received_by = received_by;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus_material(String status_material) {
        this.status_material = status_material;
    }
}
