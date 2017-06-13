package org.service.desk.services.impl;

import java.util.List;

import org.service.desk.entities.dao.UserInformationRepo;
import org.service.desk.entities.models.User;
import org.service.desk.jwt.JwtUserFactory;
import org.service.desk.services.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInformationService {
	
	@Autowired
	private UserInformationRepo userInfoRepo;
	
	public boolean insertUserInfo(User userInfo){
		userInfoRepo.save(userInfo);
		return true;
	}

	@Override
	public User findUserByUserName(String userName) {
		
		return userInfoRepo.findByUsername(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userInfoRepo.findByUsername(username);

	        if (user == null) {
	            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
	        } else {
	            return JwtUserFactory.create(user);
	        }
	}

}
