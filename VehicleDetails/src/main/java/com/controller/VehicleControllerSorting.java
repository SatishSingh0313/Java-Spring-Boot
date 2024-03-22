package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.VehicleRepositrySorting;
import com.dto.Vehicle;

@RestController
public class VehicleControllerSorting {
		
	@Autowired
	VehicleRepositrySorting vRepoSort;
	
	@GetMapping("/vsorting/{sort}")
	public List<Vehicle> getVehicleSorting(@PathVariable String sort) {
		
		return vRepoSort.findAll(Sort.by(Sort.Direction.ASC,sort));
		
	}
}
