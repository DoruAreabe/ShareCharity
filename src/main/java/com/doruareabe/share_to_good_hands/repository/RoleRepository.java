package com.doruareabe.share_to_good_hands.repository;

import com.doruareabe.share_to_good_hands.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
