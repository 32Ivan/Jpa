package com.example.app.controller;

import com.example.app.model.dto.TariffDto;
import com.example.app.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tariff")
@RestController
@RequiredArgsConstructor
public class TariffController {


    private final TariffService tariffService;

    @GetMapping(value = "find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TariffDto>> tariffFindAll() {
        try {
            return ResponseEntity.ok(this.tariffService.findAllTariff());
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    }

    @GetMapping(value = "ID/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TariffDto> tariffId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tariffService.getTariffById(id));
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<TariffDto> tariffUpdate(@PathVariable Long id, @RequestBody TariffDto updatedTariffDto) {
        try {
            TariffDto updatedTariff = tariffService.updateTariff(id, updatedTariffDto);
            return ResponseEntity.ok(updatedTariff);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("save")
    public ResponseEntity<TariffDto> tariffAddress(@RequestBody TariffDto tariffDto) {
        try {
            return ResponseEntity.ok(tariffService.saveTariff(tariffDto));
         }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    }

    @PostMapping("saveAll")
    public ResponseEntity<List<TariffDto>> saveTariffList(@RequestBody List<TariffDto> tariffDto) {
        try {
            return ResponseEntity.ok(tariffService.saveTariffList(tariffDto));
         }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTariff(@PathVariable Long id) {
        try {
            this.tariffService.deleteTariff(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
