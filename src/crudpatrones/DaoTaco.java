package crudpatrones;

import java.sql.ResultSet;

/**
 *
 * @author exkapp
 */
/*Uso de palabra reservada "implementes" seguido de la interface creada anteriormente; en el medio del símbolo diamante se incluirá
* el objeto que necesitemos. Notar que en los métodos se se genera el parámetro que necesitamos automáticamente
 */
public class DaoTaco implements IDAO<Taco> {

    //Variable para manipular la conexión a nuestra base de datos y sus métodos
    private Conection con = Conection.getInstance();

    /*Cadena de caracteres que almacenará las sentencias sql que necesitemos
    **Notar que las sentencias son prácticamente como si fueran consultas desde un terminal con la diferencia que aquí
    **debemos cuidar la concatenación de los atributos teniendo entre comillas simples ('atributo') a las cadenas de caracteres (String)
    **en este caso y dejando sin comillas los atributos de tipo numérico (int en este caso)
     */
    private String sql = "";

    @Override
    public boolean insert(Taco t) {
        sql = "INSERT INTO tacos (id, tipo, precio) VALUES (" + t.getId() + ",'" + t.getTipo() + "'," + t.getPrecio() + ");";
        return con.execute(sql);
    }

    @Override
    public boolean delete(Taco t) {
        sql = "DELETE FROM tacos WHERE(id=" + t.getId() + ");";
        return con.execute(sql);
    }

    @Override
    public boolean update(Taco t) {
        sql = "UPDATE tacos SET tipo = '" + t.getTipo() + "',precio =" + t.getPrecio() + "WHERE (id=" + t.getId() + ");";
        return con.execute(sql);
    }

    @Override
    public ResultSet readOne(Taco t) {
        sql = "SELECT * FROM tacos WHERE(id = " + t.getId() + ");";
        return con.executeQuery(sql);
    }

    @Override
    public ResultSet readAll() {
        sql = "SELECT * FROM tacos;";
        return con.executeQuery(sql);
    }

}
