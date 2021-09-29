package com.bezkoder.spring.data.jpa.pagingsorting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.data.jpa.pagingsorting.model.ERole;
import com.bezkoder.spring.data.jpa.pagingsorting.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
