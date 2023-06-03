package com.auther.fan.member_system.util;

import java.util.Random;

/**
 * 随机id生成
 */
public class PhoneNumberGenerator {

    private static final String[] ID_NUMBERS = {"001", "002", "003", "004", "005", "006", "007", "008", "009"};

    private static final int MAX_ID_LENGTH = 11;

    /**
     * 根据手机号生成随机id
     */
    public static String generateRandomId(String phoneNumber) {
        Random random = new Random();
        int index = random.nextInt(ID_NUMBERS.length);
        return ID_NUMBERS[index] + phoneNumber.substring(phoneNumber.length() - 4);
    }
}