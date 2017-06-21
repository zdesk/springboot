package org.service.desk.config;

import java.util.ArrayList;
import java.util.List;

import org.service.desk.entities.dao.UserInformationRepo;
import org.service.desk.entities.models.Authority;
import org.service.desk.entities.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		adminUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
		adminUser.setEnabled(true);
		
		User john = new User();		
		john.setId(11L);
		john.setUsername("john");
		john.setPassword(new BCryptPasswordEncoder().encode("john"));
		john.setEnabled(true);
		
		User arjun = new User();		
		arjun.setId(12L);
		arjun.setUsername("arjun");
		arjun.setPassword(new BCryptPasswordEncoder().encode("arjun"));
		arjun.setEnabled(true);
		
		
		userInfoDao.save(adminUser);
		userInfoDao.save(john);
		userInfoDao.save(arjun);
		
	}
	
}
