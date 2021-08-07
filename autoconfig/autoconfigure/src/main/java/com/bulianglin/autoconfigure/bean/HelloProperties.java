package com.bulianglin.autoconfigure.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("bulianglin.hello")
public class HelloProperties {
    private String prefix;
    private String suffic;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffic() {
        return suffic;
    }

    public void setSuffic(String suffic) {
        this.suffic = suffic;
    }
}
