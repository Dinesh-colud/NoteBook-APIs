package com.dinesh.notebookAPI.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 100, message = "Title must be between 5 to 100 character")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Content is required")
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotNull(message = "Active field is required")
    private boolean deleted;

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.deleted = false;
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

    @ManyToOne()
    @JoinColumn(name = "pen_id")
    @JsonManagedReference
    private Pen pen;
}
