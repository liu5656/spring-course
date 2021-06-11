package org.example.service.service;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class WsServer extends WebSocketServer {

    public WsServer(int port) {
        super(new InetSocketAddress(port));
    }
    public WsServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println(webSocket.toString() + "------" + clientHandshake.getResourceDescriptor());
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println(s);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println(message);
        if (null != message && message.startsWith("online")) {
            String name = message.replaceFirst("online", message);
            userJoin(conn, name);
        }else  if (null != message && message.startsWith("offline")) {

            userLeave(conn);
        }else{
            System.out.println(message);
        }
//        WsPool.sendMessageToAll("haha 123");
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.out.println("on error");
        e.printStackTrace();
    }

    // 移除WebSocket
    private void userLeave(WebSocket conn) {
        WsPool.remove(conn);
    }
    // 将webSocket加入用户池
    private void userJoin(WebSocket conn, String name) {
        WsPool.addUse(name, conn);
    }

}
