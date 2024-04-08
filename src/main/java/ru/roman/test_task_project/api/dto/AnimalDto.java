package ru.roman.test_task_project.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class AnimalDto {

    @JsonProperty("name_animal")
    private String nameAnimal;

}
