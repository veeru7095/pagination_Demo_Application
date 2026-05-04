package com.akp.area.repository;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akp.area.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);

	
	List<User> findAllByOrderByIdAsc(Pageable pageRequest);

	List<User> findAllByIdGreaterThanOrderByIdAsc(Long cursor, PageRequest of);

}
