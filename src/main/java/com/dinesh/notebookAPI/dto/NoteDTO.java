package com.dinesh.notebookAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {

    private Long id;

    @NotBlank(message = "Title not be empty")
    @Size(min = 5, max = 100, message = "Title must be between 5 to 100 character")
    private String title;

    @NotBlank(message = "The content not be empty")
    private String content;

}
