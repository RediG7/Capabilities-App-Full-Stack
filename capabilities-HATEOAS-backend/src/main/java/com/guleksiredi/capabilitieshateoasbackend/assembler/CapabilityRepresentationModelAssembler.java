package com.guleksiredi.capabilitieshateoasbackend.assembler;

import com.guleksiredi.capabilitieshateoasbackend.domain.Capability;
import com.guleksiredi.capabilitieshateoasbackend.resources.CapabilityController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

// from non resource obj -> to resource obj
@Component
public class CapabilityRepresentationModelAssembler implements RepresentationModelAssembler<Capability, EntityModel<Capability>> {
    @Override
    public EntityModel<Capability> toModel(Capability entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(CapabilityController.class).getCapability(entity.getId())).withRel("getThisCapability"),
                linkTo(methodOn(CapabilityController.class).deleteCapability(entity.getId())).withRel("deleteThisCapability"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"),
                Link.of("https://capabilities-app.herokuapp.com/dashboard/" + entity.getId()).withRel("updateThisCapability")
        );
    }

}
