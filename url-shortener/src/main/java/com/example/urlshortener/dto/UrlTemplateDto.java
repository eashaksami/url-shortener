package com.example.urlshortener.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UrlTemplateDto implements Serializable {
    String longUrl;
    BigDecimal totalHit;
}
