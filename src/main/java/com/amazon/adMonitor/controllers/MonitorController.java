package com.amazon.adMonitor.controllers;

import com.amazon.adMonitor.dto.AdvertisingDTO;
import com.amazon.adMonitor.models.Advertising;
import com.amazon.adMonitor.services.AdvertisingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MonitorController {
    private final AdvertisingService advertisingService;

    public MonitorController(AdvertisingService advertisingService) {
        this.advertisingService = advertisingService;
    }

    @GetMapping("/findAll")
    public List<Advertising> findAllAdvertising(){
        return advertisingService.findAll();
    }

    @GetMapping("/findAllDTO")
    public List<AdvertisingDTO> findAllAdvertisingDTO(){
        return advertisingService.findAllDTO();
    }
}
