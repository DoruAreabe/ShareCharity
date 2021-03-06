package com.doruareabe.share_to_good_hands.repository;

import com.doruareabe.share_to_good_hands.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
