package org.service.desk.services.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.service.desk.entities.dao.UserInformationRepo;
import org.service.desk.entities.models.User;
import org.service.desk.jwtauth.JwtUserFactory;
import org.service.desk.services.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInformationService {
	
	@Value("${jwt.secret}")
	private String mySecret;
	
	@Autowired
	private UserInformationRepo userInfoRepo;
	
	public boolean insertUserInfo(User userInfo){
		
		System.err.println(BCrypt.gensalt(8));
		userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
		//userInfo.setPassword(BCrypt.hashpw(userInfo.getPassword(),BCrypt.gensalt(8)));
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
