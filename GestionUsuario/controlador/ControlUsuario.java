/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuario.controlador;

import GestionUsuario.modelo.Usuario;
import GestionUsuario.vista.DetallesUsuario;
import GestionUsuario.vista.Listado_usuario;
import GestionUsuario.vista.Registro_usuario;
import GestionUsuario.vista.Sesion;
import Utilidades.EmptyException;
import Utilidades.IdentificacionException;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class ControlUsuario {

    Registro_usuario registro;
    Sesion sesion;
    Listado_usuario listado;
    DetallesUsuario detallesUsuario;

    public static Usuario usuario;

    public ControlUsuario() {
    }

    public void iniciarSesion() {
        try {
            //capturo datos de la venta de inicio de sesión
            String id = sesion.getIdentificacion();
            verificarVacios(id);
            String contraseña = sesion.getContraseña();
            verificarVacios(contraseña);
            //creo el objeto con los datos que conozco documento y clave
            Usuario u = new Usuario();
            u.setIdentificacion(Long.parseLong(id));
            u.setContraseña(contraseña);
            ControlUsuario.usuario = u.iniciarSesion();
            u = u.iniciarSesion();

            if (u != null) {
                if (u.getTipoUsuario().equals("Cliente")) {
                    sesion.activarCliente();
                } else if (u.getTipoUsuario().equals("Administrador")) {
                    sesion.activarAdministrador();
                } else {
                    sesion.activarAgente();
                }
                JOptionPane.showMessageDialog(this.sesion.v, "Bienvenido\n" + u.getNombre() + " " + u.getApellido());
                sesion.v.mostrarUsuario();
            } else {
                JOptionPane.showMessageDialog(this.sesion.v, "El usuario no existe");
            }
        } catch (EmptyException ex) {
            JOptionPane.showMessageDialog(this.sesion, ex.getMessage());
        }
    }

    public void registro() {
        try {
            Usuario u = new Usuario();

            verificarVacios(this.registro.getNombre());
            u.setNombre(this.registro.getNombre());

            verificarVacios(this.registro.getApellido());
            u.setApellido(this.registro.getApellido());

            verificarVacios(this.registro.getIdentificacion());
            verificarIdentificacion(this.registro.getIdentificacion());
            u.setIdentificacion(Long.parseLong(this.registro.getIdentificacion()));

            String contraseña = u.getNombre().trim().charAt(0) + this.registro.getIdentificacion() + u.getApellido().trim().charAt(0);
            u.setContraseña(contraseña);

            verificarVacios(this.registro.getCorreo());
            u.setCorreo(this.registro.getCorreo());

            verificarVacios(this.registro.getTelefono());
            u.setTelefono(Long.parseLong(this.registro.getTelefono()));

            u.setTipoUsuario(this.registro.getTipoUsuario());

            u.setEstado("Activo");
            if (!u.registrarUsuario()) {
                JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
            }

            this.registro.setNombre("");
            this.registro.setApellido("");
            this.registro.setIdentificacion("");
            this.registro.setTelefono("");
            this.registro.setCorreo("");
        } catch (EmptyException ex) {
            JOptionPane.showMessageDialog(this.registro, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(registro, "No se permite ingresar caracteres en la identificacion");
        } catch (IdentificacionException ex) {
            JOptionPane.showMessageDialog(this.registro, ex.getMessage());
        }
    }

    public void listado() {
        Usuario u = new Usuario();
        u.listarUsuarios(this.listado.getModelo());
    }

    public void consultarUsuarioId(int id) {
        Usuario u = new Usuario();
        //consulta un usuario por el id
        u = u.consultaUsuarioId(id);
        DetallesUsuario du = new DetallesUsuario();
        //pongo la información del usuario en los campos
        du.setId(String.valueOf(u.getId()));
        du.setIdentificacion(String.valueOf(u.getIdentificacion()));
        du.setNombre(u.getNombre());
        du.setApellido(u.getApellido());
        du.setCorreo(u.getCorreo());
        du.setTelefono(String.valueOf(u.getTelefono()));
        du.setContraseña(u.getContraseña());
        du.setTipoUsuario(u.getTipoUsuario());

        du.setLocationRelativeTo(listado);
        du.setVisible(true);
    }

    public void actualizarUsuario() {
        try {
            Usuario u = new Usuario();
            u.setId(Integer.parseInt(this.detallesUsuario.getId()));

            verificarVacios(this.detallesUsuario.getIdentificacion());
            verificarIdentificacion(this.detallesUsuario.getIdentificacion(), this.detallesUsuario.getId());
            u.setIdentificacion(Long.parseLong(this.detallesUsuario.getIdentificacion()));
            
            verificarVacios(this.detallesUsuario.getNombre());
            u.setNombre(this.detallesUsuario.getNombre());
            
            verificarVacios(this.detallesUsuario.getApellido());
            u.setApellido(this.detallesUsuario.getApellido());
            
            verificarVacios(this.detallesUsuario.getCorreo());
            u.setCorreo(this.detallesUsuario.getCorreo());
            
            verificarVacios(this.detallesUsuario.getTelefono());
            u.setTelefono(Long.parseLong(this.detallesUsuario.getTelefono()));
            
            verificarVacios(this.detallesUsuario.getContraseña());
            u.setContraseña(this.detallesUsuario.getContraseña());
            
            u.setTipoUsuario(this.detallesUsuario.getTipoUsuario());
            u.setEstado(this.detallesUsuario.getEstado());

            u.actualizarUsuario();
        } catch (EmptyException ex) {
            JOptionPane.showMessageDialog(this.registro, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(registro, "No se permite ingresar caracteres en la identificacion");
        } catch (IdentificacionException ex) {
            JOptionPane.showMessageDialog(this.registro, ex.getMessage());
        }
    }

    public void verificarVacios(String cadena) throws EmptyException {
        if (cadena.trim().equals("")) {
            throw new EmptyException();
        }
    }

    public void verificarIdentificacion(String cadena) throws IdentificacionException {
        Usuario u = new Usuario();
        if (u.verificarIdentificacion(cadena)) {
            throw new IdentificacionException();
        }
    }
    
    public void verificarIdentificacion(String cadena, String id) throws IdentificacionException {
        Usuario u = new Usuario();
        if (u.verificarIdentificacion(cadena,id)) {
            throw new IdentificacionException();
        }
    }

    public Registro_usuario getRegistro() {
        return registro;
    }

    public void setRegistro(Registro_usuario registro) {
        this.registro = registro;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Listado_usuario getListado() {
        return listado;
    }

    public void setListado(Listado_usuario listado) {
        this.listado = listado;
    }

    public DetallesUsuario getDetallesUsuario() {
        return detallesUsuario;
    }

    public void setDetallesUsuario(DetallesUsuario detallesUsuario) {
        this.detallesUsuario = detallesUsuario;
    }
}
