package ru.example.clientapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactRequest {
    @NotBlank
    private String type;
    @NotBlank
    private String value;
}
