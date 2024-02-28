package com.example.urlshortener.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "URL")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "ID", nullable = false)
    String id;

    @Column(name = "long_url", nullable = false)
    String longUrl;
    @Column(name = "short_url", nullable = false)
    String shortUrl;
    @Column(name = "totalHit", nullable = false)
    BigDecimal totalHit;
    @Column(name = "created", nullable = false)
    Date created;
    @Column(name = "updated", nullable = false)
    Date updated;
    @Column(name = "version", nullable = false)
    BigDecimal version;
    @Column(name = "row_status", nullable = false)
    String rowStatus;
}
