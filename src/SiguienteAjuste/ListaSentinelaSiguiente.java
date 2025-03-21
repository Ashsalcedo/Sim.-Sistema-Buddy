/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 */
package SiguienteAjuste;
import PrimerAjuste.*;
import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Rojas Rodríguez Martín Omar, 178809@upslp.edu.mx
 */
public class ListaSentinelaSiguiente{
    public Nodo head;
    public Nodo nil;
    public int inicio =0;
    public int memoria =1024;
    public Nodo ultimo;
    public int contador=0;
    public int asignados =0;
    
    public ListaSentinelaSiguiente()
    {
        nil = new Nodo(0, 0);
        nil.prev = nil;
        nil.next = nil;
        
    }
    
    public void ListDeleteSent(Nodo x)
    {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }
    
    /*public Nodo ListSearchSent(int key)
    {
        Nodo x = nil.next;
        while(x!= nil && !x.key.equals(key))
        {
            x = x.next;
        }
        return x;
    }*/
    
    public Nodo asignarProceso(int espacio ,String proceso)
    {
        
        Color colorOcupados = new Color(245, 108, 103);
        //Color colorLibre = new Color(8, 191, 165);
        Color colorsiguiente = new Color(227, 82, 144);
        Nodo x = ultimo;
        System.out.println("ultimo = " + x.tamanio);
        while(x!=nil)
        {
            //System.out.println(x.tamanio);
            if(x.ocupado == false && x.tamanio >= espacio )
            {
                
                if(espacio!=x.tamanio)
                {
                    Nodo a = new Nodo(espacio, x.inicio);
                    Nodo b = new Nodo(x.tamanio-espacio, x.inicio+espacio);
                    /*a.prev = x.prev;
                    a.next = b;
                    b.prev = a; 
                    b.next = x.next;
                    x.prev.next = a;
                    x.next.prev = b;*/
                    a.next = x.next;
                    a.prev = b;
                    b.next = a;
                    b.prev = x.prev;
                    x.prev.next = b;
                    x.next.prev = a;
                    a.proceso = proceso;
                    a.ocupado = true;
                    ultimo.representacion.setBackground(colorOcupados);
                    ultimo = a;
                    
                }
                else
                {
                    x.ocupado = true;
                    x.proceso = proceso;
                    ultimo.representacion.setBackground(colorOcupados);
                    ultimo = x;
                }
                return x;
                
            }
            x = x.prev;
        }
        return null;
    }
    
    /*public boolean liberarProceso(String proceso)
    {
        Nodo x = nil.next;
        while(x!=nil)
        {
            if(x.proceso.equals(proceso))
            {
               x.ocupado = false;
               x.proceso = " ";
               if(x.next != nil && x.next.ocupado == false)
               {
                   x.tamanio += x.next.tamanio;
                   ListDeleteSent(x.next);
               }
               if(x.prev != nil && x.prev.ocupado ==false)
               {
                   x.prev.tamanio += x.tamanio;
                   ListDeleteSent(x);
               }
               return true;
            }
            x=x.next;
        }
        return false;
    }*/
    
