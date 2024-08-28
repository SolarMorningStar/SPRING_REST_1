package com.solarmaster.star.util;

import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HybridIDGenerator {

    public static String generateHybridID() {
        // Generate the timestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());

        // Generate a shortened UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 12);

        // Combine timestamp and UUID
        return timestamp + "-" + uuid;
    }
}
