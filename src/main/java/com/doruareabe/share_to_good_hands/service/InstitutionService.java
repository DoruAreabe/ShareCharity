package com.doruareabe.share_to_good_hands.service;

import com.doruareabe.share_to_good_hands.entity.Institution;

import java.util.List;

public interface InstitutionService {
    List<Institution> findAll();
    void deleteById(Long id);
    Institution save(Institution institution);
    Institution findById(Long id);
}
