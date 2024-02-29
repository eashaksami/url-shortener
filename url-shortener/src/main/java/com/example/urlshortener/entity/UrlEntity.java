package com.example.urlshortener.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "URL")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_generator")
    @SequenceGenerator(name = "url_generator", sequenceName = "url_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    BigInteger id;

    @Column(name = "long_url", nullable = false)
    String longUrl;

    @Column(name = "short_url")
    String shortUrl;

    @Column(name = "total_hit", nullable = false)
    BigDecimal totalHit;

    @Column(name = "created", nullable = false)
    Date created;

    @Column(name = "updated")
    Date updated;

    @Column(name = "row_status", nullable = false)
    String rowStatus;
}
