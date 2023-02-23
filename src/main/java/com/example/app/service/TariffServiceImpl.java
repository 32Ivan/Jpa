package com.example.app.service;

import com.example.app.mapper.TariffMapperUtil;
import com.example.app.model.dto.TariffDto;
import com.example.app.model.entity.Tariff;
import com.example.app.repository.TariffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService{


    private final TariffRepository tariffRepository;


    @Override
    @Transactional
    public TariffDto getTariffById(Long id) {
            return TariffMapperUtil.toDto(tariffRepository.findById(id).orElseThrow(()-> new RuntimeException("Problem with Id")));
    }

    @Override
    @Transactional
    public TariffDto saveTariff(TariffDto tariffDto) {
        Tariff tariff = TariffMapperUtil.toEntity(tariffDto);
        return TariffMapperUtil.toDto(tariffRepository.save(tariff));
    }

    @Override
    @Transactional
    public TariffDto updateTariff(Long id, TariffDto updatedTariffDto) {
        return tariffRepository.findById(id)
                .map(existingTariff -> {
                    Tariff updatedTariff = TariffMapperUtil.toEntity(updatedTariffDto);
                    updatedTariff.setId(existingTariff.getId());
                    Tariff savedTariff = tariffRepository.save(updatedTariff);
                    return TariffMapperUtil.toDto(savedTariff);
                })
                .orElseThrow(() -> new RuntimeException(String.valueOf(HttpStatus.BAD_REQUEST)));
    }

    @Override
    @Transactional
    public List<TariffDto> saveTariffList(List<TariffDto> tariffDto) {
            tariffRepository.saveAll(tariffDto.stream().map(TariffMapperUtil::toEntity).collect(Collectors.toList()));
            return findAllTariff();
    }

    @Override
    @Transactional
    public List<TariffDto> findAllTariff() {
            return tariffRepository.findAll().stream().map(TariffMapperUtil::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteTariff(Long id) {
            tariffRepository.deleteById(id);
    }
}
