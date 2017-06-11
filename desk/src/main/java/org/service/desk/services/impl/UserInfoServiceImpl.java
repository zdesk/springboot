package org.service.desk.services.impl;

import java.util.List;

import org.service.desk.entities.dao.UserInformationRepo;
import org.service.desk.entities.models.User;
import org.service.desk.services.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends UserInformationService {
	
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

}
