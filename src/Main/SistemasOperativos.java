/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 */

package Main;
import Buddy.*;
import PrimerAjuste.*;
import MejorAjuste.*;
import Menu.MenuE;
import SiguienteAjuste.*;

/**
 * @version 1.0
 * @author Rojas Rodríguez Martín Omar, 178809@upslp.edu.mx
 */
public class SistemasOperativos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Siguiente Ajuste
        //ListaSentinelaSiguiente L = new ListaSentinelaSiguiente();
        //new InterfazSiguiente(L).setVisible(true);
        


        //Mejor Ajuste
        //ListaSentinelaMejor L = new ListaSentinelaMejor();
        //new InterfazMejor(L).setVisible(true);
        
        /*L.fragmentarMemoria();
        System.out.println(L);
        System.out.println(" ");
        boolean si = L.asignarProceso("A", 50);
        si = L.asignarProceso("B", 10);
        System.out.println(L);
        si = L.liberarProceso("A");
        System.out.println(L);*/
        
        
        
        //Primer Ajuste
        //ListaSentinelaPrimer L = new ListaSentinelaPrimer();
        //new InterfazPrimer(L).setVisible(true);
        
        

       //Buddy
       //Tree T = new Tree();
       //new Interfaz(T).setVisible(true);
        
        new MenuE().setVisible(true);
        
    }

}
