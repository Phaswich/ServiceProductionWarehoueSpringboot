package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface production_orders_repository extends JpaRepository<productionorders, Integer>{
    List<productionorders> findByproductionorderid(int productionorderid);
}
