package com.Login.Service;

import com.Login.Module.User;

public interface UserService {
	
	 User addUser(User u);
	 
	 Object login(String usernameOremail,Integer password);
}
