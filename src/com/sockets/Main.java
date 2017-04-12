package com.sockets;

import com.http.proto.HeaderCollection;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/**
 * Created by Ashraf-XCODER on 4/10/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {



        portScanningDriver(12, true);
        


    }


    public static void portScanningDriver(int totalThreads, boolean isMultithreaded) {

        if (isMultithreaded) {
            int upperLimit = 1;
            for (int i = 1; i <= totalThreads; i++) {
                MultithreadedPortScanner scanner = new MultithreadedPortScanner(upperLimit, i * 100);
                Thread thread = new Thread(scanner);
                thread.start();
                upperLimit = i * 200;
            }
        }
    }










































    private static Socket getSocket(String ip) throws IOException {
        String req =
            "GET / HTTP/1.1\n" +
            "Host: www.bbc.com\n" +
            "Connection: keep-alive\n" +
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
            "Accept-Encoding: gzip, deflate, sdch\n" +
            "Accept-Language: en-US,en;q=0.8\n" ;
        Socket socket = new Socket(ip, 80);
        InputStream inputStream = socket.getInputStream();
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println(req);
        writer.flush();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = bufferedReader.readLine();
        parseHeader(line);

        while (line  != null){
//            if (line.startsWith("Location:")){
//                System.out.println("URL" + line.substring(line.indexOf(":")).trim());
//            }
            if (line.equals("")){
                System.out.print("body started");
            }
            //System.out.println(line);
            line = bufferedReader.readLine();
        }
        return socket;
    }

    //HTTP/1.1 301 Moved Permanently
    //Location: http://education.oracle.com/pls/web_prod-plq-dad/db_pages.getpage?page_id=3

    private static void parseHeader(String line) {

        String afterHttp = line.substring(line.indexOf(" "));

        int firstSpace = line.indexOf(' ');
        if (firstSpace > 0){
            line = line.substring(firstSpace).trim();
            int statusCode = Integer.parseInt(line.substring(0, line.indexOf(' ')).trim());
            System.out.println(statusCode);
            System.out.println(line.substring(line.indexOf(' ')).trim());
        }
    }

    public static void tokenize(Reader reader){
        StreamTokenizer tokenizer = new StreamTokenizer(reader);
        tokenizer.eolIsSignificant(true);
        tokenizer.slashSlashComments(false);
        tokenizer.ordinaryChar('/');
        try {
            int token = tokenizer.nextToken();
            while (token != StreamTokenizer.TT_EOL){
                switch (token){
                    case StreamTokenizer.TT_NUMBER:
                        System.out.println(tokenizer.nval);
                        break;
                    case StreamTokenizer.TT_WORD:
                        System.out.println(tokenizer.sval);
                        break;
                    default:
                        break;
                }
                token = tokenizer.nextToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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



