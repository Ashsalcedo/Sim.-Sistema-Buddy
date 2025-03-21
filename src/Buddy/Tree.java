/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 */
package Buddy;

/**
 *
 * @author Rojas Rodríguez Martín Omar, 178809@upslp.edu.mx
 */
public class Tree {
    
    public TreeNode root = new TreeNode(1024); //El máximo tamaño
    public int asignados =0;
    int memoria =0;
    
    public TreeNode asignarMemoria(Tree T, int espacio, String proceso)
    {
        System.out.println("Tamanio : "+ espacio);
        TreeNode x = T.root;
        TreeNode y;
        TreeNode z;
        double logaritmoBase2= Math.ceil(Math.log(espacio) / Math.log(2)); 
        int espacio2 = (int) Math.pow(2, logaritmoBase2);
        boolean bandera = false;
        while(!bandera)
        {
            if(espacio2 >T.root.disponible)
            {
                System.out.println("No hay espacio");
                return null;
            }
            if(espacio2 <=0)
            {
                System.out.println("No se puede asignar");
                return null;
            }
            if(x.left == null || x.right == null)
            {
                
                y = crearArbol(x);
                if(y==null)
                {
                    x= null;
                    return x;
                }
            }
            else
            {   
                //System.out.println("Espacio : " + espacio2 +"<= "+ x.left.disponible + " Estado " + x.left.ocupado);
                if(espacio2 <= x.disponible && x.left.ocupado == false)
                {
                    
                    y = x.left;
                    //System.out.println(x.left.tamanio);
                    
                    
                }
                else
                {
                    //System.out.println("No");
                    if(espacio2 <= x.disponible && x.right.ocupado == false)
                    {
                        //System.out.println("Entra Derecha");
                        y = x.right;
                    }
                    else
                    {
                        if(x.father != null && espacio2 <= x.father.right.disponible && x.father.right.ocupado == false)
                        {
                            y= x.father.right;
                            x = x.father;
                        }
                        else
                        {
                            System.out.println("No hay espacio");
                            return null;
                        }
                        
                    }
                }
                
            }
            //System.out.println("Disponible: " + y.tamanio + " < " + espacio + " <= " + x.tamanio );
            if(y.tamanio < espacio && espacio <= x.tamanio)
            {
                x.father.accesible = false;
                x.father.right.accesible = true;
                x.father.visto = false;
                x.visto = true;
                System.out.println("Se ocupa el bloque de " + x.tamanio);
                x.tamOcupado = espacio;
                x.ocupado = true;
                x.proceso = proceso;
                
                z = x;
                while(z != null)
                {
                    z.disponible-= x.tamanio;
                    z = z.father;
                }
                
                x.accesible = false;
                bandera = true;
                break;
            }
            else
            {
                //System.out.println("No");
                x.accesible = false;
                if(x.right.tamanio == x.right.disponible)
                    x.right.visto = true;
                if(x.left.tamanio == x.left.disponible)
                    x.left.visto = true;
                x.visto = false;
                x = y;
            }
        
        }
        /*System.out.println("Izquierda: "+T.root.left.disponible);
        System.out.println("Derecha: " +T.root.right.disponible);*/
        return x;
    }
    
    public TreeNode crearArbol(TreeNode x) 
    {
        
            if(x.tamanio >= 1)
            {
                TreeNode a = new TreeNode(x.tamanio/2);
                TreeNode b = new TreeNode(x.tamanio/2);
                a.father = x;
                x.left = a;
                x.right = b;
                b.father = x;
                return a;
            }
            else
            {
                System.out.println("No se puede fragmentar más la memoria");
                return x;
            }
            
    }
    
    
    public TreeNode encontrarNodo(TreeNode x, String k)
    {
        if (x != null)
        {
            if (x.proceso.equals(k))
            {
                return x; // Retorna el nodo actual si x.proceso es igual a k
            }

            TreeNode nodoIzquierdo = encontrarNodo(x.left, k); // Busca en el subárbol izquierdo
            if (nodoIzquierdo != null) 
            {
                return nodoIzquierdo; // Si se encuentra en el subárbol izquierdo, retorna el nodo
            }

            TreeNode nodoDerecho = encontrarNodo(x.right, k); // Busca en el subárbol derecho
            if (nodoDerecho != null) 
            {
                return nodoDerecho; // Si se encuentra en el subárbol derecho, retorna el nodo
            }
        }

        return null; // Retorna null si no se encuentra el nodo en el subárbol actual
    }
    
    public void liberarMemoria(TreeNode x, String k)
    {
        int libera;
        TreeNode y = encontrarNodo(x, k);
        
        if(y== null)
        {
            System.out.println("No se encontroooo");
        }
        else
        {
            
            System.out.println("Se libero el proceso " + y.proceso + " de tamaño " + y.tamanio);
            y.etiqueta.setText(String.valueOf(y.tamanio));
            y.ocupado = false;
            y.proceso = " ";
            y.tamOcupado =0;
            libera = y.tamanio;
             while(y != null)
            {
                y.disponible+= libera;
                
                
                //System.out.println(y.tamanio);
                if(y.father != null && y.father.left.tamanio == y.father.left.disponible && y.father.right.tamanio == y.father.right.disponible)
                {
                    y.father.left.visto = false;
                    y.father.right.visto = false;
                    y.father.visto = true;
                    y.accesible = true;
                    
                }
                y = y.father;
            }
        }
        
        
    }
    
