import javax.swing.*;

public class Main
{
    private static boolean terminal;

    public static void main(String [] args ){
        if (JOptionPane.showConfirmDialog(null, "Desea jugar con interfaz?", "Arqueria",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            terminal = false;
        }
        else{
            terminal = true;
        }
        Menu menu =  new Menu();
        Interfaz interfaz = new Interfaz(menu,terminal);
        menu.setInterfaz(interfaz);
        if(interfaz.getTerminal()){
            interfaz.menuTerminal();
        }
    }
    
}
