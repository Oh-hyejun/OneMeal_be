package com.OneMeal.OneMeal_be.post.dto;

import com.OneMeal.OneMeal_be.entity.Material;

public class MaterialDTO {
    private Integer id;
    private String name;

    public MaterialDTO(Material material) {
        this.id = material.getId();
        this.name = material.getName();
    }
}
