package ru.roman.test_task_project.api.service;

import ru.roman.test_task_project.api.dto.AnimalDto;
import ru.roman.test_task_project.api.dto.AskDTO;
import ru.roman.test_task_project.store.entities.Animal;

import java.util.List;

public interface AnimalService {

    List<AnimalDto> getAllAnimal();

    AnimalDto getAnimalById(Long animalId);

    AnimalDto updateAnimal(Long animalId, Animal animal);

    AnimalDto createAnimal(Animal animal);

    AskDTO deleteAnimal(Long animalId);
}
