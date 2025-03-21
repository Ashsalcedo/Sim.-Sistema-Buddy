/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 */
package Buddy;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rojas Rodríguez Martín Omar, 178809@upslp.edu.mx
 */
public class TreeNode {
    public TreeNode father; //El nodo superior (tamaño *2)
    public TreeNode left; // Los nodos inferiores (tamaño/2)
    public TreeNode right; // Los nodos inferiores (tamaño/2)
    public int tamanio; //El tamaño, siempre debe ser una potencia de 2;
    public boolean visto; //Si este fragmento es visible
    public boolean ocupado; //Si está ocupado:
    public int disponible;//Lo que tiene disponible 
    public boolean accesible; //No puede ser ocupado ya que alguno de sus hijos ya fue ocupado;
    public String proceso; // proceso asignado a ese bloque
    public JPanel representacion; //JPanel para la interfaz que le corresponde.
    public int coordenada; //la coordenada donde iniciará
    public int tamOcupado;
    public JLabel etiqueta;

    public TreeNode(int tamanio) {
        this.tamanio = tamanio;
        this.visto = false; //Todos inicial sin ser vistos.
        this.ocupado = false; //Todos inician libres
        this.disponible = tamanio; //Todos tienen un espacio disponible igual a su tamaño.
        this.left = null;
        this.right = null;
        this.accesible = true;
        this.proceso = " ";
        this.coordenada =0;
        this.representacion = null;
        this.tamOcupado =0;
        this.etiqueta = null;
        
    }
    
    
}
