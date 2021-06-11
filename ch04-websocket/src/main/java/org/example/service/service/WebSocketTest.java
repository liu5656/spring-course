package org.example.service.service;

import org.java_websocket.WebSocketImpl;

public class WebSocketTest {
    public static void main(String[] args) {
        WebSocketImpl.DEBUG = false;
        int port = 8887;
        WsServer server = new WsServer(port);
        server.start();
    }
}
