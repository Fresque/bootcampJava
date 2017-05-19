package com.company.View;

import com.company.DBDao;
import com.company.Dao;
import com.company.Model.Dia;
import com.company.MySQL;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by marti on 5/4/2017.
 */
public class Operaciones {

    static Dao db = DBDao.getInstance();

    public static void cargarPronosticoEnDb(){

        Scanner sc = new Scanner(System.in);

        System.out.println("\n1.Carga manual de informacion meteorologica");

        Dia d = new Dia();

        System.out.println("Titulo");
        d.setTitle(sc.nextLine());

        System.out.println("Fecha");
        d.setPubDate(sc.next());

        System.out.println("Temperatura");
        d.setTemp(sc.nextInt());

        System.out.println("Descripcion");
        d.setText(sc.next());

        System.out.println("Humedad");
        d.setHumudity(sc.nextInt());

        System.out.println("viento");
        d.setSpeed(sc.nextInt());

        db.insertarRegistro("historial", "registro", d.getTitle(), d.getPubDate(), d.getTemp(), d.getText(), d.getHumudity(), d.getSpeed());

        System.out.println(d.getTitle());
        System.out.println(d.getPubDate());
        System.out.println(d.getTemp());
        System.out.println(d.getText());
        System.out.println(d.getHumudity());
        System.out.println(d.getSpeed());
    }

    public static void solicitarTabla(){

        ArrayList datosClima = db.solicitarRegistro("registro");

        for(int i = 0; i<datosClima.size(); i++){
            Dia d = (Dia) datosClima.get(i);
            System.out.println(d.getTitle());
            System.out.println(d.getText());
        }
    }
}
