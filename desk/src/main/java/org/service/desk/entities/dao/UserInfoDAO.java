package org.service.desk.entities.dao;

import java.util.List;

import org.service.desk.entities.models.UserInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoDAO extends MongoRepository<UserInformation, String>{

		public List<UserInformation> findByFirstName(String name);
}