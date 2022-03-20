package com.grow.exchange.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grow.exchange.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@Query("SELECT p FROM UserEntity p where p.userId=?1 And isActive=1")
	public UserEntity findUserByUserId(String userId); 
	
	@Query("SELECT p FROM UserEntity p where p.id=?1")
	public UserEntity findUserById(Long Id); 
	
	@Query("SELECT p FROM UserEntity p where p.adminId=?1 And isActive=1")
	public List<UserEntity> findUsersByAdminId(String adminId); 
	
	}


