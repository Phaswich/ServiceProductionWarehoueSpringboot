package com.example.warehouse.repository;
import com.example.warehouse.domain.inventory;
import com.example.warehouse.domain.productionorders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface inventoryrepository extends JpaRepository<inventory, Integer> {
    List<inventory> findByMaterialnumber(String materialnumber);

}

