package com.Login.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Login.Exception.ResourceNotFoundException;
import com.Login.Module.User;
import com.Login.Repository.UserRepository;
import com.Login.Service.UserService;

@Service
public class UserImpl implements UserService {
	@Autowired
	UserRepository uRepo;

	@Override
	public User addUser(User u) {
		
		return uRepo.save(u);
	}

	
	@Override
	public Object login(String usernameOremail, Integer password) {
		User u=uRepo.findByUserNameOrEmail(usernameOremail, usernameOremail);
		if(u!=null) {
			if(password.equals(u.getPassword())) {
				return u;
			}
			
			else {
				try {
					throw new ResourceNotFoundException("User","usernameOremail",usernameOremail);
				}
				catch(ResourceNotFoundException e){
					return e.getMessage();
				}
			}
		}
		else {
			try {
				throw new ResourceNotFoundException("User","usernameOremail",usernameOremail);
			}
			catch(ResourceNotFoundException e){
				return e.getMessage();
			}
		}
	
	}
	
	}

