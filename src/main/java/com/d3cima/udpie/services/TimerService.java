package com.d3cima.udpie.services;

import com.d3cima.udpie.services.Formatters.AbstractServiceMessageFromatter;
import com.d3cima.udpie.services.Formatters.TimerMessageFormatter;

import java.io.IOException;

public class TimerService extends AbstractService {
    private String key;
    private boolean useClientTime = true;

    public TimerService(String key) {
        this.key = key;
    }

    public void setUseClientTime(boolean useClientTime) {
        this.useClientTime = useClientTime;
    }

    public void start() throws IOException {
        getClient().send(format("start", ""));
    }

    public void start(String title) throws IOException {
        getClient().send(format("start", title));
    }

    public void tick() throws IOException {
        getClient().send(format("tick", ""));
    }

    public void tick(String title) throws IOException {
        getClient().send(format("tick", title));
    }

    public void stop() throws IOException {
        getClient().send(format("stop", ""));
    }

    public void stop(String title) throws IOException {
        getClient().send(format("stop", title));
    }


    private AbstractServiceMessageFromatter format(String operation, String title) {

        TimerMessageFormatter tmf = new TimerMessageFormatter();
        tmf.setClientTime(useClientTime);
        tmf.setType("timer");
        tmf.setKey(key);
        tmf.setOperation(operation);
        tmf.setTitle(title);


        return tmf;
    }
}
