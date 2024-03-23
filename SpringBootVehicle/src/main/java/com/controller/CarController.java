package com.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.CarRepositry;
import com.dto.CarDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@RestController
public class CarController {
   @Autowired
	CarRepositry cRepo;
  
   @Autowired
    private EntityManager em;
     
   @PostMapping("/save")
     public CarDetails PostData(@RequestBody CarDetails c) {
    	 
    	 return cRepo.save(c);
     }
   
   @GetMapping("/get")
   public List<CarDetails> getDetails(){
	   return cRepo.findAll();
   }
   
   @GetMapping("/getById")
   public Optional<CarDetails> getDetailsId(@RequestParam int id){
	   return cRepo.findById(id);
   }
   
   @GetMapping("getByColor")
   public List<CarDetails> getByColor(@RequestParam  String color) {
	   return cRepo.getDetailsBycolor(color);
   }
  
   @GetMapping("/getSorted")
   public List<CarDetails> findAll(){
	   String qst="SELECT c FROM CarDetails c ORDER BY c.price,c.color";
	   TypedQuery<CarDetails> qu=em.createQuery(qst,CarDetails.class);
	   return qu.getResultList();
   }
     @GetMapping("/getByPrice")
   public List<CarDetails> findAllPrice(){
	   String qst="SELECT c FROM CarDetails c WHERE c.price>13000 ORDER BY c.price,c.color";
	   TypedQuery<CarDetails> qu=em.createQuery(qst,CarDetails.class);
	   return qu.getResultList();
   }
   
     @PutMapping("/update/{id}")
   public CarDetails updateDetails(@RequestBody CarDetails c,@PathVariable Integer id) {
	   cRepo.findById(id);
	   return cRepo.save(c);
   }
     @DeleteMapping("/delete/{id}")
     public void deleteData(@PathVariable int id) {
    	 cRepo.deleteById(id);
     }
   
   
   
   
   
   
   
   
   
   
   
   
   
}
   
   


