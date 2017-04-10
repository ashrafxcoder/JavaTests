package com.sockets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Ashraf-XCODER on 4/10/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String host = "www.google.com";
        String ip = getIpAddress(host);
        System.out.println(ip);


        Socket socket = new Socket(host, 80);

    }

    public static String getIpAddress(String host){
        try {
            InetAddress[] addresses = InetAddress.getAllByName(host);

            return addresses[0].getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}



