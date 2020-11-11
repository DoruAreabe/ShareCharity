package com.doruareabe.share_to_good_hands.service;

import com.doruareabe.share_to_good_hands.entity.Institution;
import com.doruareabe.share_to_good_hands.repository.InstitutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public Institution save(Institution institution) {
        return institutionRepository.save(institution);
    }

    @Override
    public Institution findById(Long id) {
        return institutionRepository.findById(id).orElse(null);
    }
}
