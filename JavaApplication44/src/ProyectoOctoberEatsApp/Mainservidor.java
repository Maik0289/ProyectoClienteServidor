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
            
            cliente = Mservidor.accept();
            
        }
        catch(IOException error)
        {
            JOptionPane.showMessageDialog(null, "Se presento un error " + error);
        }
    }
    
}

