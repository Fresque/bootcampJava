package com.company;

import java.util.ArrayList;

/**
 * Created by marti on 5/19/2017.
 */
public interface Dao {
    void conectar(String user, String pass, String db_name);
    void insertarRegistro(String name, String table_name, String titulo, String fecha, int temperatura, String descripcion,
                          int humedad, int viento);
    ArrayList solicitarRegistro(String table_name);
    void desconectar();


}
