/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author Acer
 */
public class IdentificacionException extends Exception{
    
    public IdentificacionException(){
        super("Error, ya se encuentra un usuario registrado con esta identificación");
    }
    
}
