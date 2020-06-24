package kr.co.tbell.testapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.tbell.testapi.model.entity.Category;
import kr.co.tbell.testapi.model.entity.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    List<Partner> findByCategory(Category category);
}
