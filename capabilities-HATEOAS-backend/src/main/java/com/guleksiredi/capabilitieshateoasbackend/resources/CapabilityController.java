package com.guleksiredi.capabilitieshateoasbackend.resources;

import com.guleksiredi.capabilitieshateoasbackend.assembler.CapabilityRepresentationModelAssembler;
import com.guleksiredi.capabilitieshateoasbackend.domain.Capability;
import com.guleksiredi.capabilitieshateoasbackend.services.CapabilityService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class CapabilityController {

    private final CapabilityService capabilityService;

    private final CapabilityRepresentationModelAssembler assembler;

    public CapabilityController(CapabilityService capabilityService, CapabilityRepresentationModelAssembler assembler) {
        this.capabilityService = capabilityService;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Capability>> getAllCapabilities() {

//        List<EntityModel<Capability>> capabilities =
//                capabilityService.getAllCapabilities().stream()
//                        .map(capability -> EntityModel.of(capability,
//                                linkTo(methodOn(CapabilityController.class).getCapability(capability.getId())).withRel("getThisCapability"),
//                                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
//                        ))
//                        .collect(Collectors.toList());
//
//        return CollectionModel.of(capabilities, linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withSelfRel());

        return CollectionModel.of(capabilityService.getAllCapabilities().stream()
                        .map(assembler::toModel).collect(Collectors.toList()),
                Link.of("https://capabilities-app-backend.herokuapp.com/dashboard").withRel("createCapability")
        );
        // map(capability -> assembler.toModel(capability)) converted to .map(assembler::toModel)
        // Lambda -> To Method Reference
    }

    @GetMapping("/{id}")
    public EntityModel<?> getCapability(@PathVariable Long id) {
        // Resource ->  Generic Container, contains data but also a set or collection of links
//        Capability capability = capabilityService.findCapabilityById(id);
//
//        return EntityModel.of(capability,
//                linkTo(methodOn(CapabilityController.class).getCapability(id)).withRel("Current Link"),
//                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"));

        return EntityModel.of(assembler.toModel(capabilityService.findCapabilityById(id)));
        // return (assembler.toModel(capabilityService.findCapabilityById(id))); // can be shorter
    }

    @PostMapping
    // returns Capability object or ResponseEntity with validation error messages,
    // so different types but still both (objects) and extend from object class
    // @Valid -> As parameter we will accept a valid request body of type capability. (Doesn't break any of the constraints that we set up in the domain object)
    public Object createCapability(@Valid @RequestBody Capability capability, BindingResult result) {

        if (result.hasErrors()) return capabilityService.errorMap(result);

//        Capability newCapability = capabilityService.saveCapability(capability);
//
//        return EntityModel.of(newCapability,
//                linkTo(methodOn(CapabilityController.class).getCapability(newCapability.getId())).withRel("Current Link"),
//                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"));
        return EntityModel.of(assembler.toModel(capabilityService.saveCapability(capability)));
    }

    @PutMapping("/{id}")
    public Object updateCapability(@PathVariable Long id, @Valid @RequestBody Capability capability, BindingResult result) {
        if (result.hasErrors()) return capabilityService.errorMap(result);

//        Capability capabilityToUpdate = capabilityService.updateCapability(id, capability);
//
//        return EntityModel.of(capabilityToUpdate,
//                linkTo(methodOn(CapabilityController.class).getCapability(capabilityToUpdate.getId())).withRel("Current Link (Capability)"),
//                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"));
        return EntityModel.of(assembler.toModel(capabilityService.updateCapability(id, capability)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCapability(@PathVariable Long id) {
        capabilityService.deleteCapability(id);

        return new ResponseEntity<String>("Capability Deleted", HttpStatus.OK);
    }

}
