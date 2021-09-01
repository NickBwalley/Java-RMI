/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author nickb
 */
public class Server extends Implementation {
    public Server(){
        //this is just a constructoer
    }
    public static void main(String[] args){
        try{
            //instantiating the implementation class
            Implementation obj = new Implementation();
            //Exporting the object of the implementation class
            //Here we are exporting the remote object to the stub
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
            
            //Binding  the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);
            System.err.println("Server ready");
                       
        }catch(Exception e){
         System.err.println("Server exception: " + e.toString());
         e.printStackTrace();
        }
    }
    
}
