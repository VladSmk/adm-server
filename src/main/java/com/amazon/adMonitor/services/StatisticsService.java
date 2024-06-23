package com.amazon.adMonitor.services;

import com.amazon.adMonitor.dto.AdStatisticDTO;
import com.amazon.adMonitor.models.Advertising;
import com.amazon.adMonitor.repositories.AdvertisingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {
    private final AdvertisingRepository advertisingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StatisticsService(AdvertisingRepository advertisingRepository, ModelMapper modelMapper) {
        this.advertisingRepository = advertisingRepository;
        this.modelMapper = modelMapper;
    }

    public List<AdStatisticDTO> getAdStatistics() {
        List<AdStatisticDTO> ads = advertisingRepository.findAll()
                .stream().map(this::convertAdToAdStatisticDTO).toList();
        convertIntoPercentageRatio(ads);
        return ads;
    }

    private AdStatisticDTO convertAdToAdStatisticDTO(Advertising advertising) {
        return modelMapper.map(advertising, AdStatisticDTO.class);
    }

    private void convertIntoPercentageRatio(List<AdStatisticDTO> ads) {
        convertImpressionsIntoPercentageRatio(ads);
        convertClicksIntoPercentageRatio(ads);
        convertCTRIntoPercentageRatio(ads);
        convertConversionsIntoPercentageRatio(ads);
    }

    private void convertImpressionsIntoPercentageRatio(List<AdStatisticDTO> ads) {
        double sum = ads.stream().mapToDouble(AdStatisticDTO::getImpressions).sum();
        ads.forEach(ad -> ad.setImpressions(roundToThreeDecimalPlaces((ad.getImpressions() * 100) / sum)));
    }

    private void convertClicksIntoPercentageRatio(List<AdStatisticDTO> ads) {
        double sum = ads.stream().mapToDouble(AdStatisticDTO::getClicks).sum();
        ads.forEach(ad -> ad.setClicks(roundToThreeDecimalPlaces((ad.getClicks() * 100) / sum)));
    }

    private void convertCTRIntoPercentageRatio(List<AdStatisticDTO> ads) {
        double sum = ads.stream().mapToDouble(AdStatisticDTO::getCTR).sum();
        ads.forEach(ad -> ad.setCTR(roundToThreeDecimalPlaces((ad.getCTR() * 100) / sum)));
    }

    private void convertConversionsIntoPercentageRatio(List<AdStatisticDTO> ads) {
        double sum = ads.stream().mapToDouble(AdStatisticDTO::getConversions).sum();
        ads.forEach(ad -> ad.setConversions(roundToThreeDecimalPlaces((ad.getConversions() * 100) / sum)));
    }

    private double roundToThreeDecimalPlaces(double value) {
        return Math.round(value * 1000.0) / 1000.0;
    }
}
