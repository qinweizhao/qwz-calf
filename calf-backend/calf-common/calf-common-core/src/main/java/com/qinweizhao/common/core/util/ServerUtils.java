package com.qinweizhao.common.core.util;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author qinweizhao
 * @since 2022/3/19
 */
@Component
public class ServerUtils implements ApplicationListener<WebServerInitializedEvent> {

    private final static String HTTP = "http://";

    private int serverPort;

    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        assert address != null;
        return HTTP + address.getHostAddress() + ":" + this.serverPort + "/";
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }

}
