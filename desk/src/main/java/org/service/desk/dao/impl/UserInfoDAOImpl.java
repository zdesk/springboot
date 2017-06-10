package org.service.desk.dao.impl;

import org.service.desk.entities.dao.UserInfoDAO;
import org.service.desk.entities.models.UserInformation;

import java.util.List;


//Custom methods available for DB interaction and retreival of data.
public interface UserInfoDAOImpl{
	public List<UserInformation> findByFirstName(String name);
	public List<UserInformation> findByLastName(String name);
	public List<UserInformation> findByEmail(String email);
	public List<UserInformation> findByPhoneNo(String phoneNo);
	public List<UserInformation> findByUserIdentity(String phoneNo);
}



class UserInfoCustomDAOImpl implements UserInfoDAOImpl {

	@Override
	public List<UserInformation> findByFirstName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInformation> findByLastName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInformation> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInformation> findByPhoneNo(String phoneNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInformation> findByUserIdentity(String phoneNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