    public int memoriaDesperdiciada(TreeNode x)
    {
        
        if(x != null)
        {
            if(!x.proceso.equals(" "))
            {
               //System.out.println(x.disponible);
               memoria += (x.tamanio-x.tamOcupado);
               //System.out.println(memoria);
            }
            memoriaDesperdiciada(x.left);
            memoriaDesperdiciada(x.right);
            
            
        }
        return memoria; 
    }
    
    
    
    public void inorderTreeWalk(TreeNode x)
    {
        if(x != null)
        {
            //if(x.visto == true)
            {
                System.out.println("-----------------------------------------");
                System.out.println(x.tamanio);
                System.out.println(x.disponible);
                System.out.println(x.visto);
                System.out.println("Ocupado " +x.ocupado);
                System.out.println("Accesible " + x.accesible);
            }
            
            
            
            inorderTreeWalk(x.left);
            inorderTreeWalk(x.right);
            
            
        }
    }
    
    public void hijosYPadres(TreeNode x)
    {
        if(x != null)
        {
             if(x.visto == true)
            //{
                System.out.println("-----------------------------------------");
                System.out.println("Nodo: " + x.tamanio + " Dispo " + x.disponible);
                if(!x.proceso.equals(" "))
                {
                    System.out.println("Proceso Asignado: " + x.proceso);
                }
                if(x.left!=null || x.right!=null )
                {
                    System.out.println("Izquierda: " + x.left.tamanio + " Dispo: " + x.left.disponible);
                    System.out.println("Derecha: " + x.right.tamanio + " Dispo: " + x.right.disponible);

                }
                else
                    System.out.println("No tiene hijos");

            //}
            hijosYPadres(x.left);
            hijosYPadres(x.right);
            
            
        }
    }
    
    
    
}

/*public void asignarMemoria(Tree T, float espacio) //PRIMERA VERSIÓN
    {
        
        TreeNode x = T.root;
        TreeNode y;
        boolean bandera = false;
        while(!bandera)
        {
            y = crearArbol(x);
            if(y.tamanio < espacio && espacio <= y.father.tamanio)
            {
                x= y.father;
                x.visto = true;
                System.out.println("Se ocupa el bloque de " + x.tamanio);
                x.ocupado = true;
                x.disponible-= espacio;
                bandera = true;
                break;
            }
            else
            {
                System.out.println("No");
                
            }
            
        }
        
    }*/

/*public TreeNode crearArbol(TreeNode x) 
    {
        TreeNode z = x;
        
        if(x.left == null && x.right == null)
        {
            TreeNode a = new TreeNode(x.tamanio/2);
            TreeNode b = new TreeNode(x.tamanio/2);
            a.father = x;
            x.left = a;
            x.right = b;
            b.father = x;
            return a;
        }
        else
        {
            while(z.left!=null || z.right != null)
            {
                if(z.left.ocupado == true)
                {
                    z = z.right;
                }
                else
                {
                    z = z.left;
                }
            }
            if(z.tamanio > 1)
            {
                TreeNode a = new TreeNode(z.tamanio/2);
                TreeNode b = new TreeNode(z.tamanio/2);
                a.father = z;
                b.father = z;
                z.left = a;
                z.right = b;
                return a;
            }
            else
            {
                System.out.println("No se puede fragmentar más la memoria");
                return z;
            }
            
        }
        
    }*/

    /*public void asignarMemoria(Tree T, float espacio) //Segunda versión
    {
        
        TreeNode x = T.root;
        TreeNode y;
        boolean bandera = false;
        while(!bandera)
        {
            if(x.left == null || x.right == null)
            {
                y = crearArbol(x);
            }
            else
            {
                System.out.println(x.left.tamanio);
                if(x.left.ocupado == false && (x.left.accesible ==true ||espacio < x.tamanio/4))
                {
                    //System.out.println("ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    y = x.left;
                }
                else
                {
                    if(x.right.ocupado == false && x.left.accesible == true || espacio < x.tamanio/4)
                    {
                       y= x.right; 
                    }
                    else
                    {
                        y = volverEnArbol(x);
                        
                    }
                        
                }
            }
            
            if(y.tamanio < espacio && espacio <= x.tamanio)
            {
                x.father.accesible = false;
                x.father.right.accesible = true;
                x.father.visto = false;
                x.father.right.visto = true;
                x.father.left.visto = true;
                //x.visto = true;
                System.out.println("Se ocupa el bloque de " + x.tamanio);
                x.ocupado = true;
                x.disponible-= espacio;
                x.accesible = false;
                bandera = true;
                break;
            }
            else
            {
                System.out.println("No");
                x.accesible = false;
                
                if(x.left.ocupado == false && x.left.accesible ==true)
                {
                    x = x.left;
                }
                else
                {
                    x = x.right;
                }
                
            }
            
            
        }
        
    }*/

/*public TreeNode volverEnArbol(TreeNode x)
    {
        boolean bandera = false;
        while(!bandera && x != null)
        {
            System.out.println("volvio");
            if(x.left.accesible == true && x.left.ocupado == false)
            {
                x = x.left;
                bandera = true;
                break;
            }
            else
            {
                if(x.right.accesible == true && x.right.ocupado == false)
                {
                    x = x.right;
                    bandera = true;
                    break;
                }
                
            }
            x = x.father;
        }
        
        return x;
    }*/
























































