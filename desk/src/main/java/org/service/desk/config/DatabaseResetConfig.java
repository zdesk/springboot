package org.service.desk.config;

import java.util.ArrayList;
import java.util.List;

import org.service.desk.entities.dao.UserInformationRepo;
import org.service.desk.entities.models.Authority;
import org.service.desk.entities.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DatabaseResetConfig implements CommandLineRunner{

	@Autowired
	private UserInformationRepo userInfoDao;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		User adminUser = new User();
		
		adminUser.setId(10L);
		adminUser.setUsername("admin");
		adminUser.setPassword("$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi");
		adminUser.setEnabled(true);
		userInfoDao.save(adminUser);
		
	}
	
}
