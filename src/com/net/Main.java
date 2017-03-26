package com.net;

import com.sun.jndi.toolkit.url.Uri;

import java.io.*;
import java.net.*;

/**
 * Created by Ashraf-XCODER on 3/21/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        //URI uri = new URI("http://www.google.com");


        //Reletivise
        //Resolve


        //http://docs.oracle.com/javase/1.3/docs/guide/index.html
        ///index.html
        //guide/index.html


        ///urdu/regional-39396741
        //www.bbc.com/urdu
        //URI uri = new URI("http://docs.oracle.com/javase/1.3/docs/guide/index.html");

        URI uri = new URI("http://www.bbc.com/urdu");


        //URI uri2 = new URI("/urdu/regional-39396741");

        //System.out.println(uri1.relativize(uri));

        //System.out.println(uri1.resolve(uri2));


        URL url = uri.toURL();

        //showUrlContents(url);


        downloadBBCSiteMainPage(url);













    }

    private static void downloadBBCSiteMainPage(URL url) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(url.openStream());


        File file = new File("bbc.html");
        if (!file.exists()){
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream("bbc.html");
        int data;
        while((data = bis.read()) > 0){
            fos.write(data);
        }
    }

    private static void showUrlContents(URL url) throws IOException {
        InputStreamReader isr = new InputStreamReader(url.openStream());

        BufferedReader br = new BufferedReader(isr);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}
