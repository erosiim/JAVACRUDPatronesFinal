package crudpatrones;

/**
 *
 * @author exkapp
 */
public class FactoryGui {

    public enum GUITYPE{GUITACO , GUITAQUERO};
    
    public static GuiGeneral getGUI(GUITYPE type){
        GuiGeneral myGui = null;
        switch(type){
            case GUITACO:
                myGui = new GuiTacos();
                break;
            case GUITAQUERO:
                myGui = new GuiTaqueros();
                break;
            default:
                System.out.println("¡ERROR!");
        }
        return myGui;
    }
    
}
