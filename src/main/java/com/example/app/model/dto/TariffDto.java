package com.example.app.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TariffDto {
    private Long id;

    private String name;

    private String features;

    private Number price;
}
