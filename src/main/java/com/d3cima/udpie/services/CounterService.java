package com.d3cima.udpie.services;

import com.d3cima.udpie.services.Formatters.CounterMessageFormatter;
import com.d3cima.udpie.services.Formatters.TimerMessageFormatter;

import java.io.IOException;

public class CounterService extends AbstractService {
    private String key;

    public CounterService(String key) {
        this.key = key;
    }

    public void increment() throws IOException {
        increment(1.0);
    }

    public void increment(float by) throws IOException {
        increment(Double.parseDouble(Float.toString(by)));

    }

    public void increment(int by) throws IOException {
        increment(Double.parseDouble(Integer.toString(by)));

    }

    public void increment(double by) throws IOException {
        send("increment", by);
    }

    public void decrement() throws IOException {
        decrement(1.0);
    }

    public void decrement(float by) throws IOException {
        decrement(Double.parseDouble(Float.toString(by)));

    }

    public void decrement(int by) throws IOException {
        decrement(Double.parseDouble(Integer.toString(by)));

    }

    public void decrement(double by) throws IOException {
        send("decrement", by);
    }

    public void set(float by) throws IOException {
        set(Double.parseDouble(Float.toString(by)));

    }

    public void set(int by) throws IOException {
        set(Double.parseDouble(Integer.toString(by)));

    }

    public void set(double by) throws IOException {
        send("set", by);
    }

    public void reset() throws IOException {
        send("reset", 0.0);
    }

    public void free() throws IOException {
        send("free", 0.0);
    }

    private void send(String opration, double value) throws IOException {
        CounterMessageFormatter cmf = new CounterMessageFormatter();

        cmf.setType("counter");
        cmf.setKey(key);
        cmf.setOperation(opration);
        cmf.setValue(value);
        getClient().send(cmf);
    }
}
