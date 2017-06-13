package org.service.desk.services;

import java.util.List;

import org.service.desk.entities.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserInformationService extends UserDetailsService  {
	public abstract boolean insertUserInfo(User userInfo);
	public abstract User findUserByUserName(String userName);
}
