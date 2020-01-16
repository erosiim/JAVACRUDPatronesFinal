package crudpatrones;

import java.sql.ResultSet;

/**
 *
 * @author exkapp
 */
public class DaoTaquero implements IDAO<Taquero> {

    //Variable para manipular la conexión a nuestra base de datos y sus métodos
    private Conection con = Conection.getInstance();
    /*Cadena de caracteres que almacenará las sentencias sql que necesitemos
    **Notar que las sentencias son prácticamente como si fueran consultas desde un terminal con la diferencia que aquí
    **debemos cuidar la concatenación de los atributos teniendo entre comillas simples ('atributo') a las cadenas de caracteres (String)
    **en este caso y dejando sin comillas los atributos de tipo numérico (int en este caso)
     */
    private String sql = "";

    @Override
    public boolean insert(Taquero t) {
        sql = "INSERT INTO taqueros (id, nombre, edad) VALUES (" + t.getId() + ",'" + t.getNombre() + "'," + t.getEdad() + ");";
        return con.execute(sql);
    }

    @Override
    public boolean delete(Taquero t) {
        sql = "DELETE FROM taqueros WHERE(id=" + t.getId() + ");";
        return con.execute(sql);
    }

    @Override
    public boolean update(Taquero t) {
        sql = "UPDATE taqueros SET nombre = '" + t.getNombre() + "',edad =" + t.getEdad() + "WHERE (id=" + t.getId() + ");";
        return con.execute(sql);
    }

    @Override
    public ResultSet readOne(Taquero t) {
        sql = "SELECT * FROM taqueros WHERE(id = " + t.getId() + ");";
        return con.executeQuery(sql);
    }

    @Override
    public ResultSet readAll() {
        sql = "SELECT * FROM taqueros;";
        return con.executeQuery(sql);
    }

}
