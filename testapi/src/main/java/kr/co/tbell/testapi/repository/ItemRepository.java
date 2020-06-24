package kr.co.tbell.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.tbell.testapi.model.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
