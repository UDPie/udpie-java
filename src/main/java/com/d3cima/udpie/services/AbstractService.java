package com.d3cima.udpie.services;

import com.d3cima.udpie.UDPieClient;

public class AbstractService {
    private UDPieClient client;

    protected UDPieClient getClient() {
        return client;
    }

    public void setClient(UDPieClient client) {
        this.client = client;
    }
}
