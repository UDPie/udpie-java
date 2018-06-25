package com.d3cima.udpie.services;

import com.d3cima.udpie.services.Formatters.LogMessageFormatter;

import java.io.IOException;

public class LoggerService extends AbstractService {

    public void log(int level, String message) throws IOException {
        log(level, message, new String[0]);
    }

    public void log(int level, String message, Object context) throws IOException {
        LogMessageFormatter lmf = new LogMessageFormatter();
        lmf.setLevel(level);
        lmf.setMessage(message);
        lmf.setContext(context);
        lmf.setType("log");
        getClient().send(lmf);
    }

    public void emergency(String message) throws IOException {
        log(600, message);
    }

    public void emergency(String message, Object context) throws IOException {
        log(600, message, context);
    }

    public void alert(String message) throws IOException {
        log(550, message);
    }

    public void alert(String message, Object context) throws IOException {
        log(550, message, context);
    }

    public void critical(String message) throws IOException {
        log(500, message);
    }

    public void critical(String message, Object context) throws IOException {
        log(500, message, context);
    }

    public void error(String message) throws IOException {
        log(400, message);
    }

    public void error(String message, Object context) throws IOException {
        log(400, message, context);
    }

    public void warning(String message) throws IOException {
        log(300, message);
    }

    public void warning(String message, Object context) throws IOException {
        log(300, message, context);
    }

    public void notice(String message) throws IOException {
        log(250, message);
    }

    public void notice(String message, Object context) throws IOException {
        log(250, message, context);
    }

    public void info(String message) throws IOException {
        log(200, message);
    }

    public void info(String message, Object context) throws IOException {
        log(200, message, context);
    }

    public void debug(String message) throws IOException {
        log(100, message);
    }

    public void debug(String message, Object context) throws IOException {
        log(100, message, context);
    }
}
