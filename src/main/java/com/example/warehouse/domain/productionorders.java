package com.example.warehouse.domain;

import jakarta.persistence.*;
@Entity
@Table(name = "productionorders")
public class productionorders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id ;
    private int productionorderid;
    private String material_number;
    private String material_description;
    private int quantity;
    private String com_date;
    private int com_quantity_complete;
    private int com_scrap_quantity;
    private String com_completed_by;
    private String rec_date;
    private int rec_quantity;
    private String rec_completed_by;
    private String rec_received_by;
    private int planned_order_number;
    private String authorized_by;
    private String date_authorized;

    public productionorders() {
        super();
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }


    public int getProductionorderid() {
        return productionorderid;
    }

    public void setProductionorderid(int productionorderid) {
        this.productionorderid = productionorderid;
    }

    public String getMaterial_number() {
        return material_number;
    }

    public String getMaterial_description() {
        return material_description;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCom_date() {
        return com_date;
    }

    public int getCom_quantity_complete() {
        return com_quantity_complete;
    }

    public int getCom_scrap_quantity() {
        return com_scrap_quantity;
    }

    public String getCom_completed_by() {
        return com_completed_by;
    }

    public String getRec_date() {
        return rec_date;
    }

    public int getRec_quantity() {
        return rec_quantity;
    }

    public String getRec_completed_by() {
        return rec_completed_by;
    }

    public String getRec_received_by() {
        return rec_received_by;
    }

    public int getPlanned_order_number() {
        return planned_order_number;
    }

    public String getAuthorized_by() {
        return authorized_by;
    }

    public String getDate_authorized() {
        return date_authorized;
    }





    public void setMaterial_number(String material_number) {
        this.material_number = material_number;
    }

    public void setMaterial_description(String material_description) {
        this.material_description = material_description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCom_date(String com_date) {
        this.com_date = com_date;
    }

    public void setCom_quantity_complete(int com_quantity_complete) {
        this.com_quantity_complete = com_quantity_complete;
    }

    public void setCom_scrap_quantity(int com_scrap_quantity) {
        this.com_scrap_quantity = com_scrap_quantity;
    }

    public void setCom_completed_by(String com_completed_by) {
        this.com_completed_by = com_completed_by;
    }

    public void setRec_date(String rec_date) {
        this.rec_date = rec_date;
    }

    public void setRec_quantity(int rec_quantity) {
        this.rec_quantity = rec_quantity;
    }

    public void setRec_completed_by(String rec_completed_by) {
        this.rec_completed_by = rec_completed_by;
    }

    public void setRec_received_by(String rec_received_by) {
        this.rec_received_by = rec_received_by;
    }

    public void setPlanned_order_number(int planned_order_number) {
        this.planned_order_number = planned_order_number;
    }

    public void setAuthorized_by(String authorized_by) {
        this.authorized_by = authorized_by;
    }

    public void setDate_authorized(String date_authorized) {
        this.date_authorized = date_authorized;
    }

    public productionorders( String material_number, String material_description, int quantity, String com_date, int com_quantity_complete, int com_scrap_quantity, String com_completed_by, String rec_date, int rec_quantity, String rec_completed_by, String rec_received_by, int planned_order_number, String authorized_by, String date_authorized) {
        this.material_number = material_number;
        this.material_description = material_description;
        this.quantity = quantity;
        this.com_date = com_date;
        this.com_quantity_complete = com_quantity_complete;
        this.com_scrap_quantity = com_scrap_quantity;
        this.com_completed_by = com_completed_by;
        this.rec_date = rec_date;
        this.rec_quantity = rec_quantity;
        this.rec_completed_by = rec_completed_by;
        this.rec_received_by = rec_received_by;
        this.planned_order_number = planned_order_number;
        this.authorized_by = authorized_by;
        this.date_authorized = date_authorized;
    }


}
