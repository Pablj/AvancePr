/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancepr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author drago
 */
public class GeneradorDeRegistrosAcademicos {
    private String[][] historial;
    
    private int numeroDeInscripción;
    private float escolaridad;
    private float velocidad;
    private float promedio;
    
    
    GeneradorDeRegistrosAcademicos() {
       
        String[][] historial= {new String[]{"cálculo y geometría analítica/12","Fundamentos de Programación/10","Química/10","Redacción y exposición de temas de ingeniería/6","Álgebra/8"},
                            new String[]{"Cálculo integral/8","Cultura y comunicación/2","Estructura de datos y algoritmos I/10","Mecánica/12","Algebra linea/8"},
                            new String[]{"Termodinamica/10","Calculo vectorial/8","Ecuaciones diferenciales/8","Optativa de competencias profesionales/6","Modelos de programación orientada a objetos/6","Optativas de ciencias sociales y humanidades/6"},
                            new String[]{"Probabilidad/8","Electricidad y magnetismo/10","Analisis numerico/8","Analisis de sistemas y señales/10","Costos y evaluacion de proyectos/6"},
                            new String[]{"Estadistica para ingenieria electrica electronica/4","Acustica y optica/10","Dinamica de sistemas fisicos/8","Analisis de circuitos electricos/10","Fisica de semiconductores/8","Energia e impacto ambiental/8"},
                            new String[]{"Introduccion a la economia/8","Teoria electromagnetica/10","Fundamentos de control/10","Dispositivos y circuitos electronicos/10","Maquinas electricas I/10"},
                            new String[]{"Medicion e instrumentacion/8","Diseño digital/10","Sistemas de comunicaciones electronicas/10","Amplificadores electronicos/10","Sistemas electricos de potencia I/10"},
                            new String[]{"Automatizacion/10","Microprocesadores y microcontroladores/10","Procesamiento digital deseñales/8","Instalaciones Electricas/8","Cuircuitos integrados analogicos/10"},
                            new String[]{"Asignaturas del campo de profundizacion/8","Asignatura del campo de profundizacion/8","Asignatura del campo de profundizacion/8","Subestaciones electricas/8","Electronica de potencia/8","Etica profesional/6"},
                            new String[]{"Asignaturas del campo de profundizacion/6","Asignatura del campo de profundizacion/6","Asignatura del campo de profundizacion/6","Plantas generadoras/8","Recursos y necesidades de Mexico/8"},                    
        };
        this.historial=historial;
        
    
    
    
    }
    public int numeroDeIncripción(){
        
        numeroDeInscripción=(int) (promedio*escolaridad*100*velocidad*100);
        return numeroDeInscripción;
    }
    
    public List<List> getHistorialAzar() {
        List<List> historialAzar = new ArrayList<>();
        List f=new ArrayList<>();
        int semestreIdoneo=(int) (Math.random()*10);
        float creditosIdoneos=0;
        float creditosReales=0;
        float acreditadas=0;
        float inscritas=0;
        float suma=0;
        int materiasAcreditadas;
       
        String[] aux;
        //System.out.println("Semestre correcto"+semestreIdoneo);
        semestreIdoneo=(int) (Math.random()*10);
        for(int i=0;i<semestreIdoneo;i++){
            
            for(String materias:historial[i] ){
                aux=materias.split("/");
                creditosIdoneos=Integer.parseInt(aux[1])+creditosIdoneos;
                materiasAcreditadas=(int) (Math.random() * 10);
              
                if (materiasAcreditadas > 5 ){
                    acreditadas=acreditadas+1;
                    f.add(aux[0]);
                    f.add(materiasAcreditadas);
                    f.add(aux[1]);
                    historialAzar.add(f);
                    f=new ArrayList<>();
                    creditosReales=Integer.parseInt(aux[1])+creditosReales;
                    suma=materiasAcreditadas+suma;
                    inscritas=inscritas+1;

                  
                }else if(materiasAcreditadas ==5 ){
                    f.add(aux[0]);
                    f.add(materiasAcreditadas);
                    f.add(aux[1]);
                    historialAzar.add(f);
                    f=new ArrayList<>();
                    suma=materiasAcreditadas+suma;
                    inscritas=inscritas+1;

                }
            
            }
        }
        if(historialAzar.isEmpty()){
            for(int i=0;i<1;i++){
            
                for(String materias:historial[i] ){
                    aux=materias.split("/");
                    creditosIdoneos=Integer.parseInt(aux[1])+creditosIdoneos;
                    materiasAcreditadas=(int) (Math.random()*10);
                    System.out.println("Calficacion al azar"+materiasAcreditadas);
                    if (materiasAcreditadas > 5 ){
                        acreditadas=acreditadas+1;
                        f.add(aux[0]);
                        f.add(materiasAcreditadas);
                        f.add(aux[1]);
                        historialAzar.add(f);
                        f=new ArrayList<>();
                        creditosReales=Integer.parseInt(aux[1])+creditosReales;
                        suma=materiasAcreditadas+suma;
                        inscritas=inscritas+1;


                    }else if(materiasAcreditadas <=5 ){
                        f.add(aux[0]);
                        f.add(materiasAcreditadas);
                        f.add(aux[1]);
                        historialAzar.add(f);
                        f=new ArrayList<>();
                        suma=materiasAcreditadas+suma;
                        inscritas=inscritas+1;

                    }
                }
            }
        }
       /* System.out.println(historialAzar);
        System.out.println("CR:"+creditosReales+"CI"+creditosIdoneos+"Ac"+acreditadas+"Ins"+inscritas);
        System.out.println("Vel:"+creditosReales/creditosIdoneos+"esc:"+acreditadas/inscritas+"prom:"+suma/inscritas);*/
        
        this.velocidad=creditosReales/creditosIdoneos;
        this.escolaridad=acreditadas/inscritas;
        this.promedio=suma/inscritas;
       // System.out.println(this.velocidad+"E:"+escolaridad+"¨P"+promedio);
        
        return historialAzar;
    }
    
}
 