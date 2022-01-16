package com.guleksiredi.capabilitieshateoasbackend.services;

import com.guleksiredi.capabilitieshateoasbackend.domain.Capability;
import com.guleksiredi.capabilitieshateoasbackend.exceptions.CapabilityException;
import com.guleksiredi.capabilitieshateoasbackend.repositories.CapabilityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ResponseEntity<?> errorMap(BindingResult result) {
         /*
          BindingResult -> We're going to use it as an object that will tell us 2 things;
         whether we have errors, and it's going to give us access to those errors.
         then what we're going to do is manipulate how we get those errors, so we can return a (key:value) pair with the errors,
         and we're going to return it in a similar format as we return the response for our exception when the capability is not found.
         */

        // Map<String, String> error = new HashMap<>(); -> old Java(8)
        // Since Java 10:
        var errorMap = new HashMap<>(); // universal local variable

        for (FieldError error : result.getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    public Capability updateCapability(Long id, Capability capability) {

        return capabilityRepository.findById(id).map(
                cap -> {
                    cap.setTechStack(capability.getTechStack());
                    cap.setNumOfDevelopers(capability.getNumOfDevelopers());
                    cap.setNumOfAvailableDevelopers(capability.getNumOfAvailableDevelopers());
                    return capabilityRepository.save(cap);
                }
        ).orElseGet(() -> {
            return capabilityRepository.save(capability);
        });
    }

    public void deleteCapability(Long id) {
        capabilityRepository.delete(capabilityRepository.findById(id)
                .orElseThrow(() -> new CapabilityException("Capability with ID: " + id + " was not found!")));
    }
}
