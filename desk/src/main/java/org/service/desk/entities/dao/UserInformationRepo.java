package org.service.desk.entities.dao;


import org.service.desk.dao.impl.UserInfoDAOImpl;
import org.service.desk.entities.models.User;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserInformationRepo extends MongoRepository<User, String>, UserInfoDAOImpl{
	User findByUsername(String username);
}

