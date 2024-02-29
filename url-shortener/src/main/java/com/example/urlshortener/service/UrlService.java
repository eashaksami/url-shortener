package com.example.urlshortener.service;

import com.example.urlshortener.dto.UrlTemplateDto;
import com.example.urlshortener.entity.UrlEntity;
import com.example.urlshortener.models.UrlLongRequest;
import com.example.urlshortener.reposityry.UrlRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

//import java.beans.Encoder;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final RedisTemplate<String, Object> template;

    @Autowired
    public UrlService(UrlRepository urlRepository,
                      RedisTemplate<String, Object> template) {
        this.urlRepository = urlRepository;
        this.template = template;
    }

    @Transactional
    public String convertToShortUrl(UrlLongRequest request) {

        UrlEntity entity = UrlEntity.builder()
                .longUrl(request.getLongUrl())
                .created(new Date())
                .totalHit(BigDecimal.ZERO)
//                .shortUrl(getShortUrl(sequence.toBigInteger()))
                .rowStatus("ACTIVE")
                .build();
        urlRepository.save(entity);
        String shortUrl = getShortUrl(entity.getId());
        entity.setShortUrl(shortUrl);
        urlRepository.save(entity);
        return entity.getShortUrl();
    }

    @Cacheable(value = "url", key = "#shortUrl", unless = "#result.totalHit < 2")
    public UrlTemplateDto getOriginalUrl(String shortUrl) {
        UrlEntity maxUrlEntity = urlRepository.findByShortUrl(shortUrl);
        if(maxUrlEntity == null) { return UrlTemplateDto.builder().build();}

        maxUrlEntity.setTotalHit(maxUrlEntity.getTotalHit().add(BigDecimal.ONE));
        urlRepository.save(maxUrlEntity);
        UrlTemplateDto dto = UrlTemplateDto.builder()
                .longUrl(maxUrlEntity.getLongUrl())
                .totalHit(maxUrlEntity.getTotalHit())
                .build();

        return dto;
    }

    public String getShortUrl(BigInteger sequence) {
        System.out.println("sequence from parameter: " + sequence);

// Converting to base58
        List<BigInteger> listBase58 = new ArrayList<>();
        while (!sequence.equals(BigInteger.ZERO)) {
            BigInteger temp = sequence.mod(BigInteger.valueOf(58));
            sequence = sequence.divide(BigInteger.valueOf(58));
            listBase58.add(temp);
        }
        Collections.reverse(listBase58);
        System.out.println("list: " + listBase58);

//creating hashmap
        HashMap<String, String> h1 = new HashMap<>() {{
            put("1", "a");
            put("2", "b");
            put("3", "c");
            put("4", "d");
            put("5", "e");
            put("6", "f");
            put("7", "g");
            put("8", "h");
            put("9", "i");
            put("10", "j");
            put("11", "k");
            put("12", "l");
            put("13", "m");
            put("14", "n");
            put("15", "o");
            put("16", "p");
            put("17", "q");
            put("18", "r");
            put("19", "s");
            put("20", "t");
            put("21", "u");
            put("22", "v");
            put("23", "w");
            put("24", "x");
            put("25", "y");
            put("26", "z");
            put("27", "A");
            put("28", "B");
            put("29", "C");
            put("30", "D");
            put("31", "E");
            put("32", "F");
            put("33", "G");
            put("34", "H");
            put("35", "I");
            put("36", "J");
            put("37", "K");
            put("38", "L");
            put("39", "M");
            put("40", "N");
            put("41", "O");
            put("42", "P");
            put("43", "Q");
            put("44", "R");
            put("45", "S");
            put("46", "T");
            put("47", "U");
            put("48", "V");
            put("49", "W");
            put("50", "X");
            put("51", "Y");
            put("52", "Z");
            put("53", "0");
            put("54", "1");
            put("55", "2");
            put("56", "3");
            put("57", "4");
            put("58", "5");
            put("59", "6");
            put("60", "7");
            put("61", "8");
            put("62", "9");
        }};

        System.out.println("hashmap: " + h1);

// Search in hashmap through

        String shortUrl = "";

        for (int i = 0; i < listBase58.size(); i++) {
            System.out.println("list map: " + listBase58.get(i));
            if (h1.containsKey(String.valueOf(listBase58.get(i)))) {
                System.out.println("hashmap key found: " + listBase58.get(i));
                shortUrl = shortUrl.concat(h1.get(String.valueOf(listBase58.get(i))));
                if (shortUrl.length() > 7) {
                    shortUrl = shortUrl.substring(0, 7);
                }
            }
        }

        System.out.println("short url: " + shortUrl);

// Concat if length is not enough
        int length = 7 - shortUrl.length();
        System.out.println("length: " + length);

//if need to concatenate extra part
//        if (length > 0) {
//
//        }


        return shortUrl;
    }
}
