/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 */
package SiguienteAjuste;

import PrimerAjuste.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rojas Rodríguez Martín Omar, 178809@upslp.edu.mx
 */
public class Nodo{
    public Nodo  prev; 
    public int tamanio;
    public int inicio;
    public int fin;
    public Nodo next;
    public boolean ocupado;
    public String proceso;
    public JPanel representacion;
    public JLabel etiqueta;

    public Nodo(int tamanio, int inicio) {
        this.tamanio = tamanio;
        this.inicio = inicio;
        this.ocupado = false;
        this.proceso = " ";
        this.representacion = null;
        
    }

    
    
    
    
}
