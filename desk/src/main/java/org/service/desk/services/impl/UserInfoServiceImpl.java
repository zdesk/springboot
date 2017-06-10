package org.service.desk.services.impl;

import java.util.List;

import org.service.desk.entities.dao.UserInfoDAO;
import org.service.desk.entities.models.UserInformation;
import org.service.desk.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends UserInfoService {
	
	@Autowired
	private UserInfoDAO userInfoDao;
	
	public boolean insertUserInfo(UserInformation userInfo){
		userInfoDao.save(userInfo);
		return true;
	}

	@Override
	public List<UserInformation> findUserByFirstName(String firstName) {
		
		return userInfoDao.findByFirstName(firstName);
	}

	@Override
	public List<UserInformation> findUserByLastName(String lastName) {
		// TODO Auto-generated method stub
		if(lastName==null){
    		lastName="";
    	}
		return userInfoDao.findByLastName(lastName);
	}

	@Override
	public List<UserInformation> findUserByUserIdentity(String userIdentity) {
		// TODO Auto-generated method stub
		return userInfoDao.findByUserIdentity(userIdentity);
	}

}
