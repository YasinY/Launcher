package com.yasinyazici.launcher.networking.connection;

import java.io.IOException;

/**
 * Created by Yasin on 23.07.2016.
 * Parent class for initializing a constant connection with the server (NOT FTP!)
 */
public abstract class Connection {

    private ConnectionData connectionData;

    public Connection(ConnectionData connectionData) {
        this.connectionData = connectionData;
    }

    public void init() {
        try {
            setConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void setConnection() throws IOException;



    public ConnectionData getConnectionData() {
        return connectionData;
    }

    public void setConnectionData(ConnectionData connectionData) {
        this.connectionData = connectionData;
    }

}
