package com.sockets;

import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Ashraf-XCODER on 4/11/2017.
 */
public class MultithreadedPortScanner extends AbstractPortScanner implements Runnable {


    public MultithreadedPortScanner() {
        super();
    }

    public MultithreadedPortScanner(int lowerPort, int upperPort) {
        super(lowerPort, upperPort);
    }

    @Override
    public void run() {
        showAllOpenPorts();
    }
}
