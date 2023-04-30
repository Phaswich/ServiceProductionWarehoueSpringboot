package com.example.warehouse.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.domain.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface materialwithdrawalsliprepository extends JpaRepository<materialwithdrawalslip, Integer>{
    List<materialwithdrawalslip> findByproductionorderid(int productionorderid);
    @Modifying(clearAutomatically = true)
    @Query("update materialwithdrawalslip e set e.status_material = 'Procurement Process' where e.productionorderid = :productionorderid")
    void updatePropertyById(@Param("productionorderid") int productionorderid);

}
