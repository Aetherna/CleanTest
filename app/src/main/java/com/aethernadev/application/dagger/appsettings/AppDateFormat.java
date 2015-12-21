package com.aethernadev.application.dagger.appsettings;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-12-10.
 */
public class AppDateFormat {
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

    @Inject
    public AppDateFormat() {
    }

    public DateTimeFormatter getDateTimeFormat() {
        return DATE_TIME_FORMAT;
    }
}
