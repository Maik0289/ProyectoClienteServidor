/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoOctoberEatsApp;

/**
 *
 * @author danirodriguez
 */
public class Autenticacion {
    private BaseDatosClientes baseDatosClientes;

    public Autenticacion(BaseDatosClientes baseDatosClientes) {
        this.baseDatosClientes = baseDatosClientes;
    }

    public boolean autenticarUsuario(String correo, String contrasena) {
        //Autenticación utilizando la base de datos
        Usuario usuario = baseDatosClientes.obtenerUsuarioPorCorreo(correo);
        return usuario != null && usuario.getContrasena().equals(contrasena);
    }
}

