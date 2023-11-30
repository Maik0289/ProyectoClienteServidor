/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoOctoberEatsApp;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Maik
 */
public class BaseDatosRestaurantes {
    ConexionBD conexion = new ConexionBD();
    ResultSet resultado = null;

    public void consultarRestaurantes() {
        try {
            conexion.setConexion();
            conexion.setConsulta("select idRestaurante, nombre, ubicacion, disponible from restaurante");
            resultado = conexion.getResultado();

            while (resultado.next()) {
                int idRestaurante = resultado.getInt("idRestaurante");
                String nombre = resultado.getString("nombre");
                String ubicacion = resultado.getString("ubicacion");
                boolean disponible = resultado.getBoolean("disponible");

                System.out.println("ID: " + idRestaurante + " - Nombre: " + nombre +
                        " - Ubicación: " + ubicacion + " - Disponible: " + disponible);
            }

            conexion.cerrarConexion();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public void insertarRestaurante(String nombre, String ubicacion, boolean disponible) {
        conexion.setConexion();
        conexion.setConsulta("Insert into restaurante(nombre, ubicacion, disponible) values(?,?,?)");
        conexion.getConsulta().setString(1, nombre);
        conexion.getConsulta().setString(2, ubicacion);
        conexion.getConsulta().setBoolean(3, disponible);
        if (conexion.getConsulta().executeUpdate() > 0) {
            System.out.println("Se insertó el restaurante!");
        } else {
            System.out.println("Error en la ejecución!");
        }
    }
    public void actualizarRestaurante(int id, String nombre, String ubicacion, boolean disponible) {
        conexion.setConexion();
        conexion.setConsulta("UPDATE restaurante SET nombre=?, ubicacion=?, disponible=? WHERE idRestaurante=?");
        conexion.getConsulta().setString(1, nombre);
        conexion.getConsulta().setString(2, ubicacion);
        conexion.getConsulta().setBoolean(3, disponible);
        conexion.getConsulta().setInt(4, id);
        if (conexion.getConsulta().executeUpdate() > 0) {
            System.out.println("Restaurante actualizado!");
        } else {
            System.out.println("Error en la actualización!");
        }
        conexion.cerrarConexion();
}

public void eliminarRestaurante(int id) {
    conexion.setConexion();
    conexion.setConsulta("DELETE FROM restaurante WHERE idRestaurante = " + id);
    if (conexion.getConsulta().executeUpdate() > 0) {
        System.out.println("Se eliminó el restaurante!");
    } else {
        System.out.println("Error en la ejecución del borrado!");
    }
    conexion.cerrarConexion();
}

    public void consultarRestaurantePorId(int id) {
        try {
            conexion.setConexion();
            conexion.setConsulta("SELECT idRestaurante, nombre, ubicacion, disponible FROM restaurante WHERE idRestaurante = " + id);
            resultado = conexion.getResultado();

         while (resultado.next()) {
            int idRestaurante = resultado.getInt("idRestaurante");
            String nombre = resultado.getString("nombre");
            String ubicacion = resultado.getString("ubicacion");
            boolean disponible = resultado.getBoolean("disponible");

            System.out.println("ID: " + idRestaurante + " - Nombre: " + nombre +
                    " - Ubicación: " + ubicacion + " - Disponible: " + disponible);
        }

            conexion.cerrarConexion();
        } catch (SQLException error) {
        }
}
   
}

    

