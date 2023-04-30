package com.example.warehouse.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "materialitem")
public class materialitem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  int productionorderid ;
    private String materialnumber;
    private String material_description;
    private int quantity_per_skateboard ;
    private int total_quantity_needed ;
    private int quantity_issued ;
    public materialitem() {
        super();
    }

    public materialitem( int productionorderid, String materialnumber, String material_description, int quantity_per_skateboard, int total_quantity_needed, int quantity_issued) {
        this.productionorderid = productionorderid;
        this.materialnumber = materialnumber;
        this.material_description = material_description;
        this.quantity_per_skateboard = quantity_per_skateboard;
        this.total_quantity_needed = total_quantity_needed;
        this.quantity_issued = quantity_issued;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProductionorderid() {
        return productionorderid;
    }

    public void setProductionorderid(int productionorderid) {
        this.productionorderid = productionorderid;
    }

    public String getMaterialnumber() {
        return materialnumber;
    }

    public void setMaterialnumber(String materialnumber) {
        this.materialnumber = materialnumber;
    }

    public String getMaterial_description() {
        return material_description;
    }

    public void setMaterial_description(String material_description) {
        this.material_description = material_description;
    }

    public int getQuantity_per_skateboard() {
        return quantity_per_skateboard;
    }

    public void setQuantity_per_skateboard(int quantity_per_skateboard) {
        this.quantity_per_skateboard = quantity_per_skateboard;
    }

    public int getTotal_quantity_needed() {
        return total_quantity_needed;
    }

    public void setTotal_quantity_needed(int total_quantity_needed) {
        this.total_quantity_needed = total_quantity_needed;
    }

    public int getQuantity_issued() {
        return quantity_issued;
    }

    public void setQuantity_issued(int quantity_issued) {
        this.quantity_issued = quantity_issued;
    }
}
