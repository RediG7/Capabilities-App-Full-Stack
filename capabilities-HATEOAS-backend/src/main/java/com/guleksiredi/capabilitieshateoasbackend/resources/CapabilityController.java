package com.guleksiredi.capabilitieshateoasbackend.resources;

import com.guleksiredi.capabilitieshateoasbackend.domain.Capability;
import com.guleksiredi.capabilitieshateoasbackend.services.CapabilityService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class CapabilityController {

    private final CapabilityService capabilityService;

    public CapabilityController(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @GetMapping
    CollectionModel<EntityModel<Capability>> getAllCapabilities() {

        List<EntityModel<Capability>> capabilities =
                capabilityService.getAllCapabilities().stream()
                        .map(capability -> EntityModel.of(capability,
                                linkTo(methodOn(CapabilityController.class).getCapability(capability.getId())).withRel("getThisCapability"),
                                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
                        ))
                        .collect(Collectors.toList());

        return CollectionModel.of(capabilities, linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withSelfRel());

    }

    @GetMapping("/{id}")
    public EntityModel<Capability> getCapability(@PathVariable Long id) {
        // Resource ->  Generic Container, contains data but also a set or collection of links
        Capability capability = capabilityService.findCapabilityById(id);

        return EntityModel.of(capability,
                linkTo(methodOn(CapabilityController.class).getCapability(id)).withRel("Current Link"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"));
    }

    @PostMapping
    // returns Capability object or ResponseEntity with validation error messages,
    // so different types but still both (objects) and extend from object class
    public Object createCapability(@RequestBody Capability capability) {

        Capability newCapability = capabilityService.saveCapability(capability);

        return EntityModel.of(newCapability,
                linkTo(methodOn(CapabilityController.class).getCapability(newCapability.getId())).withRel("Current Link"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"));
    }
}
