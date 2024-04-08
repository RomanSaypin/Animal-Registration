package ru.roman.test_task_project.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AskDTO {

   private Boolean answer;

    public static AskDTO makeDefault(Boolean answer) {
        return builder()
                .answer(answer)
                .build();
    }
}
