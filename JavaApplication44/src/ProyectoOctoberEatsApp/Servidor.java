/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoOctoberEatsApp;

/**
 *
 * @author Maik
 */
public class Servidor {
    private BaseDatosClientes baseDatosClientes;
    
    public Servidor(BaseDatosClientes baseDatosClientes) {
        this.baseDatosClientes = baseDatosClientes;
    }
    
    public boolean autenticarUsuario(String correoElectronico, String contrasena) {
        return baseDatosClientes.autenticarUsuario(correoElectronico, contrasena);
    }
}
