package com.sockets;

import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Ashraf-XCODER on 4/11/2017.
 */
public class AbstractPortScanner {
    private int lowerPort = 0;
    private int upperPort = 1024;

    public AbstractPortScanner() {
    }

    public AbstractPortScanner(int lowerPort, int upperPort) {
        this.lowerPort = lowerPort;
        this.upperPort = upperPort;
    }

    public int getLowerPort() {
        return lowerPort;
    }

    public void setLowerPort(int lowerPort) {
        this.lowerPort = lowerPort;
    }

    public int getUpperPort() {
        return upperPort;
    }

    public void setUpperPort(int upperPort) {
        this.upperPort = upperPort;
    }

    public void showAllOpenPorts(){

        for (int j = lowerPort; j < upperPort; j++) {
            try {
                Socket socket = new Socket(InetAddress.getLocalHost(), j);
                System.out.println("*******************port in use " + j);
            }catch (Exception e){
                System.out.println("port not in use " + j);
            }
        }
    }
}
