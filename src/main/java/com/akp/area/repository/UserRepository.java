package com.akp.area.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akp.area.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
