package com.net;

import com.sun.jndi.toolkit.url.Uri;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;

/**
 * Created by Ashraf-XCODER on 3/21/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        Authenticator.setDefault(new ConsoleAuthenticator());

        URL postUrl = new URL("http://localhost:2727/api/data");
        HttpURLConnection httpURLConnection = (HttpURLConnection) postUrl.openConnection();
        httpURLConnection.setRequestMethod("POST");

        httpURLConnection.setDoOutput(true);
        OutputStream raw = httpURLConnection.getOutputStream();
        OutputStream buffered = new BufferedOutputStream(raw);
        OutputStreamWriter out = new OutputStreamWriter(buffered, "8859_1");

        out.write("name=ShafiqLovesPHP&age=15\r\n");
        out.flush();
        out.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

        while (true){
            String line = reader.readLine();
            if (line != null){
                System.out.println(line);
            }else break;
        }




        Thread.sleep(100 * 1000);


     //setDoOutput Test

        URL newUrl = new URL("http://localhost:2727/api/identity");

        URLConnection urlConnection1 = newUrl.openConnection();

        urlConnection1.setAllowUserInteraction(true);

        urlConnection1.connect();

        InputStream inputStream = urlConnection1.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while (true){
            String line = bufferedReader.readLine();
            if (line != null){
                System.out.println(line);
            }else break;
        }


    }

    private static void setFileNameMap(URLConnection urlConnection) {
        FileNameMap fileNameMap = urlConnection.getFileNameMap();
        System.out.println(fileNameMap.getContentTypeFor("html"));


        FileNameMap defaultNamingMap = new FileNameMap() {
            @Override
            public String getContentTypeFor(String fileName) {
                switch (fileName){
                    case "mp3":
                        return "audio/mp3";
                    case "jpe":
                        return "image/jpg";
                    case "html":
                        return "text/html";
                    case "json":
                        return "application/json";
                    case "xml":
                        return "application/xml";
                    case "pdf":
                        return "application/pdf";
                        default: return null;
                }
            }
        };

        URLConnection.setFileNameMap(defaultNamingMap);

        FileNameMap customFileNameMap = urlConnection.getFileNameMap();
        System.out.println(customFileNameMap.getContentTypeFor("pdf"));
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
