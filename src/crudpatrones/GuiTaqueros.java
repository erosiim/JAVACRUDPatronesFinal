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
public class GuiTaqueros extends GuiGeneral{
    
    private IDAO myDao = FactoryDao.getDao(FactoryDao.Type.TAQUERO);
    private Taquero taquero = new Taquero();

    public GuiTaqueros() {
        this.setTitle("CRUD TAQUEROS");
        modelo.setColumnIdentifiers(new Object[]{"ID","NOMBRE","EDAD"});
        jTable1.setModel(modelo);
        jLabel1.setText("ID");
        jLabel2.setText("NOMBRE");
        jLabel3.setText("EDAD");
    }
    
    @Override
    protected void insert() {
        taquero.setId(Integer.parseInt(jTextField1.getText()));
        taquero.setNombre(jTextField2.getText());
        taquero.setEdad(Integer.parseInt(jTextField3.getText()));
        if(myDao.insert(taquero))
            JOptionPane.showMessageDialog(null, "Insertado con éxito");
        else
            JOptionPane.showMessageDialog(null, "¡ERROR!");
    }

    @Override
    protected void delete() {
        taquero.setId(Integer.parseInt(jTextField1.getText()));
        if(myDao.delete(taquero))
            JOptionPane.showMessageDialog(null, "Eliminado con éxito");
        else
            JOptionPane.showMessageDialog(null, "¡ERROR!");
    }

    @Override
    protected void update() {
        taquero.setId(Integer.parseInt(jTextField1.getText()));
        taquero.setNombre(jTextField2.getText());
        taquero.setEdad(Integer.parseInt(jTextField3.getText()));
        if(myDao.update(taquero))
            JOptionPane.showMessageDialog(null, "Actualizado con éxito");
        else
            JOptionPane.showMessageDialog(null, "¡ERROR!");
    }

    @Override
    protected void readOne() {
        try {
            taquero.setId(Integer.parseInt(jTextField1.getText()));
            ResultSet data = myDao.readOne(taquero);
            while(data.next()){
                modelo.addRow(new Object[]{data.getInt(1), data.getString(2), data.getInt(3)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuiTaqueros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void readAll() {
        try {
            ResultSet data = myDao.readAll();
            while(data.next()){
                modelo.addRow(new Object[]{data.getInt(1), data.getString(2), data.getInt(3)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuiTaqueros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
