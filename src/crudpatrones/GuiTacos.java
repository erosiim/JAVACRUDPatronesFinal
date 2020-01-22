package crudpatrones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author exkapp
 */
public class GuiTacos extends GuiGeneral{

    private IDAO myDao = FactoryDao.getDao(FactoryDao.Type.TACO);
    private Taco taco = new Taco();
    
    public GuiTacos() {
        this.setTitle("CRUD TACOS");
        modelo.setColumnIdentifiers(new Object[]{"ID","TIPO","PRECIO"});
        jTable1.setModel(modelo);
        jLabel1.setText("ID");
        jLabel2.setText("TIPO");
        jLabel3.setText("PRECIO");        
    }
    

    @Override
    protected void insert() {
        taco.setId(Integer.parseInt(jTextField1.getText()));
        taco.setTipo(jTextField2.getText());
        taco.setPrecio(Integer.parseInt(jTextField3.getText()));
        if(myDao.insert(taco))
            JOptionPane.showMessageDialog(null, "Insertado con éxito");
        else
            JOptionPane.showMessageDialog(null, "¡ERROR!");
    }

    @Override
    protected void delete() {
        taco.setId(Integer.parseInt(jTextField1.getText()));
         if(myDao.delete(taco))
            JOptionPane.showMessageDialog(null, "Eliminado con éxito");
        else
            JOptionPane.showMessageDialog(null, "¡ERROR!");
    }

    @Override
    protected void update() {
        taco.setId(Integer.parseInt(jTextField1.getText()));
        taco.setTipo(jTextField2.getText());
        taco.setPrecio(Integer.parseInt(jTextField3.getText()));
        if(myDao.update(taco))
            JOptionPane.showMessageDialog(null, "Actualizado con éxito");
        else
            JOptionPane.showMessageDialog(null, "¡ERROR!");
        
    }

    @Override
    protected void readOne() {
        taco.setId(Integer.parseInt(jTextField1.getText()));
        ResultSet data = myDao.readOne(taco);
        try {
            while(data.next()){
                modelo.addRow(new Object[]{data.getInt(1), data.getString(2), data.getInt(3)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuiTacos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void readAll() {
        ResultSet data = myDao.readAll();
        try {
            while(data.next()){
                modelo.addRow(new Object[]{data.getInt(1), data.getString(2), data.getInt(3)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuiTacos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
