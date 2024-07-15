package com.ar.webapp;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnection {

    private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/cacmovies";
    private static final String USER = "Santiago";
    private static final String PASS = "asd123";

    static {
        try {
            Class.forName(CONTROLADOR);
            System.out.println("El driver se cargo correctamente");
        } catch (Exception e) {
            System.out.println("Error al cargar el driver jdbc");
            e.printStackTrace();
        }
    }

    public Connection conectar() {

        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexion con la base de datos");
            e.printStackTrace();
        }
        return conexion;
    }
}
