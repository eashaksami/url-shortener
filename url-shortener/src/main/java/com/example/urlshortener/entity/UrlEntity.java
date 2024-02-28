package com.example.urlshortener.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
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
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "ID", nullable = false)
    String id;

    @Column(name = "long_url", nullable = false)
    String longUrl;

    @Column(name = "short_url", nullable = false)
    String shortUrl;

    @Column(name = "total_hit", nullable = false)
    BigDecimal totalHit;

    @Column(name = "created", nullable = false)
    Date created;

    @Column(name = "updated")
    Date updated;

    @Column(name = "row_status", nullable = false)
    String rowStatus;

    @Column(name = "sequence", nullable = false)
    BigDecimal sequence;
}
