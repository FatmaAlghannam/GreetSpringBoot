package com.letcode.SecureBankSystem.repository;

import com.letcode.SecureBankSystem.entity.RoleEntity;
import com.letcode.SecureBankSystem.util.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByTitle(Roles title);
}