package com.example.warehouse.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class inventory {

    @Id
    private String materialnumber ;
    private String material_description ;
    private int quantity ;

    public inventory() {
        super();
    }

    public inventory( String materialnumber, String material_description, int quantity) {
        this.materialnumber = materialnumber;
        this.material_description = material_description;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
