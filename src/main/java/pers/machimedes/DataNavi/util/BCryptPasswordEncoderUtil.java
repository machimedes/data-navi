package pers.machimedes.DataNavi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtil {

    public static String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
