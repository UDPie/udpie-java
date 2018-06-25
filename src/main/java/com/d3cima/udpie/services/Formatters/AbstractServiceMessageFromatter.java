package com.d3cima.udpie.services.Formatters;

public abstract class AbstractServiceMessageFromatter {
    protected String section;
    protected String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
