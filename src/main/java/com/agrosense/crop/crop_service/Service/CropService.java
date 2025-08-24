package com.agrosense.crop.crop_service.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.agrosense.crop.crop_service.Client.UserServiceClient;
import com.agrosense.crop.crop_service.Entity.Crop;
import com.agrosense.crop.crop_service.Repository.CropRepository;

@Service
public class CropService {

    private final CropRepository cropRepository;
    private final UserServiceClient userServiceClient;

    public CropService(CropRepository cropRepository, UserServiceClient userServiceClient) {
        this.cropRepository = cropRepository;
        this.userServiceClient = userServiceClient;
    }

    public Crop createCrop(Crop crop) {
        // Check if user exists in UserService
        try {
            userServiceClient.getUserById(crop.getUserId());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not exist");
        }
        return cropRepository.save(crop);
    }

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public List<Crop> getCropsByUserId(Long userId) {
        return cropRepository.findByUserId(userId);
    }
}
