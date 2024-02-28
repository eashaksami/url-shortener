package com.example.urlshortener.service;

import org.springframework.stereotype.Service;

//import java.beans.Encoder;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;

@Service
public class UrlService {

    public String convertToShortUrl() {
        return "sami";
    }

    public String getOriginalUrl(String shortUrl) {
        String uuid = UUID.randomUUID().toString();

        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[7];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        String token = encoder.encodeToString(bytes);
        uuid = uuid.replace("-", "");
//        for(int i = 0; i < token.length(); i++) {
//            uuid = uuid.concat(String.valueOf((int) token.charAt(i)));
//        }
//        uuid = uuid.concat(token);
        BigInteger intUUID = new BigInteger(uuid, 16);
        System.out.println(uuid);
        System.out.println(intUUID);
        String output = "";
        uuid = uuid.replace("-", "");
//        BigInteger integerOutput = BigInteger.ONE;
//        BigInteger multiply = BigInteger.ONE;
//        for(int i = 0; i < uuid.length(); i++) {
//            integerOutput = integerOutput.multiply(BigInteger.valueOf((int) uuid.charAt(i))).multiply(multiply);
//            multiply = multiply.add(BigInteger.ONE);
////            output += String.valueOf((int) uuid.charAt(i));
//        }
//        System.out.println("integerOutput: " + integerOutput);
//        BigInteger integerOutput = new BigInteger(output);
//        String base64Encoding = Base64.getUrlEncoder().encodeToString(uuid.getBytes());
        String base64Encoding = Base64.getUrlEncoder().encodeToString(String.valueOf(System.currentTimeMillis()).getBytes());
        System.out.println("base64Encoding: " + base64Encoding);
        List<BigInteger> abc = new ArrayList<>();
        intUUID = BigInteger.valueOf(70);
        while (intUUID != BigInteger.ZERO) {
            BigInteger temp = intUUID.mod(BigInteger.valueOf(64));
            intUUID = intUUID.divide(BigInteger.valueOf(64));
            abc.add(temp);
        }
        Collections.reverse(abc);
        System.out.println("list: " + abc);
        shortUrl(abc);
//        BigInteger uuidUpdated = BigInteger.ONE;
//        BigInteger count = BigInteger.ONE;
//        for (BigInteger list : abc) {
//            uuidUpdated = uuidUpdated.multiply(list).multiply(count);
//            count = count.add(BigInteger.ONE);
//        }
//        List<BigInteger> abcUpdated = new ArrayList<>();
//        while (!uuidUpdated.divide(BigInteger.valueOf(62)).equals(BigInteger.ZERO)) {
//            abcUpdated.add(uuidUpdated.mod(BigInteger.valueOf(62)));
//            uuidUpdated = uuidUpdated.divide(BigInteger.valueOf(62));
//        }
//        System.out.println("abcUpdated: " + abcUpdated);
        return "https://www.educative.io/courses/grokking-modern-system-design-interview-for-engineers-managers/evaluation-of-tinyurls-design";
    }

    private List<BigInteger> shortUrl(List<BigInteger> abc) {
        while(abc.size() > 7) {
            BigInteger uuidUpdated = BigInteger.ONE;
            BigInteger count = BigInteger.ONE;
            for (BigInteger list : abc) {
                uuidUpdated = uuidUpdated.multiply(list).multiply(count);
                count = count.add(BigInteger.ONE);
            }
            abc = new ArrayList<>();
            while (!uuidUpdated.divide(BigInteger.valueOf(62)).equals(BigInteger.ZERO)) {
                abc.add(uuidUpdated.mod(BigInteger.valueOf(62)));
                uuidUpdated = uuidUpdated.divide(BigInteger.valueOf(62));
            }
            System.out.println("abcUpdated: " + abc);
        }
        return abc;
    }
}
