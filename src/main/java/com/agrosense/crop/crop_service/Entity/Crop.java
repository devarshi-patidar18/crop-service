package com.agrosense.crop.crop_service.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // Vegetable, Fruit, Grain
    private String growthStage; // Seedling, Vegetative, Flowering, Harvest
    private LocalDate plantingDate;
    private LocalDate expectedHarvestDate;

    private Long userId; // reference from UserService
}