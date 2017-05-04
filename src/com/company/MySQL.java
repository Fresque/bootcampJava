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
 * Created by marti on 5/4/2017.
 */
public class MySQL {
    private static Connection connection;


    public void MySQLConnection(String user, String pass, String db_name) throws Exception {
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

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createDB(String name) throws Exception {
        try {
            String Query = "CREATE DATABASE " + name;
            Statement st = connection.createStatement();
            st.executeUpdate(Query);
            closeConnection();
            MySQLConnection("root", "", name);
            System.out.println("Se ha creado la base de datos " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createTable(String name) {
        try {
            String Query = "CREATE TABLE " + name + ""
                    + "(id INT AUTO_INCREMENT,titulo VARCHAR(25), fecha VARCHAR(25),"
                    + " temperatura INT, descripcion VARCHAR(25), humedad INT, viento INT)";

            Statement st = connection.createStatement();
            st.executeUpdate(Query);
            System.out.println("Se ha creado la tabla " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertData(String table_name, String titulo, String fecha, int temperatura, String descripcion,
                           int humedad, int viento) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
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

    public ArrayList getValues(String table_name) {
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = connection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            ArrayList resultados = new ArrayList();

            while (resultSet.next()) {

                Dia d = new Dia();

                d.setTitle(resultSet.getString("title"));
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

}
