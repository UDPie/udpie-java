package com.d3cima.udpie;

import com.d3cima.udpie.services.CounterService;
import com.d3cima.udpie.services.LoggerService;
import com.d3cima.udpie.services.TimerService;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws IOException {
        LoggerService logger;
        try {
            UDPie.connect();
            logger = UDPie.logger();
            logger.alert("hello");
            UDPie.section("bob");
            throw new Exception("shit happens");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            logger = UDPie.logger();
            logger.error(e.getMessage(), e);
        }
    }
}

