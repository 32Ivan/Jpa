package com.example.app.mapper;

import com.example.app.model.dto.TariffDto;
import com.example.app.model.entity.Tariff;

import java.util.List;
import java.util.stream.Collectors;

public class TariffMapperUtil {

    public static TariffDto toDto(Tariff tariff) {
        TariffDto tariffDto = new TariffDto();
        tariffDto.setId(tariff.getId());
        tariffDto.setName(tariff.getName());
        tariffDto.setFeatures(tariff.getFeatures());
        tariffDto.setPrice(tariff.getPrice());
        return tariffDto;
    }

    public static Tariff toEntity(TariffDto tariffDto) {
        Tariff tariff = new Tariff();
        tariff.setId(tariffDto.getId());
        tariff.setName(tariffDto.getName());
        tariff.setFeatures(tariffDto.getFeatures());
        tariff.setPrice(tariffDto.getPrice());
        return tariff;
    }

    public static List<TariffDto> findAll(List<Tariff> list) {
        return list.stream().map(TariffMapperUtil::toDto).collect(Collectors.toList());
    }

}
