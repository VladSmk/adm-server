package com.amazon.adMonitor.services;

import com.amazon.adMonitor.dto.AdvertisingDTO;
import com.amazon.adMonitor.models.Advertising;
import com.amazon.adMonitor.repositories.AdvertisingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisingService {
    private final AdvertisingRepository advertisingRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public AdvertisingService(AdvertisingRepository advertisingRepository, ModelMapper modelMapper) {
        this.advertisingRepository = advertisingRepository;
        this.modelMapper = modelMapper;
    }

    public List<Advertising> findAll() {
        return advertisingRepository.findAll();
    }

    public List<AdvertisingDTO> findAllDTO() {
        return advertisingRepository.findAll().stream().map(this::convertAdToAdDTO).toList();
    }

    public AdvertisingDTO convertAdToAdDTO(Advertising advertising) {
        return modelMapper.map(advertising, AdvertisingDTO.class);
    }
}
