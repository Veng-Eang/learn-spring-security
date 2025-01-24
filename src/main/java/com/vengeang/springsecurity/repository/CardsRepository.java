package com.vengeang.springsecurity.repository;

import java.util.List;

import com.vengeang.springsecurity.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vengeang.springsecurity.model.Cards;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {
	
	List<Cards> findByCustomerId(long customerId);

}
