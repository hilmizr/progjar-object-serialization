/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package objectserver;

import com.objectmessage.Kewan;
import com.objectmessage.Person;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(6666);
             Socket socket = server.accept();
             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
            
            System.out.println("Server started. Waiting for client connection...");
            System.out.println("Client connected.");
            
            // read serialized objects from the client
            Object obj;
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Person) {
                    Person p = (Person) obj;
                    System.out.println("Received Person object from client:");
                    System.out.println("Full Name: " + p.getFullname() + ", Age: " + p.getAge());
                } else if (obj instanceof Kewan) {
                    Kewan k = (Kewan) obj;
                    System.out.println("Received Kewan object from client:");
                    System.out.println("Name: " + k.getName() + ", Legs: " + k.getLegs());
                } else {
                    System.out.println("Received unknown object from client: " + obj);
                }
            }
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error handling client request: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


