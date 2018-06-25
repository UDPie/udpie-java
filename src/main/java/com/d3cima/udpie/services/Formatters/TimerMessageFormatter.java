package com.d3cima.udpie.services.Formatters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimerMessageFormatter extends AbstractServiceMessageFromatter {
    private String operation;
    private String key;
    private String title;
    private String clientTime = null;



    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String toISO8601UTC(Date date) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        return df.format(date);
    }

    public void setClientTime(boolean useClientTime) {
        if (useClientTime) {
            this.clientTime = toISO8601UTC(new Date());
        }
    }

    public TimerMessageFormatter() {

    }
}
