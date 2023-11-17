/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoOctoberEatsApp;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Maik
 */
public class BaseDatosClientes {
   private List<Usuario> usuarios;
   
   public BaseDatosClientes() {
       this.usuarios = new ArrayList<>();
   }
   
   public void registrarUsuario(Usuario usuario) {
       usuarios.add(usuario);
   }
   
   public boolean autenticarUsuario(String correoElectronico, String contrasena) {
       for (Usuario usuario : usuarios) {
           if (usuario.getCorreoElectronico().equals(correoElectronico) &&
               usuario.getContrasena().equals(contrasena)) {
               return true;
           }
       }
       return false;
   }
}
