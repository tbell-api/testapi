package kr.co.tbell.testapi.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.tbell.testapi.model.entity.OrderGroup;
import kr.co.tbell.testapi.model.enumclass.OrderType;

@SpringBootTest
public class OrderGroupRepositoryTest {

	@Autowired
	private OrderGroupRepository orderGroupRepository;
	
	@Test
	public void create() {
		
		OrderGroup orderGroup = new OrderGroup();
		orderGroup.setStatus("COMPLETE");
		orderGroup.setOrderType(OrderType.ALL);
		orderGroup.setRevAddress("서울시 강남구");
		orderGroup.setRevName("홍길동");
		orderGroup.setPaymentType("CARD");
		orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
		orderGroup.setTotalQuantity(1);
		orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
		orderGroup.setArrivalDate(LocalDateTime.now());
		orderGroup.setCreatedAt(LocalDateTime.now());
		orderGroup.setCreatedBy("AdminServer");
//		orderGroup.setUserId(1L);
		
		OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
		
		Assertions.assertNotNull(newOrderGroup);
		
	}
	
}
