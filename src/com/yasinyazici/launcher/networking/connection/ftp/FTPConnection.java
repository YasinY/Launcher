package com.yasinyazici.launcher.networking.connection.ftp;

import com.yasinyazici.launcher.config.Directories;
import com.yasinyazici.launcher.networking.connection.Connection;
import com.yasinyazici.launcher.networking.connection.ConnectionData;
import com.yasinyazici.launcher.networking.connection.NetworkConstants;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Yasin on 23.07.2016.
 */
public class FTPConnection extends Connection {

    private FTPClient ftpClient = new FTPClient();

    public FTPConnection(ConnectionData connectionData) {
        super(connectionData);
    }

    @Override
    public void setConnection() throws IOException {
        int reply;
        ftpClient.connect(NetworkConstants.REQUEST_SERVER_ADDRESS);
        ftpClient.login(NetworkConstants.REQUEST_SERVER_USERNAME, "");
        reply = ftpClient.getReply();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            System.err.println("FTP server refused connection.");
        }
        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE); //For transfering the files from server to client
    }

    public void fetchFiles() {
        try {
            FTPFile[] ftpFiles = ftpClient.listFiles();
            File[] localFiles = Directories.LAUNCHER_DIRECTORY.listFiles();
            for (File file : localFiles != null ? localFiles : new File[0]) {
                for (FTPFile ftpFile : ftpFiles) {
                    if (!ftpFile.getName().equalsIgnoreCase(file.getName())) {
                        getFtpClient().retrieveFile(ftpFile.getName(), new BufferedOutputStream(new FileOutputStream(file)));
                        System.out.println("Downloading data..");
                    } else {
                        System.out.println("Failed");
                    }
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }
}
