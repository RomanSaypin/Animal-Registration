package ru.roman.test_task_project.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.roman.test_task_project.api.dto.AnimalDto;
import ru.roman.test_task_project.api.dto.AskDTO;
import ru.roman.test_task_project.api.service.AnimalService;
import ru.roman.test_task_project.store.entities.Animal;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    private final static String GET_ALL_ANIMAL = "/api/v1/animals";
    private final static String GET_ANIMAL = "/api/v1/animals/{animalId}";
    private final static String CREATE_ANIMAL = "/api/v1/animals/";
    private final static String UPDATE_ANIMAL = "/api/v1/animals/{animalId}";
    private final static String DELETE_ANIMAL = "/api/v1/animals/{animalId}";

    @GetMapping(GET_ALL_ANIMAL)
    public ResponseEntity<List<AnimalDto>> getAnimals() {
        return ResponseEntity.status(HttpStatus.OK).body(animalService.getAllAnimal());
    }

    @GetMapping(GET_ANIMAL)
    public ResponseEntity<AnimalDto> getAnimal(@PathVariable Long animalId) {
        return ResponseEntity.status(HttpStatus.OK).body(animalService.getAnimalById(animalId));
    }

    @PostMapping(CREATE_ANIMAL)
    public ResponseEntity<AnimalDto> addAnimal(@RequestBody Animal animal) {
        return ResponseEntity.status(HttpStatus.OK).body(animalService.createAnimal(animal));
    }

    @PutMapping(UPDATE_ANIMAL)
    public ResponseEntity<AnimalDto> updateAnimal(@PathVariable Long animalId, @RequestBody Animal animal) {
        return ResponseEntity.status(HttpStatus.OK).body(animalService.updateAnimal(animalId, animal));
    }

    @DeleteMapping(DELETE_ANIMAL)
    public AskDTO deleteAnimal(@PathVariable Long animalId) {
        return animalService.deleteAnimal(animalId);
    }
}
