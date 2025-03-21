/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 */
package PrimerAjuste;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Rojas Rodríguez Martín Omar, 178809@upslp.edu.mx
 */
public class ListaSentinelaPrimer{
    public Nodo head;
    public Nodo nil;
    public int inicio =0;
    public int memoria =1024;
    public int asignados =0;
    
    public ListaSentinelaPrimer()
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
    
    public Nodo asignarProceso(int espacio, String proceso)
    {
        Nodo x = nil.prev;
        while(x!=nil)
        {
            //System.out.println(x.tamanio);
            if(x.ocupado == false && x.tamanio >= espacio )
            {
                
                if(espacio!=x.tamanio)
                {
                    Nodo a = new Nodo(espacio, x.inicio);
                    Nodo b = new Nodo(x.tamanio-espacio, x.inicio+espacio);
                    a.prev = x.prev;
                    a.next = b;
                    b.prev = a; 
                    b.next = x.next;
                    x.prev.next = a;
                    x.next.prev = b;
                    a.proceso = proceso;
                    a.ocupado = true;
                    
                }
                else
                {
                    x.ocupado = true;
                    x.proceso = proceso;
                }
                return x;
                
            }
            x = x.prev;
        }
        return null;
    }
    
    public Nodo liberarProceso(String proceso, JPanel b)
    {
        Color colorLibre = new Color(8, 191, 165);
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
                   b.remove(x.next.representacion);
                   b.remove(x.representacion);
                   b.remove(x.next.etiqueta);
                   b.remove(x.etiqueta);
                   x.representacion = null;
                   ListDeleteSent(x.next);
                   if(x.prev != nil && x.prev.ocupado ==false)
                   {
                        x.prev.tamanio += x.tamanio;
                        b.remove(x.prev.representacion);
                        //b.remove(x.representacion);
                        b.remove(x.prev.etiqueta);
                        //b.remove(x.etiqueta);
                        x.prev.representacion = null;
                        ListDeleteSent(x);
                   }
                   return x;
               }
               else
               {
                   if(x.prev != nil && x.prev.ocupado ==false)
                    {
                        x.prev.tamanio += x.tamanio;
                        b.remove(x.prev.representacion);
                        b.remove(x.representacion);
                        b.remove(x.prev.etiqueta);
                        b.remove(x.etiqueta);
                        x.prev.representacion = null;
                        ListDeleteSent(x);
                        if(x.next != nil && x.next.ocupado == false)
                        {
                            x.tamanio += x.next.tamanio;
                            b.remove(x.next.representacion);
                            //b.remove(x.representacion);
                            b.remove(x.next.etiqueta);
                            //b.remove(x.etiqueta);
                            x.representacion = null;
                            ListDeleteSent(x.next);
                        }
                        return x;
                    }
                   else
                   {
                       x.representacion.setBackground(colorLibre);
                       x.etiqueta.setText(String.valueOf(x.tamanio));
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
    
    public void ListInsertSent(Nodo x)
    {
        x.next = nil.next;
        nil.next.prev = x;
        nil.next = x;
        x.prev = nil;
    }
    
    public String toString()
    {
        Nodo x = nil.next;
        String str = "";
        while(x!= nil)
        {
            if(x.ocupado==false)
                str += x.tamanio + ",";
            else
                str+= "[" + x.tamanio+"],";
            x = x.next;
        }
        return str;
    }
    
}
























