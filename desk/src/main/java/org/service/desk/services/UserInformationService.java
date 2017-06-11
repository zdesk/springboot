package org.service.desk.services;

import java.util.List;

import org.service.desk.entities.models.User;
import org.springframework.stereotype.Service;

@Service
public abstract class UserInformationService {
	public abstract boolean insertUserInfo(User userInfo);
	public abstract User findUserByUserName(String userName);
}
