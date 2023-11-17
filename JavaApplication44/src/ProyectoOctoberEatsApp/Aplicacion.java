/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoOctoberEatsApp;

/**
 *
 * @author danirodriguez
 */
public class Aplicacion {
    public static void main(String[] args) {
        BaseDatosClientes baseDatosClientes = new BaseDatosClientes();
        Servidor servidor = new Servidor(baseDatosClientes);
        
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
