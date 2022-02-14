/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionCita.controlador;

import GestionCita.modelo.Citas;
import GestionCita.vista.Registro_cita;
import GestionCita.vista.DetallesCita;
import GestionCita.vista.Listado_cita;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brayan
 */
public class ControlCita {
Registro_cita Iu_AgendarCita;
Listado_cita Iu_GestionCita;
DetallesCita Iu_EditarCita;

    
    public ControlCita() {
    }
    
    public void RegistrarCita() {
        Citas c = new Citas();
             
        c.setIdInmueble(Iu_AgendarCita.getIdInmueble());
        c.setCliente(Iu_AgendarCita.getClienteSeleccionado());
        c.setAgente(Iu_AgendarCita.getAgenteSeleccionado());
        c.setEstado("Activa");
        c.setFecha(Iu_AgendarCita.getFechaVenta());
        c.setObservaciones(Iu_AgendarCita.getObservaciones());

        if (!c.RegistrarCita()) {
            JOptionPane.showMessageDialog(null, "Cita creada exitosamente");
            Iu_AgendarCita.dispose();
        }
    }
    
    public void listadoUsuarios(DefaultTableModel modelo,String usuario){
        Citas c = new Citas();
        c.listarUsuarios(modelo, usuario);
    }
    
    public void listadoCitas(){
        Citas c = new Citas();
        c.listarCitas(this.Iu_GestionCita.getModelo());
    }
    
    public void consultarCitaId(int id) {
        Citas c = new Citas();
        
        c = c.consultarCitaId(id);
        
    }
    
//    public void ListarCitas() {
//        Citas u = new Citas();
//        ArrayList<Citas> Agenda = u.ListarCitas();
//        
//        for (Citas us : Agenda) {
//            
//            String datos[] = {String.valueOf(us.getIdentificador()), us.getIdInmueble(),
//                us.getCliente(), us.getAgente(), us.getEstado(),
//                us.getFecha(), us.getObservaciones()};
//            this.Iu_GestionCita.AgregarFila(datos);
//        }
//
//    }
    
    
//    public void ConsultarCitaId(int Identificador) {
//        Citas u = new Citas();
//        //consulta un usuario por el id
//        u = u.ConsultaCitaId(Identificador);
//        EditarCita vu = new EditarCita();
//        //pongo la información del usuario en los campos
//
//        vu.setIdentificador(String.valueOf(u.getIdentificador()));
//        vu.setIdInmueble(u.getIdInmueble());
//        vu.setCliente(u.getCliente());
//        vu.setAgente(u.getAgente());
//        vu.setEstado(u.getEstado());
//        vu.setFecha(u.getFecha());
//        vu.setObservaciones(u.getObservaciones());
//    
//        vu.setLocationRelativeTo(Iu_GestionCita);
//        vu.setVisible(true);
//
//    }
    
    
//    public void ActualizarCita() {
//        Citas u = new Citas();
//        
//        u.setIdentificador(Integer.parseInt(Iu_EditarCita.getIdentificador()));
//        u.setIdInmueble(Iu_EditarCita.getIdInmueble());
//        u.setCliente(Iu_EditarCita.getCliente());
//        u.setAgente(Iu_EditarCita.getAgente());
//        u.setEstado(Iu_EditarCita.getEstado());
//        u.setFecha(Iu_EditarCita.getFecha());
//        u.setObservaciones(Iu_EditarCita.getObservaciones());
//
//        u.ActualizarCita();
//
//    }
    

    public Registro_cita getIu_AgendarCita() {
        return Iu_AgendarCita;
    }

    public void setIu_AgendarCita(Registro_cita Iu_AgendarCita) {
        this.Iu_AgendarCita = Iu_AgendarCita;
    }

    public Listado_cita getIu_GestionCita() {
        return Iu_GestionCita;
    }

    public void setIu_GestionCita(Listado_cita Iu_GestionCita) {
        this.Iu_GestionCita = Iu_GestionCita;
    }

    public DetallesCita getIu_EditarCita() {
        return Iu_EditarCita;
    }

    public void setIu_EditarCita(DetallesCita Iu_EditarCita) {
        this.Iu_EditarCita = Iu_EditarCita;
    }
    
    
    
}
