package com.net;

import java.io.Console;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Ashraf-XCODER on 3/29/2017.
 */
public class ConsoleAuthenticator extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        System.out.println("Enter Your User Name For " + this.getRequestingHost());
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println("Enter password");
        Console console = System.console();
        //char[] pass = console.readPassword("Enter your password : ");

        String password = scanner.nextLine();
        passwordAuthentication = new PasswordAuthentication(userName, password.toCharArray());

        return passwordAuthentication;
    }

    private PasswordAuthentication passwordAuthentication;

}
