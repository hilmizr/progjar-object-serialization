/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package objectclient;

import com.objectmessage.Kewan;
import com.objectmessage.Person;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6666);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
            
            System.out.println("Client connected to server.");
            
            // create a new Person object and set its attributes
            Person p = new Person();
            p.setFullname("Takeshi Hongo");
            p.setAge(25);
            
            // create a new Kewan object and set its attributes
            Kewan k = new Kewan();
            k.setName("Asu");
            k.setLegs(4);
            
            // serialize the objects and send them to the server
            oos.writeObject(k);
            oos.writeObject(p);
            oos.writeObject(null); // indicate that there are no more objects to be sent
            oos.flush();
            System.out.println("Sent objects to server.");
            
        } catch (IOException e) {
            Logger.getLogger(ObjectClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}