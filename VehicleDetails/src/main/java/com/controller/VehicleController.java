package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.dao.VehicleRepositry;
import com.dto.Vehicle;
@CrossOrigin
@RestController
public class VehicleController {
	
	@Autowired
	VehicleRepositry vRepo;
	
	@PostMapping("/vsave")
	public void saveVehicle(@RequestBody Vehicle v) {
		vRepo.save(v);
	}
	
	@GetMapping("/vget")
	public List<Vehicle> getAllVehicle() {
		return vRepo.findAll();
	}
	
	@GetMapping("/vget/{id}")
	public Vehicle getVehicleById(@PathVariable Integer id) {
		return vRepo.findById(id).get();
	}
	
	@PutMapping("/vsave/{id}")
	Vehicle updateVehicle(@RequestBody Vehicle v, @PathVariable Integer id) {
		vRepo.findById(id);
		return vRepo.save(v);
	}
	
	@DeleteMapping("/vdelete/{id}")
	public void deleteVehicle(@PathVariable Integer id) {
		vRepo.deleteById(id);	
	}
	
} 
