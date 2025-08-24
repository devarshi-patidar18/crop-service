package com.agrosense.crop.crop_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agrosense.crop.crop_service.Entity.Crop;

public interface CropRepository extends JpaRepository<Crop, Long> {

    List<Crop> findByUserId(Long userId);
}
