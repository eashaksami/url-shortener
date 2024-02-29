package com.example.urlshortener.reposityry;

import com.example.urlshortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, String> {

    UrlEntity findByShortUrl(String shortUrl);
}
