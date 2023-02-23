package com.example.app.service;

import com.example.app.model.dto.TariffDto;

import java.util.List;

public interface TariffService {

    TariffDto getTariffById(Long id);

    TariffDto saveTariff(TariffDto tariffDto);

    TariffDto updateTariff(Long id, TariffDto tariffDto);

    List<TariffDto> saveTariffList(List<TariffDto> tariffDto);


    List<TariffDto> findAllTariff();

    void deleteTariff(Long id);
}
