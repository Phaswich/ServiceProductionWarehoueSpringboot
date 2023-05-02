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
    private String com_dateraw;
    private int com_quantity_completeraw;
    private int com_scrap_quantityraw;
    private String com_completed_byraw;
    private String com_dateass;
    private int com_quantity_completeass;
    private int com_scrap_quantityass;
    private String com_completed_byass;
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

    public void setMaterial_number(String material_number) {
        this.material_number = material_number;
    }

    public String getMaterial_description() {
        return material_description;
    }

    public void setMaterial_description(String material_description) {
        this.material_description = material_description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCom_dateraw() {
        return com_dateraw;
    }

    public void setCom_dateraw(String com_dateraw) {
        this.com_dateraw = com_dateraw;
    }

    public int getCom_quantity_completeraw() {
        return com_quantity_completeraw;
    }

    public void setCom_quantity_completeraw(int com_quantity_completeraw) {
        this.com_quantity_completeraw = com_quantity_completeraw;
    }

    public int getCom_scrap_quantityraw() {
        return com_scrap_quantityraw;
    }

    public void setCom_scrap_quantityraw(int com_scrap_quantityraw) {
        this.com_scrap_quantityraw = com_scrap_quantityraw;
    }

    public String getCom_completed_byraw() {
        return com_completed_byraw;
    }

    public void setCom_completed_byraw(String com_completed_byraw) {
        this.com_completed_byraw = com_completed_byraw;
    }

    public String getCom_dateass() {
        return com_dateass;
    }

    public void setCom_dateass(String com_dateass) {
        this.com_dateass = com_dateass;
    }

    public int getCom_quantity_completeass() {
        return com_quantity_completeass;
    }

    public void setCom_quantity_completeass(int com_quantity_completeass) {
        this.com_quantity_completeass = com_quantity_completeass;
    }

    public int getCom_scrap_quantityass() {
        return com_scrap_quantityass;
    }

    public void setCom_scrap_quantityass(int com_scrap_quantityass) {
        this.com_scrap_quantityass = com_scrap_quantityass;
    }

    public String getCom_completed_byass() {
        return com_completed_byass;
    }

    public void setCom_completed_byass(String com_completed_byass) {
        this.com_completed_byass = com_completed_byass;
    }

    public String getRec_date() {
        return rec_date;
    }

    public void setRec_date(String rec_date) {
        this.rec_date = rec_date;
    }

    public int getRec_quantity() {
        return rec_quantity;
    }

    public void setRec_quantity(int rec_quantity) {
        this.rec_quantity = rec_quantity;
    }

    public String getRec_completed_by() {
        return rec_completed_by;
    }

    public void setRec_completed_by(String rec_completed_by) {
        this.rec_completed_by = rec_completed_by;
    }

    public String getRec_received_by() {
        return rec_received_by;
    }

    public void setRec_received_by(String rec_received_by) {
        this.rec_received_by = rec_received_by;
    }

    public int getPlanned_order_number() {
        return planned_order_number;
    }

    public void setPlanned_order_number(int planned_order_number) {
        this.planned_order_number = planned_order_number;
    }

    public String getAuthorized_by() {
        return authorized_by;
    }

    public void setAuthorized_by(String authorized_by) {
        this.authorized_by = authorized_by;
    }

    public String getDate_authorized() {
        return date_authorized;
    }

    public void setDate_authorized(String date_authorized) {
        this.date_authorized = date_authorized;
    }

    public productionorders(String material_number, String material_description, int quantity, String com_dateRaw, int com_quantity_completeRaw, int com_scrap_quantityraw, String com_completed_byraw, String com_dateass, int com_quantity_completeass, int com_scrap_quantityass, String com_completed_byass, String rec_date, int rec_quantity, String rec_completed_by, String rec_received_by, int planned_order_number, String authorized_by, String date_authorized) {

        this.material_number = material_number;
        this.material_description = material_description;
        this.quantity = quantity;
        this.com_dateraw = com_dateRaw;
        this.com_quantity_completeraw = com_quantity_completeRaw;
        this.com_scrap_quantityraw = com_scrap_quantityraw;
        this.com_completed_byraw = com_completed_byraw;
        this.com_dateass = com_dateass;
        this.com_quantity_completeass = com_quantity_completeass;
        this.com_scrap_quantityass = com_scrap_quantityass;
        this.com_completed_byass = com_completed_byass;
        this.rec_date = rec_date;
        this.rec_quantity = rec_quantity;
        this.rec_completed_by = rec_completed_by;
        this.rec_received_by = rec_received_by;
        this.planned_order_number = planned_order_number;
        this.authorized_by = authorized_by;
        this.date_authorized = date_authorized;
    }



}
