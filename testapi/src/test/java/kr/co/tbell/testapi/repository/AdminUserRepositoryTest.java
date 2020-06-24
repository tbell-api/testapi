package kr.co.tbell.testapi.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.tbell.testapi.model.entity.AdminUser;

@SpringBootTest
public class AdminUserRepositoryTest {

	@Autowired
	private AdminUserRepository adminUserRepository;
	
	@Test
	public void create() {
		
		AdminUser adminUser = new AdminUser();
		
//		adminUser.setAccount("AdminUser04");
//		adminUser.setPassword("AdminUser04");
//		adminUser.setStatus("REGISTERED");
//		adminUser.setRole("PARTNER");
//		adminUser.setCreatedAt(LocalDateTime.now());
//		adminUser.setCreatedBy("AdminServer");
		
		AdminUser newAdminUser = adminUserRepository.save(adminUser);
		Assertions.assertNotNull(newAdminUser);
		
		newAdminUser.setAccount("CHANGE");
		adminUserRepository.save(newAdminUser);
	}
	
}
