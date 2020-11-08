package com.doruareabe.share_to_good_hands.service;

import com.doruareabe.share_to_good_hands.entity.Donation;
import com.doruareabe.share_to_good_hands.repository.DonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override

    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation save(Donation donation) {
        return donationRepository.save(donation);
    }
}
