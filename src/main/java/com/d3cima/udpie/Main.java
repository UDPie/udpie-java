package com.d3cima.udpie;

import com.d3cima.udpie.services.LoggerService;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws IOException {
        LoggerService logger;
        try {
            UDPie.connect();
            logger = UDPie.logger();
            logger.alert("this is an alert");
            UDPie.section("section_test");
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

