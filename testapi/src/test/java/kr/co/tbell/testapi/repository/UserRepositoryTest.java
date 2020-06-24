package kr.co.tbell.testapi.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.co.tbell.testapi.model.entity.User;
import kr.co.tbell.testapi.model.enumclass.UserStatus;

@SpringBootTest
public class UserRepositoryTest {

	// Dependency Injection (DI)
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void create() {
		
		String account = "Test03";
		String password = "Test03";
//		String status = "REGISTERED";
		String email = "Test03@gmail.com";
		String phoneNumber = "010-1111-3421";
		LocalDateTime registeredAt = LocalDateTime.now();
//		LocalDateTime createdAt = LocalDateTime.now();
//		String createdBy = "AdminServer";
		
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setStatus(UserStatus.REGISTERED);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setRegisteredAt(registeredAt);
//		user.setCreatedAt(createdAt);
//		user.setCreatedBy(createdBy);
		
		// Lombok의 Builder 패턴을 이용해 객체 생성
		// 초기화 되어야 하는 데이터들을 유동적으로 객체 생성 가능
		//	User u = User.builder().account(account).password(password).status(status).email(email).build();
		
		// Chain Method pattern
		// 객체의 업데이트에 사용 / 객체의 생성에는 Builder 패턴
		// User u = new User().setAccount("").setEmail("").setPassword("");
		
		User newUser = userRepository.save(user);
		
		Assertions.assertNotNull(newUser);
		
	}
	
	@Test
	@Transactional
	public void read() {
		
		User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
		
		// Optional을 이용해서 null값을 회피하는 쪽이 더 깔끔함
		if(user != null) {
			user.getOrderGroupList().stream().forEach(orderGroup -> {
	
				System.out.println("----------------- 주문묶음 -----------------");
				System.out.println("수령인 : " + orderGroup.getRevName());
				System.out.println("수령지 : " + orderGroup.getRevAddress());
				System.out.println("총금액 : " + orderGroup.getTotalPrice());
				System.out.println("총수량 : " + orderGroup.getTotalQuantity());

				System.out.println("----------------- 주문묶음 -----------------");
				orderGroup.getOrderDetailList().forEach(orderDetail -> {
					System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
					System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
					System.out.println("주문 상품 : " + orderDetail.getItem().getName());
					System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
					System.out.println("주문의 상태 : " + orderDetail.getStatus());
					System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());
				
					
				});
			});
		}
		
		Assertions.assertNotNull(user);
		
	}
}
