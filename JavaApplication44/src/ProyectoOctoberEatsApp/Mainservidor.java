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
                       mensajeEnviado = "1.VER_MENU";
                       break;
                   case 2:
                       mensajeEnviado = "AGREGAR_PEDIDO";
                       break;
                   case 3:
                       mensajeEnviado = "VER_MENU";
                       break;
                   case 4:
                       mensajeEnviado = "VER_PEDIDO";
                       break;
                   case 5:
                       mensajeEnviado = "VER_ITEMS";
                       break;
                   case 6:
                       mensajeEnviado = "";
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
    
public void agregarPedido(){
    try {
        System.out.println("Ingrese su correo electrónico para iniciar sesión:");
        String correo = entrada.readUTF();

        Autenticacion autenticacion = new Autenticacion(baseDatosClientes);
        Usuario usuario = autenticacion.obtenerUsuarioPorCorreo(correo);

        if (usuario != null) {
        Restaurante restauranteElegido = obtenerRestaurante();
        List<MenuItem> itemsSeleccionados = elegirItemsMenu(restauranteElegido.getMenu());
        Pedido nuevoPedido = new Pedido(usuario, restauranteElegido, false, itemsSeleccionados);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido agregado con éxito");
            } else {
                System.out.println("Usuario no encontrado. Inicie sesión primero");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public void mostrarRestaurantesCercanos(){
    
    System.out.println("restaurantes cercanos: ");
    for (Restaurante restaurante : restaurantesDisponibles){
        System.out.println("_"+restaurante.getNombre()+"("+
                restaurante.getUbicacion()+")");
        
        
    }

}
private void mostrarMenu(){
    System.out.println("1.Agregar pedido");
    System.out.println("2.VER MENU");
    System.out.println("3.Mostrar Restaurantes cercanos");
    System.out.println("4.Ver_pedido");
    System.out.println("5.Iniciar Sesion");
    System.out.println("6. MENU items");
    System.out.println("7.Salir");
    System.out.println("SELECCIONE UNA OCPION");
}
public void verPedido(){
    System.out.println("ingrese su correo electronico para ver su pedido:");
    String correo = entrada.readUTF();
    
    Usario usario = BaseDatosCliente.obtenerUsuarioPorCorreo(correo);
    
    if (usuario !=null){
        
        pedido ultimoPedido = obtenerUltimoPedidoConfirmado(usario);
        if (ultimoPedido != null){
            System.out.println("Detalles del pedido");
            System.out.println("Items :");
            for (MenuItem item : ultimoPedido.getItems()){
            System.out.println("_"+item.getNombre()+ ": $"+ item.getPrecio());
         
            }
        }
        System.out.println("Costo totsl "+ calcularCostoTotalPedido(ultimoPedido));
        
        }else{
        System.out.println("NO HAY PEDIDOS PENDIENTES PARA ESTE USARIO ");
    }else{
    System.out.println("usuario no encontroado inicie sesion primero ");
        
            }
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