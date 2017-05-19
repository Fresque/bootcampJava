package com.company;

import com.company.Model.Dia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by marti on 5/19/2017.
 */
public class DBDao implements Dao{
    private static DBDao instance;
    private static Connection connection;

    public static DBDao getInstance(){
        if(instance == null) {
            instance = new DBDao();
        }
        return instance;
    }
    public void conectar(String user, String pass, String db_name){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarRegistro(String name, String table_name, String titulo, String fecha, int temperatura, String descripcion,
                                 int humedad, int viento){
        try {

            //Este no logro hacer andar
            String Query = "INSERT INTO " + name +"." + table_name + " (`titulo`, `fecha`, `temperatura`, `descripcion`, `humedad`, `viento`) VALUES("
                    + "\"" + titulo + "\", "
                    + "\"" + fecha + "\", "
                    + "\"" + temperatura + "\", "
                    + "\"" + descripcion + "\", "
                    + "\"" + humedad + "\", "
                    + "\"" + viento + "\")";

            Statement st = connection.createStatement();
            st.executeUpdate(Query);
            System.out.println("Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            System.out.println("Error en el almacenamiento de datos");
        }
    }

    public ArrayList solicitarRegistro(String table_name){
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = connection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            ArrayList resultados = new ArrayList();

            while (resultSet.next()) {

                Dia d = new Dia();

                d.setTitle(resultSet.getString("titulo"));
                d.setPubDate(resultSet.getString("fecha"));
                d.setTemp(resultSet.getInt("temperatura"));
                d.setText(resultSet.getString("descripcion"));
                d.setHumudity(resultSet.getInt("humedad"));
                d.setSpeed(resultSet.getInt("viento"));

                resultados.add(d);

            }

            return resultados;

        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos");
        }
        return null;
    }

    public void desconectar(){
        try {
            connection.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
