package com.dinesh.notebookAPI.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Color not be blank")
    @Size(min = 2, max = 10, message = "Color character must be between 5 to 10")
    private String color;

    @NotBlank(message = "Brand not be blank")
    @Size(min = 5, max = 20, message = "Brand character must be between 5 to 20")
    private String brand;

    @NotBlank(message = "Price must be present")
    @Size(min = 2, max = 50, message = "Price character must be between 2 to 50")
    private String price;

    @NotBlank(message = "Pen type must be define")
    @Size(min = 2, max = 20, message = "Type character must be between 2 to 20")
    private String type;

    @OneToMany(mappedBy = "pen", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Note> notes;

}
