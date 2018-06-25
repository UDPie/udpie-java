package com.d3cima.udpie;

import com.d3cima.udpie.services.CounterService;
import com.d3cima.udpie.services.LoggerService;
import com.d3cima.udpie.services.TimerService;

import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPie {

    private static UDPieClient client = null;

    public static void connect() throws SocketException, UnknownHostException {
        connect("127.0.0.1", 41234);
    }

    public static void connect(int port) throws SocketException, UnknownHostException {
        connect("127.0.0.1", port);
    }

    public static void connect(String address) throws SocketException, UnknownHostException {
        connect("127.0.0.1", 41234);
    }

    public static void connect(String address, int port, String section) throws SocketException, UnknownHostException {
        if (client == null) {
            client = new UDPieClient(address, port, section);
        }
    }

    public static void section(String section) {
        client.setSection(section);
    }


    public static void connect(String address, int port) throws SocketException, UnknownHostException {
        if (client == null) {
            client = new UDPieClient(address, port);
        }
    }

    public static TimerService timer(String timerName) {
        TimerService timerService = new TimerService(timerName);
        timerService.setClient(client);
        return timerService;
    }

    public static CounterService counter(String counterName) {
        CounterService counterService = new CounterService(counterName);
        counterService.setClient(client);
        return counterService;
    }

    public static LoggerService logger() {
        LoggerService loggerService = new LoggerService();

        loggerService.setClient(client);
        return loggerService;
    }

    @Override
    protected void finalize() throws Throwable {
        if (client != null) {
            client.close();
            client = null;
        }
        super.finalize();
    }
}
