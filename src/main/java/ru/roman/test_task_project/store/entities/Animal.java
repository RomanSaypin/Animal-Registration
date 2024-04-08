package ru.roman.test_task_project.store.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "animals")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty("id_animal")
    @Column(name ="id_animal")
    private Long idAnimal;
    @JsonProperty("name_animal")
    @Column(name ="name_animal")
    private String nameAnimal;

}
