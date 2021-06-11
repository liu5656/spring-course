package org.example.service.service;

import org.java_websocket.WebSocket;

import java.util.*;

public class WsPool {
    private static final Map<WebSocket, String> wsUserMap = new HashMap<WebSocket, String>();

    // 通过WebSocket对象获取对应的用户
    public static String getUserBy(WebSocket conn) {
        return wsUserMap.get(conn);
    }

    public static WebSocket getWSby(String userName) {
        WebSocket result = null;
        Set<Map.Entry<WebSocket, String>> entries = wsUserMap.entrySet();
        for (Map.Entry<WebSocket, String> entry : entries) {
            String value = entry.getValue();
            if (value.equals(userName)) {
                result = entry.getKey();
            }
        }
        return result;
    }
    public static void addUse(String userName, WebSocket conn) {
        wsUserMap.put(conn, userName);
    }
    // 获取所有不重复的用户
    public static Collection<String> getOnlineUser() {
        List<String> result = new ArrayList<String>();
        result.addAll(wsUserMap.values());
        return  result;
    }
    // 移除指定连接
    public static boolean remove(WebSocket conn) {
        if (wsUserMap.containsKey(conn)) {
            wsUserMap.remove(conn);
            return true;
        }else{
            return false;
        }
    }
    // 向指定用户发送消息
    public static void sendMessageTo(WebSocket conn, String message) {
        if (null != conn && null != wsUserMap.get(conn)) {
            conn.send(message);
        }
    }

    // 向所有用户发送消息
    public static void sendMessageToAll(String message) {
        for (WebSocket conn : wsUserMap.keySet()) {
            conn.send(message);
        }
    }




}
