package tester;


import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import com.tartanga.dam.imhandroid.model.Message;


public class ThreadSender extends Thread {

    private MessageListener listener;
    private Socket cs;
    private Message msg;
    public ThreadSender(Object listener, Socket cs, Message msg) {
        this.listener = ((MessageListener) listener);
        this.cs = cs;
        this.msg = msg;
    }

    @Override
    public void run() {
        ObjectInputStream in;
        ObjectOutputStream out;
        Object input;
        try {
            System.out.println("try");
            out = new ObjectOutputStream(cs.getOutputStream());
            in = new ObjectInputStream(cs.getInputStream());
            System.out.println("beforeWrite");
            out.writeObject(msg);
            input = in.readObject();
            listener.messageReceived(input);
            cs.close();
        }catch (SocketException | EOFException e) {
            connectionLost();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void connectionLost() {
    }
}
