package kr.co.tbell.testapi.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.tbell.testapi.model.entity.Category;

@SpringBootTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void create() {
		// insert into category (created_at, created_by, title, type, updated_at, updated_by) values (?, ?, ?, ?, ?, ?)
		
		String type = "COMPUTER";
		String title = "컴퓨터";
		LocalDateTime craetedAt = LocalDateTime.now();
		String createdBy = "AdminServer";

		Category category = new Category();
		category.setType(type);
		category.setTitle(title);
		category.setCreatedAt(craetedAt);
		category.setCreatedBy(createdBy);
		
		Category newCategory = categoryRepository.save(category);
		
		Assertions.assertNotNull(newCategory);
		Assertions.assertEquals(newCategory.getType(), type);
		Assertions.assertEquals(newCategory.getTitle(), title);
		
	}
	
	@Test
	public void read() {
		// select * from category where id = 1;
		// Optional은 있을 수도 있고 없을 수도 있을 때 사용!
		Optional<Category> optionalCategory = categoryRepository.findById(1L);

		optionalCategory.ifPresent(c -> {
			System.out.println(c.getId());
			System.out.println(c.getType());
			System.out.println(c.getTitle());
		});
		
		// select * from category where type = 'COMPUTER';
		String type = "COMPUTER";
		Optional<Category> optionalCategory2 = categoryRepository.findByType(type);

		optionalCategory2.ifPresent(c -> {
			
			Assertions.assertEquals(c.getType(), type);
			
			System.out.println(c.getId());
			System.out.println(c.getType());
			System.out.println(c.getTitle());
		});
		
		
		
	}
	
}
