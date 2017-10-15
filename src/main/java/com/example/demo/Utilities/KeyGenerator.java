package com.example.demo.Utilities;

import java.util.UUID;

/**
 * Created by Adeebo on 2017/08/21.
 */
public class KeyGenerator {
    public static String getEntityId() {
        return UUID.randomUUID().toString();
    }
}
