package com.vengeang.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vengeang.springsecurity.model.Notice;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {
	
//	@Query(value = "from Notice n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
//	@Query("SELECT n FROM notice n WHERE ")

	@Query(nativeQuery = true,value = "SELECT * FROM notice_detail WHERE create_dt BETWEEN notic_beg_dt AND notic_end_dt")
	List<Notice> findAllActiveNotices();

}
