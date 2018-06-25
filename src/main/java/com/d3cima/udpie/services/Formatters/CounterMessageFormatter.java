package com.d3cima.udpie.services.Formatters;

public class CounterMessageFormatter extends AbstractServiceMessageFromatter {
    public String key;
    public double value;
    public String operation;

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
