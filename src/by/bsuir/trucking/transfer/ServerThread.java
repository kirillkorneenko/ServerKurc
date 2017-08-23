package by.bsuir.trucking.transfer;

import by.bsuir.trucking.entity.Batch;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    protected InetAddress address;

    public ServerThread(Socket socket) throws IOException {
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());
        address = socket.getInetAddress();
    }

    public void run() {
        try {
            Batch receivedBatch = (Batch)inputStream.readObject();
            outputStream.writeObject(Controller.getCommand(receivedBatch.getCommand()).execute(receivedBatch.getDate()));
        } catch (IOException e) {
            System.out.println("Disconnect");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        try {
            System.out.println(address.getHostName() + " disconnected");
            outputStream.close();
            inputStream.close();
            address = null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }
}
