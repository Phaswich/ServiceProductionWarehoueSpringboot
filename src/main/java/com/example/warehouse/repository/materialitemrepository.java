package com.example.warehouse.repository;

import com.example.warehouse.domain.materialitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface materialitemrepository extends JpaRepository<materialitem, Integer>{
    List<materialitem> findByproductionorderid(int productionorderid);
}
