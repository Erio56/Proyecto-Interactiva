/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionInmueble.modelo;

import Utilidades.Conexion;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
//Falta el objeto de angete inmobiliario
public class Inmueble {

    private String tipoInmueble, descripcion, direccion,
            tipoProceso, estado, fechaVenta;
    private int cantidadHabitaciones, cantidadBaños, nPisos, id;
    private double area, precio;
    private long agenteEncargado;

    public Inmueble() {
    }

    public Inmueble(String tipoInmueble, String descripcion, String direccion, String tipoProceso, String estado, String fechaVenta, int cantidadHabitaciones, int cantidadBaños, int nPisos, int id, double area, double precio, long agenteEncargado) {
        this.tipoInmueble = tipoInmueble;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.tipoProceso = tipoProceso;
        this.estado = estado;
        this.fechaVenta = fechaVenta;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.cantidadBaños = cantidadBaños;
        this.nPisos = nPisos;
        this.id = id;
        this.area = area;
        this.precio = precio;
        this.agenteEncargado = agenteEncargado;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public int getCantidadBaños() {
        return cantidadBaños;
    }

    public void setCantidadBaños(int cantidadBaños) {
        this.cantidadBaños = cantidadBaños;
    }

    public int getnPisos() {
        return nPisos;
    }

    public void setnPisos(int nPisos) {
        this.nPisos = nPisos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public long getAgenteEncargado() {
        return agenteEncargado;
    }

    public void setAgenteEncargado(long agenteEncargado) {
        this.agenteEncargado = agenteEncargado;
    }

    public DefaultTableModel listarUsuarios(DefaultTableModel modelo) {
        Conexion c = new Conexion();
        String[] lista = new String[5];

        String sql = "select * from usuario where tipo_usuario='" + "Agente Inmobiliario" + "' ";
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

    public boolean registrarInmueble() {
        Conexion c = new Conexion();
        boolean exito = false;
        String sql = "insert into inmuebles(tipo_Inmueble,descripcion,dirección,tipo_Proceso,estado,fecha,cantidad_Habitaciones,"
                + "cantidad_Banos,n_Pisos,area,precio,agente)";
        sql += "values (";
        sql += "'" + this.tipoInmueble + "','" + this.descripcion + "','" + this.direccion + "','" + this.tipoProceso
                + "','" + this.estado + "','" + this.fechaVenta + "','" + this.cantidadHabitaciones + "','" + this.cantidadBaños
                + "','" + this.nPisos + "','" + this.area + "','" + this.precio + "','" + this.agenteEncargado + "')";
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
        return exito;
    }

    public DefaultTableModel listarInmuebles(DefaultTableModel modelo) {
        Conexion c = new Conexion();
        String[] lista = new String[6];

        String sql = "SELECT * FROM inmuebles";
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                if (rs.getString("estado").equals("Activo") || rs.getString("estado").equals("En proceso") || rs.getString("estado").equals("Terminado")) {
                    lista[0] = rs.getString("id");
                    lista[1] = rs.getString("tipo_Inmueble");
                    lista[2] = rs.getString("n_Pisos");
                    lista[3] = rs.getString("cantidad_Habitaciones");
                    lista[4] = rs.getString("precio");
                    lista[5] = rs.getString("estado");
                    modelo.addRow(lista);
                }
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

        return modelo;
    }

    public Inmueble consultarInmuebleId(int id) {
        Conexion c = new Conexion();
        Inmueble i = null;
        String sql = "select * from inmuebles where id=" + id;
        try {
            ResultSet rs = c.ejecutarQuery(sql);

            while (rs.next()) {
                i = new Inmueble();
                i.setId(rs.getInt("id"));
                i.setTipoInmueble(rs.getString("tipo_Inmueble"));
                i.setArea(rs.getDouble("area"));
                i.setCantidadHabitaciones(rs.getInt("cantidad_Habitaciones"));
                i.setCantidadBaños(rs.getInt("cantidad_Banos"));
                i.setnPisos(rs.getInt("n_Pisos"));
                i.setDescripcion(rs.getString("descripcion"));
                i.setDireccion(rs.getString("dirección"));
                i.setPrecio(rs.getDouble("precio"));
                i.setFechaVenta(rs.getString("fecha"));
                i.setTipoProceso(rs.getString("tipo_Proceso"));
                i.setEstado(rs.getString("estado"));
                i.setAgenteEncargado(rs.getLong("agente"));
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }

        return i;
    }

    public void actualizarInmueble() {
        Conexion c = new Conexion();
        boolean exito = false;
        String sql = "update inmuebles set tipo_Inmueble='" + this.tipoInmueble + "',";
        sql += "descripcion = '" + this.descripcion + "',";
        sql += "dirección = '" + this.direccion + "',";
        sql += "tipo_Proceso = '" + this.tipoProceso + "',";
        sql += "estado = '" + this.estado + "',";
        sql += "fecha = '" + this.fechaVenta + "',";
        sql += "cantidad_Habitaciones = '" + this.cantidadHabitaciones + "',";
        sql += "cantidad_Banos = '" + this.cantidadBaños + "',";
        sql += "n_Pisos = '" + this.nPisos + "',";
        sql += "area = '" + this.area + "',";
        sql += "precio = '" + this.precio + "',";
        sql += "agente = '" + this.agenteEncargado + "' ";
        sql += " where id = " + this.id;
        try {
            exito = c.ejecutarSql(sql);
            c.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
        }
    }
}
