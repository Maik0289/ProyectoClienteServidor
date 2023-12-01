
package ProyectoOctoberEatsApp;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BaseDatosClientes {
    ConexionBD conexion = new ConexionBD();
    ResultSet resultado = null;

    public void consultarClientes() {
        try {
            conexion.setConexion();
            conexion.setConsulta("select idCliente, nombre, direccion, correoElectronico from cliente");
            resultado = conexion.getResultado();

            while (resultado.next()) {
                int idCliente = resultado.getInt("idCliente");
                String nombre = resultado.getString("nombre");
                String direccion = resultado.getString("direccion");
                String correoElectronico = resultado.getString("correoElectronico");

                System.out.println("ID: " + idCliente + " - Nombre: " + nombre +
                        " - Dirección: " + direccion + " - Correo Electrónico: " + correoElectronico);
            }

            conexion.cerrarConexion();
        } catch (SQLException error) {
        }
    }

    public void insertarCliente(String nombre, String direccion, String correoElectronico) {
        conexion.setConexion();
        conexion.setConsulta("Insert into cliente(nombre, direccion, correoElectronico) values(?,?,?)");
        conexion.getConsulta().setString(1, nombre);
        conexion.getConsulta().setString(2, direccion);
        conexion.getConsulta().setString(3, correoElectronico);
        if (conexion.getConsulta().executeUpdate() > 0) {
            System.out.println("Se insertó el cliente!");
        } else {
            System.out.println("Error en la ejecución!");
        }
    }

  public void actualizarCliente(int id, String nombre, String direccion, String correoElectronico) {
      conexion.setConexion();
      conexion.setConsulta("UPDATE cliente SET nombre=?, direccion=?, correoElectronico=? WHERE idCliente=?");
      conexion.getConsulta().setString(1, nombre);
      conexion.getConsulta().setString(2, direccion);
      conexion.getConsulta().setString(3, correoElectronico);
      conexion.getConsulta().setInt(4, id);
      if (conexion.getConsulta().executeUpdate() > 0) {
          System.out.println("Cliente actualizado!");
      } else {
          System.out.println("Error en la actualización!");
      }
      conexion.cerrarConexion();
}

public void eliminarCliente(int id) {
    conexion.setConexion();
    conexion.setConsulta("DELETE FROM cliente WHERE idCliente = " + id);
    if (conexion.getConsulta().executeUpdate() > 0) {
        System.out.println("Se eliminó el cliente!");
    } else {
        System.out.println("Error en la ejecución del borrado!");
    }
    conexion.cerrarConexion();
}

public void consultarClientePorId(int id) {
    try {
        conexion.setConexion();
        conexion.setConsulta("SELECT idCliente, nombre, direccion, correoElectronico FROM cliente WHERE idCliente = " + id);
        resultado = conexion.getResultado();

        while (resultado.next()) {
            int idCliente = resultado.getInt("idCliente");
            String nombre = resultado.getString("nombre");
            String direccion = resultado.getString("direccion");
            String correoElectronico = resultado.getString("correoElectronico");

            System.out.println("ID: " + idCliente + " - Nombre: " + nombre +
                    " - Dirección: " + direccion + " - Correo Electrónico: " + correoElectronico);
        }

        conexion.cerrarConexion();
    } catch (SQLException error) {
        error.printStackTrace();
    }
}

    Usuario obtenerUsuarioPorCorreo(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


