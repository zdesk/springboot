package org.service.desk.services;

import java.util.List;

import org.service.desk.entities.models.UserInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class UserInfoService {
	public abstract boolean insertUserInfo(UserInformation userInfo);
	public abstract List<UserInformation> findUserByFirstName(String firstName);
}
