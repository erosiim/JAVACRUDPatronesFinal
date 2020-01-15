package crudpatrones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conection {

//Variable de instancia única
    private static Conection c;
//Variable para hacer la conexión
    private Connection cx = null;

    private Conection() {
        try {
            Class.forName("org.postgresql.Driver");
            cx = DriverManager.getConnection("jdbc:postgresql://localhost:5432/taqueria", "postgres", "12334");
            System.out.println("-Conectado-");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Conection getInstance() {
        if (c == null) {
            c = new Conection();
        }
        return c;
    }

    //Statement(Sentencias SQL):  Insert, Delete, Update => De actualización
    public boolean execute(String sql) {
        boolean res = false;
        try {
            Statement st = cx.createStatement();
            st.execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    //Statement(Sentencia SQL): Select => De consulta
    //ResultSet: almacena de forma temporal el resultado de la consulta Select y permite recorrer la información obtenida.
    public ResultSet executeQuery(String sql) {
        ResultSet res = null;
        try {
            Statement st = cx.createStatement();
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
