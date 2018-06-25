package com.d3cima.udpie;

import com.d3cima.udpie.services.Formatters.AbstractServiceMessageFromatter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.net.*;

public class UDPieClient {

    private DatagramSocket socket;
    private InetAddress address;
    private int port;
    private String section = "misc";

    public UDPieClient(String address, int port) throws UnknownHostException, SocketException {
        connect(address, port);
    }

    private void connect(String address, int port) throws SocketException, UnknownHostException {
        this.address = InetAddress.getByName(address);
        socket = new DatagramSocket();
        this.port = port;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public UDPieClient(String address, int port, String section) throws UnknownHostException, SocketException {
        connect(address, port);
        this.section = section;
    }

    public void send(Object toParse) throws IOException {

        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(toParse);
        jsonElement.getAsJsonObject().addProperty("section", section);
        String msg = gson.toJson(jsonElement);
        System.out.println(msg);
        byte[] buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);
    }

    public void send(AbstractServiceMessageFromatter toParse) throws IOException {

        toParse.setSection(this.section);
        Gson gson = new Gson();
        String msg = gson.toJson(toParse);
        System.out.println(msg);
        byte[] buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);
    }

    public void send(String msg) throws IOException {
        byte[] buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);
    }

    public void close() {
        socket.close();
    }
}
