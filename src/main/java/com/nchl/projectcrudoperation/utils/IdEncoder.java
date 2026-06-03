package com.nchl.projectcrudoperation.utils;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class IdEncoder {
    public static String encode(Integer id){
        return Base64.getUrlEncoder().encodeToString(id.toString().getBytes());
    }

    public static Integer decode(String encodeId){
        String decoded=new String(Base64.getUrlDecoder().decode(encodeId));
        return Integer.parseInt(decoded);
    }
}
