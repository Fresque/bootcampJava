package com.company.View;

import com.company.Model.Dia;
import com.company.MySQL;


public class Main {



    public static void main(String[] args) throws Exception {

        Dia e = new Dia("Pronostico Cordoba", "04/05/2017", 18, "despejado", 60, 3);
        Dia f = new Dia("Pronostico Rio Cuarto", "05/05/2017", 23, "parcalmente nublado", 77, 8);
        Dia g = new Dia("Pronostico Villa Maria", "03/05/2017", 16, "fresco", 58, 12);

        MySQL db = new MySQL();

        db.MySQLConnection("root", "", "");
        db.createDB("historial");
        db.createTable("registro");

        db.insertData("registro", e.getTitle(), e.getPubDate(), e.getTemp(), e.getText(), e.getHumudity(), e.getSpeed());
        db.insertData("registro", f.getTitle(), f.getPubDate(), f.getTemp(), f.getText(), f.getHumudity(), f.getSpeed());
        db.insertData("registro", g.getTitle(), g.getPubDate(), g.getTemp(), g.getText(), g.getHumudity(), g.getSpeed());

        Operaciones.cargarPronosticoEnDb();





    }
}

