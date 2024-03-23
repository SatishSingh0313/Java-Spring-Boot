package com.dao;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dto.CarDetails;

public interface CarRepositry  extends JpaRepository<CarDetails, Integer>{
	
	public List<CarDetails> getDetailsBycolor(String color);
	
}
