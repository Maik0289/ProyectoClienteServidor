/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoOctoberEatsApp;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author danirodriguez
 */
public class Aplicacion {
    public static void main(String[] args) {
        BaseDatosClientes baseDatosClientes = new BaseDatosClientes();
        Servidor servidor = new Servidor(baseDatosClientes);
        
        MenuItem item1 = new MenuItem("pizza","pizza recomnedada",1500);
        MenuItem item2= new MenuItem("Lasagna","lasagna de pollo",5000);
        MenuItem item3= new MenuItem("Lasagna","lasagna de pollo",5000);
        MenuItem item4= new MenuItem("Papas fiestaa","papas fiesta con queso y carne",2700);
        
        List<MenuItem> itemsMenu = new ArrayList<>();
        itemsMenu.add(item1);
        itemsMenu.add(item2);
        itemsMenu.add(item3);
        itemsMenu.add(item4);
        
        
        // crear restaurante 
        
        Menu menuRestaurante = new Menu(itemsMenu);
        
        Restaurante restaurantePizza= new Restaurante("Pizzeria la esquina ","cartago centroe",menuRestaurante,true);
        
  
        //Registroo de usuarios
        Usuario nuevoUsuario = new Usuario("Nombre", "Direccion", "correo@progra.com", "contrasena");
        baseDatosClientes.registrarUsuario(nuevoUsuario);
        
        //Autenticación de usuarios
        String correoElectronico = "correo@progra.com";
        String contrasena = "contrasena";
        if (servidor.autenticarUsuario(correoElectronico, contrasena)) {
            System.out.println("Login exitoso");
            //acceso a otras funciones    
        } else {
            System.out.println("Credenciales incorrectas. Iniciar sesión fallida");
        }
    }
}
