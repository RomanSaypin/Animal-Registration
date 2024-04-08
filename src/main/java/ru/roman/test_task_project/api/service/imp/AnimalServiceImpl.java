package ru.roman.test_task_project.api.service.imp;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.roman.test_task_project.api.dto.AnimalDto;
import ru.roman.test_task_project.api.dto.AskDTO;
import ru.roman.test_task_project.api.service.AnimalService;
import ru.roman.test_task_project.exceptions.AnimalNotFoundException;
import ru.roman.test_task_project.store.entities.Animal;
import ru.roman.test_task_project.store.repository.AnimalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    @Override
    public List<AnimalDto> getAllAnimal() {
        return animalRepository
                .findAll()
                .stream()
                .map(animals -> modelMapper.map(animals, AnimalDto.class))
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public AnimalDto getAnimalById(Long animalId) {

        Animal animal = getAnimal(animalId);

        return modelMapper.map(animal, AnimalDto.class);
    }

    @Transactional
    @Override
    public AnimalDto updateAnimal(Long animalId, Animal animal) {

        Animal animal1 = getAnimal(animalId);

        animal1.setNameAnimal(animal.getNameAnimal());

        return modelMapper.map(animal1, AnimalDto.class);
    }

    @Transactional
    @Override
    public AnimalDto createAnimal(Animal animal) {

        Animal animal1 = animalRepository.saveAndFlush(animal);

        return modelMapper.
                map(
                        animalRepository.findById(animal1.getIdAnimal()).orElseThrow(), AnimalDto.class
                );
    }

    @Transactional
    @Override
    public AskDTO deleteAnimal(Long animalId) {
        animalRepository.deleteById(animalId);
        return AskDTO.makeDefault(true);
    }

    private Animal getAnimal(Long animalId) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new AnimalNotFoundException(
                        String.format("Animal by id = %d not found", animalId)
                ));
        return animal;
    }
}
