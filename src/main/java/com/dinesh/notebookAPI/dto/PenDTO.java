package com.dinesh.notebookAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenDTO {

    private Long id;
    private String color;
    private String brand;
    private String price;
    private String type;

}
