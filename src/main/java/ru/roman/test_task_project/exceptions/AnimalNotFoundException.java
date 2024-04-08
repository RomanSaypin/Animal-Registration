package ru.roman.test_task_project.exceptions;

public class AnimalNotFoundException extends RuntimeException {

    public AnimalNotFoundException(String message) {
        super(message);
    }
}
