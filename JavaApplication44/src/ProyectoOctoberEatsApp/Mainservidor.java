/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoOctoberEatsApp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*; 
import java.util.Scanner;
import java.net.*;
import javax.swing.JOptionPane;
import java.io.IOException;
/**
 *
 * @author 50664
 */
public class Mainservidor {
    private static final String HOST = "localhost";
    private static final int PUERTO = 5000;
    
    private ServerSocket Mservidor;
    private Socket Mcliente;
    
    private DataOutputStream salida;
    private DataInputStream entrada;
    private String mensajeRecibido;
    
    public void inicarServidor()
    {
        Scanner lectura = new Scanner(  System.in);
        
        try
        {
            Mservidor = new ServerSocket(PUERTO);
            Mcliente = new Socket();
            
            System.out.println("Esperando conexion");
            
            //recibiendo clientes
            
            Mcliente = Mservidor.accept();
            
            System.out.println("Se conectro un cliente ...");
            
            //Atender al cliente : preguntarf que necesita?
            
           entrada = new DataInputStream(Mcliente.getInputStream());
           
           salida = new DataOutputStream(Mcliente.getOutputStream());
           
           //prepararnos la respuesta del cliente y establecer el espacio de comunicacion
           String mensajeEnviado ="";
           while(!mensajeEnviado.equals("SALIR")){
               
               mostrarMenu();
               
               
               int opcion = entrada.readInt();
               
               switch (opcion){
                   case 1:
                       mensajeEnviado = "Menu";
                       break;
                   case 2:
                       mensajeEnviado = "Menu";
                       break;
                   case 3:
                       mensajeEnviado = "Menu";
                       break;
                   case 4:
                       mensajeEnviado = "Menu";
                       break;
                   case 5:
                       mensajeEnviado = "Menu";
                       break;
                   case 6:
                       mensajeEnviado = "Menu";
                       break;
                   case 7:
                       mensajeEnviado = "SALIR";
                       break;
                   default:
                       mensajeEnviado = "Opcion no valida, intente de nuevo ";
                       break;
               }
               
                
                cerrarConexion();
                
           }
        }catch(IOException error){
            JOptionPane.showMessageDialog(null,"Se preseneto un  error" + error);
           
        }
}   
private void mostrarMenu(){
    System.out.println("-----MENU-----");
    System.out.println("-----MENU-----");
    System.out.println("-----MENU-----");
    System.out.println("-----MENU-----");
    System.out.println("-----MENU-----");
    System.out.println("-----MENU-----");
    System.out.println("-----MENU-----");
}
         
public void enviarMensaje(String mensaje){
    try{
        salida.writeUTF(mensaje);
        
    } catch (IOException e){
      e.printStackTrace();
    }
}

public void cerrarConexion(){
   try{
       Mcliente.close();
       Mservidor.close();
       entrada.close();
       salida.close();
   }catch(IOException e){
       e.printStackTrace();
   }
}
}