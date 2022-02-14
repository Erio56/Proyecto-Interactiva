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
public class EmptyException extends Exception{
    
    public EmptyException(){
        super("Error, usted debe completar todos los campos solicitados");
    }
    
}
