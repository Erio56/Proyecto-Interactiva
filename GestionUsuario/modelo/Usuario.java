/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuario.modelo;

import Utilidades.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class Usuario {

    private String nombre, apellido, contraseña, correo, tipoUsuario, estado;
    private long identificacion, telefono;
    int id;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String contraseña, String correo, String tipoUsuario, String estado, long identificacion, long telefono, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario iniciarSesion() {
        Conexion c = new Conexion();
        Usuario u = null;
        String sql = "select * from usuario where identificacion='" + this.identificacion + "' and contrasena='" + this.contraseña + "' ";
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setIdentificacion(rs.getLong("identificacion"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(rs.getLong("telefono"));
                u.setContraseña(rs.getString("contrasena"));
                u.setTipoUsuario(rs.getString("tipo_usuario"));
            }
            c.cerrarConexion();
        } catch (SQLException e) {

        }

        return u;
    }

    public boolean registrarUsuario() {
        Conexion c = new Conexion();
        boolean exito = false;
        String sql = "insert into usuario(identificacion,nombre,apellido,correo,telefono,tipo_usuario,contrasena,estado)";
        sql += "values (";
        sql += "'" + this.identificacion + "','" + this.nombre + "','" + this.apellido + "','" + this.correo + "','" + this.telefono + "','" + this.tipoUsuario
                + "','" + this.contraseña + "','" + this.estado + "')";
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
        return exito;
    }

    public DefaultTableModel listarUsuarios(DefaultTableModel modelo) {
        Conexion c = new Conexion();
        String[] lista = new String[5];

        String sql = "SELECT * FROM usuario";
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                if(rs.getString("estado").equals("Activo")){
                lista[0] = rs.getString("id");
                lista[1] = rs.getString("identificacion");
                lista[2] = rs.getString("nombre");
                lista[3] = rs.getString("apellido");
                lista[4] = rs.getString("telefono");
                modelo.addRow(lista);
                }
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

        return modelo;
    }

    public Usuario consultaUsuarioId(int id) {
        Conexion c = new Conexion();
        Usuario u = null;
        String sql = "select * from usuario where id=" + id;
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setIdentificacion(Long.parseLong(rs.getString("identificacion")));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(Long.parseLong(rs.getString("telefono")));
                u.setContraseña(rs.getString("contrasena"));
                u.setTipoUsuario(rs.getString("tipo_usuario"));
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

        return u;
    }

    public void actualizarUsuario() {
        Conexion c = new Conexion();
        boolean exito = false;
        String sql = "update usuario set identificacion='" + this.identificacion + "',";
        sql += "nombre = '" + this.nombre + "',";
        sql += "apellido = '" + this.apellido + "',";
        sql += "correo = '" + this.correo + "',";
        sql += "telefono = '" + this.telefono + "',";
        sql += "tipo_usuario = '" + this.tipoUsuario + "',";
        sql += "contrasena = '" + this.contraseña + "',";
        sql += "estado = '" + this.estado + "' ";
        sql += " where id = " + this.id;
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
    }

    public boolean verificarIdentificacion(String cadena) {
        Conexion c = new Conexion();
        Usuario u = null;
        String sql = "select * from usuario where identificacion='" + cadena + "' ";
        boolean estado = false;
        try {
                ResultSet rs = c.ejecutarQuery(sql);
                if(rs.next()){
                    estado = true;
                }
                
            c.cerrarConexion();
        } catch (SQLException e) {

        }
        
        return estado;
    }
    
    public boolean verificarIdentificacion(String cadena, String id) {
        Conexion c = new Conexion();
        Usuario u = null;
        String sql = "select * from usuario where identificacion='" + cadena + "' ";
        boolean estado = false;
        try {
                ResultSet rs = c.ejecutarQuery(sql);
                while(rs.next()){
                    if(!rs.getString("id").equals(id)){
                        estado = true;
                    }
                }
                
            c.cerrarConexion();
        } catch (SQLException e) {

        }
        
        return estado;
    }

}
