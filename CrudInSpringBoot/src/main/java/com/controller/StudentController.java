package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dao.StudentRepository;
import com.dto.Student;

@RestController
public class StudentController {

	@Autowired
	 StudentRepository uRepository;

	@PostMapping("/save")
	public	void saveUser(@RequestBody Student user) {
		 uRepository.save(user);
	}

	@GetMapping("/get")
	public List<Student> getAllUser() {
		return uRepository.findAll();
	}

	@GetMapping("/getid/{id}")
	public Student getUserById(@PathVariable Long id) {
		return uRepository.findById(id).get();
	}

	@PutMapping("/put/{id}")
	Student updateUser(@RequestBody Student User, @PathVariable Long id) {
		uRepository.findById(id);
		return uRepository.save(User);
	}


  @DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) {
		uRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
