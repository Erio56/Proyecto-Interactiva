/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionInmueble.controlador;

import GestionInmueble.modelo.Inmueble;
import GestionInmueble.vista.DetallesInmueble;
import GestionInmueble.vista.Listado_inmueble;
import GestionInmueble.vista.Registro_inmueble;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class ControlInmueble {
    Registro_inmueble registro;
    Listado_inmueble listado;
    DetallesInmueble detallesInmueble;

    public ControlInmueble() {
    }
    
    public void registro(){
        Inmueble i = new Inmueble();
        i.setTipoInmueble(this.registro.getTipoInmueble());
        i.setArea(this.registro.getArea());
        i.setCantidadHabitaciones(this.registro.getCantidadHabitaciones());
        i.setCantidadBaños(this.registro.getCantidadBaños());
        i.setnPisos(this.registro.getNPisos());
        i.setDescripcion(this.registro.getDescripcion());
        i.setPrecio(this.registro.getPrecio());
        i.setFechaVenta(registro.getFechaVenta());
        i.setTipoProceso(this.registro.getTipoProceso());
        i.setDireccion(this.registro.getDireccion());
        i.setEstado("Activo");
        i.setAgenteEncargado(this.registro.getAgenteEncargado());
        
        if (!i.registrarInmueble()) {
            JOptionPane.showMessageDialog(null, "Inmueble creado exitosamente");
        }
    }
   
    public void listadoAgentesRegistro(){
        Inmueble i = new Inmueble();
        i.listarUsuarios(this.registro.getModelo());
    }
    
    public void listadoInmuebles(){
        Inmueble i = new Inmueble();
        i.listarInmuebles(this.listado.getModelo());
    }
    
    public void listadoAgentesInmueble(){
        Inmueble i = new Inmueble();
        i.listarUsuarios(this.detallesInmueble.getModelo());
    }
    
    public void consultarInmuebleId(int id) {
        Inmueble i = new Inmueble();
        //consulta un usuario por el id
        i = i.consultarInmuebleId(id);
        DetallesInmueble di = new DetallesInmueble();
        //pongo la información del usuario en los campos
        di.setTipoInmueble(i.getTipoInmueble());
        di.setArea(String.valueOf(i.getArea()));
        di.setCantidadHabitaciones(String.valueOf(i.getCantidadHabitaciones()));
        di.setCantidadBaños(String.valueOf(i.getCantidadBaños()));
        di.setNPisos(String.valueOf(i.getnPisos()));
        di.setDireccion(i.getDireccion());
        di.setPrecio(String.valueOf((long) i.getPrecio()));
        di.setId(String.valueOf(i.getId()));
        di.setFechaVenta(i.getFechaVenta());
        di.setTipoProceso(i.getTipoProceso());
        di.setEstado(i.getEstado());
        di.setAgenteEncargadoNombre(String.valueOf(i.getAgenteEncargado()));
        di.setAgenteEncargado(String.valueOf(i.getAgenteEncargado()));
        di.setDescripcion(i.getDescripcion());
        
        di.setLocationRelativeTo(listado);
        di.setVisible(true);
    }
    
    public void actualizarInmueble() {
        Inmueble i = new Inmueble();
        i.setTipoInmueble(this.detallesInmueble.getTipoInmueble());
        i.setArea(this.detallesInmueble.getArea());
        i.setCantidadHabitaciones(this.detallesInmueble.getCantidadHabitaciones());
        i.setCantidadBaños(this.detallesInmueble.getCantidadBaños());
        i.setnPisos(this.detallesInmueble.getNPisos());
        i.setDireccion(this.detallesInmueble.getDireccion());
        i.setPrecio(this.detallesInmueble.getPrecio());
        i.setId(this.detallesInmueble.getId());
        i.setFechaVenta(this.detallesInmueble.getFechaVenta());
        i.setTipoProceso(this.detallesInmueble.getTipoProceso());
        i.setEstado(this.detallesInmueble.getEstado());
        i.setAgenteEncargado(this.detallesInmueble.getAgenteEncargado());
        i.setDescripcion(this.detallesInmueble.getDescripcion());

        i.actualizarInmueble();
    }
    
    public Registro_inmueble getRegistro(){
        return registro;
    }
    
    public void setRegistro(Registro_inmueble registro){
        this.registro = registro;
    }
    
    public Listado_inmueble getListado(){
        return listado;
    }
    
    public void setListado(Listado_inmueble listado){
        this.listado = listado;
    }
    
    public DetallesInmueble getDetallesInmueble(){
        return detallesInmueble;
    }
    
    public void setDetallesInmueble(DetallesInmueble detallesInmueble){
        this.detallesInmueble = detallesInmueble;
    }
}
