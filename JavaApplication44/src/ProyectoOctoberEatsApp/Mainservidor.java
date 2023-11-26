/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoOctoberEatsApp;


import java.io.*;
import java.util.Scanner;
import java.net.*;
import javax.swing.JOptionPane;
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
           while(!mensajeEnviado.equals("SALIR"))
           {
               //me voya comunicar con el cliente , siempre y cuasnod no se escriba la palabra salir
               mensajeRecibido = entrada.readUTF();
               System.out.println("Mensaje del cliente :  " + mensajeRecibido);
               System.out.println();
               System.out.println("Digite una respuesta para el cliente");
               mensajeEnviado = lectura.nextLine();
               
               salida.writeUTF(mensajeEnviado);
           }
            
        }
        catch(IOException error)
        {
            JOptionPane.showMessageDialog(null, "Se presento un error " + error);
        }
    }
    
}
public void iniciarConexion(){
try{
String mensajeEnviado
}
}