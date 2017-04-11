package com.sockets;

import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Ashraf-XCODER on 4/11/2017.
 */
public class PortScanner extends AbstractPortScanner {
    public PortScanner() {
        super();
    }

    public PortScanner(int lowerPort, int upperPort) {
        super(lowerPort, upperPort);
    }
}
