/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionCita.modelo;

import Utilidades.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GUSTAVO RAMIREZ
 */
public class Citas {

    String Fecha, Observaciones, IdInmueble, Estado;
    int id, Cliente, Agente;

    public Citas() {
    }

    public Citas(String Fecha, String Observaciones, String IdInmueble, String Estado, int id, int Cliente, int Agente) {
        this.Fecha = Fecha;
        this.Observaciones = Observaciones;
        this.IdInmueble = IdInmueble;
        this.Estado = Estado;
        this.id = id;
        this.Cliente = Cliente;
        this.Agente = Agente;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getIdInmueble() {
        return IdInmueble;
    }

    public void setIdInmueble(String IdInmueble) {
        this.IdInmueble = IdInmueble;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return Cliente;
    }

    public void setCliente(int Cliente) {
        this.Cliente = Cliente;
    }

    public int getAgente() {
        return Agente;
    }

    public void setAgente(int Agente) {
        this.Agente = Agente;
    }

    public boolean RegistrarCita() {

        Conexion C = new Conexion();
        boolean Exito = false;
        String sql = "insert into citas(IdInmueble, Cliente, Agente, Estado, Fecha, Observaciones)";
        sql += "values (";
        sql += "'" + this.IdInmueble + "','" + this.Cliente + "','" + this.Agente + "','" + this.Estado + "','" + this.Fecha + "','" + this.Observaciones + "')";
        try {
            Exito = C.ejecutarSql(sql);
            C.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

        return Exito;

    }
    
    public DefaultTableModel listarUsuarios(DefaultTableModel modelo, String usuario) {
        Conexion c = new Conexion();
        String[] lista = new String[5];

        String sql = "select * from usuario where tipo_usuario='" + usuario + "' ";
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                lista[0] = rs.getString("id");
                lista[1] = rs.getString("nombre");
                lista[2] = rs.getString("apellido");
                modelo.addRow(lista);
            }
            c.cerrarConexion();
        } catch (SQLException e) {

        }

        return modelo;
    }
    
    public DefaultTableModel listarCitas(DefaultTableModel modelo) {
        Conexion c = new Conexion();
        String[] lista = new String[5];

        String sql = "SELECT * FROM citas";
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                if (rs.getString("estado").equals("Activa") || rs.getString("estado").equals("En proceso")) {
                    lista[0] = rs.getString("id");
                    lista[1] = rs.getString("IdInmueble");
                    lista[2] = rs.getString("Cliente");
                    lista[3] = rs.getString("Agente");
                    lista[4] = rs.getString("Estado");
                    modelo.addRow(lista);
                }
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

        return modelo;
    }

    public Citas consultarCitaId(int id) {
        Conexion c = new Conexion();
        Citas cc = null;
        String sql = "select * from citas where id=" + id;
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                cc = new Citas();
                cc.setId(rs.getInt("id"));
                cc.setIdInmueble(rs.getString("IdInmueble"));
                cc.setCliente(rs.getInt("Cliente"));
                cc.setAgente(rs.getInt("Agente"));
                cc.setEstado(rs.getString("Estado"));
                cc.setFecha(rs.getString("Fecha"));
                cc.setObservaciones(rs.getString("Observaciones"));
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

        return cc;
    }
    
}
