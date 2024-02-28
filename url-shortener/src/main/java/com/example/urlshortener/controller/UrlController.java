package com.example.urlshortener.controller;


import com.example.urlshortener.models.UrlLongRequest;
import com.example.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class UrlController {

    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("create-short")
    public String convertToShortUrl(@RequestBody UrlLongRequest request) {
        return urlService.convertToShortUrl(request);
    }

    @GetMapping(value = "{shortUrl}")
//    @Cacheable(value = "urls", key = "#shortUrl", sync = true)
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {
        String url = urlService.getOriginalUrl(shortUrl).getLongUrl();
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }
}
