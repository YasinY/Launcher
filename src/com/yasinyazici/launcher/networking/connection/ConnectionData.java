package com.yasinyazici.launcher.networking.connection;

/**
 * Created by Yasin on 23.07.2016.
 */
public class ConnectionData {

    private String ip;

    private String token;

    private int id;

    private ConnectionType connectionType;

    public ConnectionData(String ip) {
        this.ip = ip;
    }

    public ConnectionData(String ip, String token) {
        this.ip = ip;
        this.token = token;
    }

    public ConnectionData(String ip, String token, int id) {
        this.ip = ip;
        this.token = token;
        this.id = id;
    }

    public ConnectionData(String ip, String token, int id, ConnectionType connectionType) {
        this.ip = ip;
        this.token = token;
        this.id = id;
        this.connectionType = connectionType;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public String getIp() {
        return ip;
    }
}
