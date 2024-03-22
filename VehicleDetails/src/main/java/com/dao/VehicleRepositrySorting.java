package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.Vehicle;

public interface VehicleRepositrySorting extends JpaRepository<Vehicle, String> {

}
