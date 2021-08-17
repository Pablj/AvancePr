/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancepr;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author drago
 */
public class GeneradorDeDatos {
    
    private final int numeroDeDatosCsv = 100;
    private Persona[] defaultData;

    public Persona[] generarNombresAlAzar(int numeroDeDatosAGenerar) {
        Persona[] datos = new Persona[numeroDeDatosAGenerar];

        for (int i = 0; i < numeroDeDatosAGenerar; i++) {
            int randomIndexForName = (int) (Math.random() * numeroDeDatosCsv);
            int randomIndexForLastName = (int) (Math.random() * numeroDeDatosCsv);

            datos[i] = new Persona(this.defaultData[randomIndexForName].nombre,
                    this.defaultData[randomIndexForLastName].apellido, 0, "");
        }

        return (datos);
    }

    public Persona[] generarDatosPersonalesAlAzar(int numeroDeDatosAGenerar) {
        Persona[] datos = new Persona[numeroDeDatosAGenerar];

        for (int i = 0; i < numeroDeDatosAGenerar; i++) {
            int randomIndexForName = (int) (Math.random() * numeroDeDatosCsv);
            int randomIndexForLastName = (int) (Math.random() * numeroDeDatosCsv);
            int randomIndexForDirection = (int) (Math.random() * numeroDeDatosCsv);
            int edad = (int) (Math.random() * (27 - 18 + 1) + 18);
            datos[i] = new Persona(this.defaultData[randomIndexForName].nombre,
                    this.defaultData[randomIndexForLastName].apellido, edad,
                    this.defaultData[randomIndexForDirection].direccion);
        }

        return (datos);
    }

    private Persona parseArrayDataToPersona(String[] p) {
        return new Persona(p[0], p[1], 0, p[2]);
    }

    GeneradorDeDatos() {
        int i = 0;
        this.defaultData = new Persona[numeroDeDatosCsv];

        try {
            Scanner sc = new Scanner(new File("MOCK_DATA.csv"));
            sc.useDelimiter("\n");

            while (sc.hasNext()) {
                String lectura = sc.next();

                String[] dato = lectura.split(",");
                this.defaultData[i] = parseArrayDataToPersona(dato);

                i++;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

