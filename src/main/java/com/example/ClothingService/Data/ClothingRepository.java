package com.example.ClothingService.Data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface ClothingRepository  extends JpaRepository<Clothe,Integer> {

            @Query(value = "SELECT MAX(id) FROM `clothes_stock`", nativeQuery = true)
            Integer findMaxValue();

            @Query("SELECT p FROM Clothe p ORDER BY p.Clothe_Price DESC")
            List<Clothe> findAllClothesOrderedByPriceHightolow();

            @Query("SELECT p FROM Clothe p ORDER BY p.Clothe_Price ASC")
            List<Clothe> findAllClothesOrderedByPriceLowtoHigh();

            @Query("SELECT p FROM Clothe p  WHERE p.Clothe_Quantity=0 ")
            List<Clothe> findAllClothesOrderedByq_o();

            @Query("SELECT c FROM Clothe c ORDER BY c.id DESC")
            Page<Clothe> findLastFourClothes(Pageable pageable);

            @Query("SELECT c FROM Clothe c ORDER BY c.id DESC")
            Page<Clothe> findLatestClothe(Pageable pageable);

}
