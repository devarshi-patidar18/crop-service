package com.agrosense.crop.crop_service.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrosense.crop.crop_service.Entity.Crop;
import com.agrosense.crop.crop_service.Service.CropService;

@RestController
@RequestMapping("/crops")
public class CropController {

    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @PostMapping("/create")
    public Crop createCrop(@RequestBody Crop crop) {
        return cropService.createCrop(crop);
    }

    @GetMapping("/all")
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

    @GetMapping("/user/{userId}")
    public List<Crop> getCropsByUser(@PathVariable Long userId) {
        return cropService.getCropsByUserId(userId);
    }
}