package com.yasinyazici.launcher.networking.connection;

import com.yasinyazici.launcher.networking.connection.ftp.FTPConnection;

/**
 * Created by Yasin on 28.07.2016.
 */
public class ConnectionHandler {


    private FTPConnection ftpConnection;

    public ConnectionHandler(Connection connection, FTPConnection ftpConnection) {

        this.ftpConnection = ftpConnection;
    }





    public FTPConnection getFtpConnection() {
        return ftpConnection;
    }

    public void setFtpConnection(FTPConnection ftpConnection) {
        this.ftpConnection = ftpConnection;
    }
}