    public Nodo liberarProceso(String proceso, JPanel b)
    {
        Color colorLibre = new Color(8, 191, 165);
        Color colorsiguiente = new Color(227, 82, 144);
        Nodo x = nil.next;
        while(x!=nil)
        {
            if(x.proceso.equals(proceso))
            {
               x.ocupado = false;
               x.proceso = " ";
               if(x.next != nil && x.next.ocupado == false)
               {
                   x.next.tamanio += x.tamanio;
                   b.remove(x.next.representacion);
                   b.remove(x.representacion);
                   b.remove(x.next.etiqueta);
                   b.remove(x.etiqueta);
                   x.next.representacion = null;
                   if(x == ultimo)
                    {
                            ultimo = x.next.next;
                            x.next.next.representacion.setBackground(colorsiguiente);
                    }
                   ListDeleteSent(x);
                   
                   if(x.prev != nil && x.prev.ocupado ==false)
                   {
                       //System.out.println(x.tamanio); 
                       x.next.tamanio+= x.prev.tamanio;
                       //System.out.println(x.tamanio);
                        b.remove(x.prev.representacion);
                        //b.remove(x.representacion);
                        b.remove(x.prev.etiqueta);
                        //b.remove(x.etiqueta);
                        x.representacion = null;
                        if(x == ultimo)
                        {
                            ultimo = x.next;
                            x.next.representacion.setBackground(colorsiguiente);
                        }
                        ListDeleteSent(x.prev);
                   }
                   
                   
                   return x;
               }
               else
               {
                   if(x.prev != nil && x.prev.ocupado ==false)
                    {
                        System.out.println("si");
                        
                        x.tamanio+= x.prev.tamanio;
                        b.remove(x.prev.representacion);
                        b.remove(x.representacion);
                        b.remove(x.prev.etiqueta);
                        b.remove(x.etiqueta);
                        x.representacion = null;
                        if(x == ultimo)
                        {
                            
                            ultimo = x.next;
                            x.next.representacion.setBackground(colorsiguiente);
                        }
                        ListDeleteSent(x.prev);
                        if(x.next != nil && x.next.ocupado == false)
                        {
                            x.next.tamanio += x.tamanio;
                            b.remove(x.next.representacion);
                            //b.remove(x.representacion);
                            b.remove(x.next.etiqueta);
                            //b.remove(x.etiqueta);
                            x.next.representacion = null;
                            if(x==ultimo)
                            {
                                x.next.next.representacion.setBackground(colorsiguiente);
                            }
                            ListDeleteSent(x);
                        }
                        
                        
                        return x;
                    }
                   else
                   {
                       x.representacion.setBackground(colorLibre);
                       x.etiqueta.setText(String.valueOf(x.tamanio));
                       if(x==ultimo)
                       {
                           x.next.representacion.setBackground(colorsiguiente);
                           ultimo = x.next;
                       }
                       
                       return x;
                   }
               }
               
               //return true;
            }
            x=x.next;
        }
        return null;
    }
    
    public Nodo crearBloques()
    {
        
        int espacio;
        if(memoria > 150)
            espacio = (int) (Math.random() * 136) + 15;
        else
            espacio = memoria;
        Nodo x = new Nodo(espacio, inicio);
        memoria -= espacio;
        inicio += espacio;
        return x;
    }
    
    public void fragmentarMemoria()
    {
        
        Nodo z;
        while(memoria>0)
        {
            ListInsertSent(crearBloques());
            
        }
        Nodo x = nil.next;
        boolean bandera = true;
        while(x!=nil)
        {
            if(bandera)
            {
                x.ocupado = true;
                bandera = false;
            }
            else
            {
                bandera = true;
            }
            x = x.next;
        }
        x = nil.prev;
        Random random = new Random();
        int numeroAleatorio = random.nextInt(6);
        for (int i = 0; i < numeroAleatorio; i++) {
            x = nil.prev;
        }
        if(x.ocupado == true && x != nil)
        {
            ultimo = x;
        }
        else
        {
            ultimo = x.prev;
        }
        
        
    }
    
    public void ListInsertSent(Nodo x)
    {
        x.next = nil.next;
        nil.next.prev = x;
        nil.next = x;
        x.prev = nil;
    }
    
    public int memoriaDisponible()
    {
        Nodo x = nil.next;
        int memoria=0;
        while(x!= nil)
        {
            if(x.ocupado==false)
            {
                memoria += x.tamanio;
            }
            x = x.next;
        }
        return memoria;
    }
    
    
    public String toString()
    {
        Nodo x = nil.prev;
        String str = "";
        while(x!= nil)
        {
            if(x.ocupado==false)
                str += x.tamanio + ",";
            else
                str+= "[" + x.tamanio+"],";
            x = x.prev;
        }
        return str;
    }
    
}
