package com.example.urlshortener.reposityry;

import com.example.urlshortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, String> {

    UrlEntity findByShortUrl(String shortUrl);

    UrlEntity findByLongUrl(String longUrl);

    @Query(nativeQuery = true, value = "SELECT pg_notify('invoke_trigger', :triggerName)")
    void callTrigger(String triggerName);
}
