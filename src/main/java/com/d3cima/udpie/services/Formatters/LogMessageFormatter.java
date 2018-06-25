package com.d3cima.udpie.services.Formatters;

public class LogMessageFormatter extends AbstractServiceMessageFromatter{
    private int level;
    private String message;
    private Object context=null;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setContext(Object context) {
        this.context = context;
    }
}
