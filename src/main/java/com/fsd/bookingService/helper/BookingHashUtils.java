package com.fsd.bookingService.helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

public class BookingHashUtils {

    public static String getId() {
        UUID uuid = UUID.randomUUID();
        String ramdonString = System.currentTimeMillis() + RandomStringUtils.randomAlphabetic(10)
                + RandomStringUtils.randomNumeric(10) + uuid.toString();
        BookingHashUtils rewardsHashUtils = new BookingHashUtils();
        String hash = rewardsHashUtils.getMd5(ramdonString);
        if (hash != null) {
            hash = hash.substring(0, 16).toUpperCase();
        }
        return hash;
    }

    private String getMd5(String input) {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            hash = hashtext;
        } catch (Exception e) {
//            throw new BfdlRewardsException(HttpStatus.INTERNAL_SERVER_ERROR,
//                    new ErrorBean(ErrorMessages.BFDL_REWARDS_1048, env.getProperty(ErrorMessages.BFDL_REWARDS_1048)));
        }
        return hash;
    }
}