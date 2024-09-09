package com.korea.credit.user;

import com.korea.credit.user.entities.User;

/**
 * @author sungjun
 * @since 9/9/24
 */
public class UserTestFixture {
    public static String BUSINESS_NO = "123-12-1234";
    public static User USER = new User (1, "TEST", "TEST유저", BUSINESS_NO);
}
