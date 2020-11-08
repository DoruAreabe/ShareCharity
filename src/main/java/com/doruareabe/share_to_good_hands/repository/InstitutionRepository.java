package com.doruareabe.share_to_good_hands.repository;

import com.doruareabe.share_to_good_hands.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}