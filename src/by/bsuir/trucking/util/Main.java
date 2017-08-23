package by.bsuir.trucking.util;

import by.bsuir.trucking.transfer.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static final int PORT = 9000;

    public static void main(String[] args) {
        try {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket userSocket = serverSocket.accept();
            System.out.println(userSocket.getInetAddress().getHostName() + " connected");
            ServerThread server = new ServerThread(userSocket);
            server.start();
        }
    } catch (IOException e) {
        System.err.println(e);
    }
    }
}
