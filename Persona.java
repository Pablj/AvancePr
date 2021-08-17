/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancepr;

/**
 *
 * @author drago
 */
public class Persona {
    String nombre;
    String apellido;
    int edad;
    String direccion;

    Persona(String nombre, String apellido, int edad, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Apellido: " + this.apellido + " Edad: " + this.edad + " Direccion: "
                + this.direccion;
    }
}

