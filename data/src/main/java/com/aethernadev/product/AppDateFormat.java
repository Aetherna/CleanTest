package com.aethernadev.product;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by Aetherna on 2015-11-03.
 */
public class AppDateFormat {
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
}
