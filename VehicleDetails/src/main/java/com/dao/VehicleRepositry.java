package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.Vehicle;

public interface VehicleRepositry extends JpaRepository<Vehicle, Integer> {

}
