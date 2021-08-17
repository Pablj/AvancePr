/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancepr;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author drago
 */
public class Alumno {
    
    
    //final String numerodeInscripción;
    Persona datos; 
    List<List> historialAcademico;
    final int numeroDeInscripcion;
    
    Alumno(List<List> historialAcademico, Persona datos,int numeroDeInscripcion) {
      //  this.numerodeInscripción = numerodeIncripción;
        this.datos = datos;
        this.historialAcademico=historialAcademico;
        this.numeroDeInscripcion=numeroDeInscripcion;
    }

    public void setDatos(Persona datos) {
        this.datos = datos;
    }

    public List datosEnLista() {
        List f=new ArrayList<>();
        f.add(datos.nombre);
        f.add(datos.apellido);
        f.add(datos.edad);
        f.add(datos.direccion);
        
        return f;
    }
    
    public List<List> getHistorialAcademico() {
        return historialAcademico;
    }

    public int getNumeroDeInscripcion() {
        return numeroDeInscripcion;
    }
    
    

    @Override
    public String toString() {
        return this.datos +" Historial Academico:"+ this.historialAcademico+" Numero de inscripción:"+this.numeroDeInscripcion;
    }
    
    
    
     
   

   
    
}
