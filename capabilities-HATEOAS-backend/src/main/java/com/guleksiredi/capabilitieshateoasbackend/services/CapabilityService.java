package com.guleksiredi.capabilitieshateoasbackend.services;

import com.guleksiredi.capabilitieshateoasbackend.domain.Capability;
import com.guleksiredi.capabilitieshateoasbackend.exceptions.CapabilityException;
import com.guleksiredi.capabilitieshateoasbackend.repositories.CapabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapabilityService {

    private final CapabilityRepository capabilityRepository;

    public CapabilityService(CapabilityRepository capabilityRepository) {
        this.capabilityRepository = capabilityRepository;
    }

    public List<Capability> getAllCapabilities() {
        return capabilityRepository.findAll();
    }

    public Capability findCapabilityById(Long id) {

        return capabilityRepository.findById(id).orElseThrow(
                () -> new CapabilityException("Capability with ID: " + id + " not found")
        );
    }

    public Capability saveCapability(Capability capability) {

        return capabilityRepository.save(capability);
    }

}
