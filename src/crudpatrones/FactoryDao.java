package crudpatrones;

/**
 *
 * @author exkapp
 */
public class FactoryDao {
    /*
    *Define una lista de opciones finita que usaremos para decidir qué tipo de DAO queremos
    */
    public enum Type {
        TAQUERO, TACO
    }
    
    /*
    *Método que se encargará de analizar el tipo de DAO que le solicitamos a través de un switch y lo retorna.
    */
    public static IDAO getDao(Type type) {
        IDAO dao = null;
        switch (type) {
            case TAQUERO:
                dao = new DaoTaquero();
                break;
            case TACO:
                dao = new DaoTaco();
                break;
            default:
                System.out.println("ERROR!");
        }
        return dao;
    }
}
