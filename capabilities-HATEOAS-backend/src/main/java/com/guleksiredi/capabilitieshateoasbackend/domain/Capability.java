package com.guleksiredi.capabilitieshateoasbackend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Capability")
@Data
@NoArgsConstructor
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Technology Stack cannot be blank") // when key is but not value -> "techStack" : "" (empty)
    @NotNull(message = "Technology Stack cannot be null") // when no key no value -> { }
    private String techStack;
    private Integer numOfDevelopers = 0;
    private Integer numOfAvailableDevelopers = 0;

    public Capability(String techStack, Integer numOfDevelopers, Integer numOfAvailableDevelopers) {
        this.techStack = techStack;
        this.numOfDevelopers = numOfDevelopers;
        this.numOfAvailableDevelopers = numOfAvailableDevelopers;
    }
}
