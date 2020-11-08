package com.doruareabe.share_to_good_hands.service;

import com.doruareabe.share_to_good_hands.entity.Donation;

import java.util.List;

public interface DonationService {
    List<Donation> findAll();
    Donation save(Donation donation);
}
