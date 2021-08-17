/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancepr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drago
 */
public class AvancePr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        int num;
        int opc;
        int x=1;
        Scanner entrada=new Scanner(System.in);

        System.out.println("Numero de alumnos a crear");
        num=entrada.nextInt();
        GeneradorDeDatos generadorDeDatos = new GeneradorDeDatos();
        GeneradorDeRegistrosAcademicos historial=new GeneradorDeRegistrosAcademicos();
        Persona[] datosConSoloNombres = generadorDeDatos.generarNombresAlAzar(num);
        Alumno[] alumnos_de_la_facultad= new Alumno[num];  
        Persona[] datosPersonales = generadorDeDatos.generarDatosPersonalesAlAzar(num);
        for (int i = 0; i < num; i++) {
 
            alumnos_de_la_facultad[i]=new Alumno(historial.getHistorialAzar(),datosPersonales[i],historial.numeroDeIncripción());
           
        }
        while(x==1){
            System.out.println("1.Modificar alumno\n 2.Imprimir alumnos creados\n 3.Guardar en archivo CVS\n 4.Salir\n");
            opc=entrada.nextInt();
            if(opc==1){
                System.out.println("Modificando");
            }
            if(opc==2){
                for(int i=0;i<num;i++){
                    System.out.println(alumnos_de_la_facultad[i]);
                }
            }
            if(opc==3){
                try {
                    File datos=new File("datos.csv");
                    FileWriter myWriter = new FileWriter("datos.csv");
                    myWriter.write("Nombre,Apellido,Edad,Direccion,Historial Academico,\n");

                    for(int i=0;i<num;i++){
                        List g=new ArrayList();
                        List f;
                        List<List> his;
                        f = alumnos_de_la_facultad[i].datosEnLista();
                        his=alumnos_de_la_facultad[i].getHistorialAcademico();
                        datos.createNewFile();
                        
                        System.out.println(f);
                        System.out.println(f.size());
                        for(int j=0;j<f.size();j++) {
                            System.out.println(f.get(j));
                            myWriter.write(f.get(j)+",");
                            

                        }
                        
                        System.out.println(his);
                        for(int j=0;j<his.size();j++) {
                            
                            for(int k=0;k<3;k++) {
                                g.add(his.get(j).get(k));
                            }
                        myWriter.write(" Materia: "+g.get(0)+" Calificacion: "+g.get(1)+" Creditos: "+g.get(2)+",");
    
                        }
                        myWriter.write(alumnos_de_la_facultad[i].getNumeroDeInscripcion()+","); 
                        
                        
                        myWriter.write("\n");
                    }
                    myWriter.close();
                    }catch (IOException ex) {
                        Logger.getLogger(AvancePr.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
                
            }
                
                    
            if(opc==4){
                x=0;
            }      
                    
        
        }
        
        
        
        
    }
    
}
    

