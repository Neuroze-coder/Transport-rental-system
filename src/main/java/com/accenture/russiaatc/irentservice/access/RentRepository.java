package com.accenture.russiaatc.irentservice.access;

import com.accenture.russiaatc.irentservice.model.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentRepository extends JpaRepository <Rent, Long> {

    @Query("SELECT r from Rent r where r.user.id = ?1")
    List<Rent> findByUserId (Long userId);
}
