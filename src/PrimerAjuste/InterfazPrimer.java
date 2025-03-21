/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 */
package PrimerAjuste;


import java.awt.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Rojas Rodríguez Martín Omar, 178809@upslp.edu.mx
 */
public class InterfazPrimer extends javax.swing.JFrame {

    
    String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] enMemoria = new String[27];
    ListaSentinelaPrimer L;
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(abecedario);
    List<String> opcionesNoVacias = new ArrayList<>();
    DefaultComboBoxModel<String> model2;
    //DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(enMemoria);
    public InterfazPrimer(ListaSentinelaPrimer L) {
        initComponents();
        this.L = L;
        jComboBox1.setModel(model);
        L.fragmentarMemoria();
        asignarFiguras(L.nil.prev);
        //System.out.println(L);




        //JPanel si = generarRegion(T.root.coordenada, T.root.tamanio, T.root);
        //T.root.representacion = si;
        //jPanel1.add(si);
        //comboAsignados.setModel(model2);
        comboAsignados.setVisible(false);
        btnLiberar.setVisible(false);
        jLabel1.setVisible(false);
        jLabel3.setVisible(false);
        jPanel1.repaint();
        //txtD.setText(String.valueOf((T.root.disponible)));
        txtDesperdiciada.setText(String.valueOf(0));
        Arrays.fill(enMemoria, "");
        txtD.setText(String.valueOf(L.memoriaDisponible()));
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtTamanio = new javax.swing.JTextField();
        btnAsignar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboAsignados = new javax.swing.JComboBox<>();
        btnLiberar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDesperdiciada = new javax.swing.JTextField();
        txtD = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Proceso:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(360, 330, 60, 17);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(150, 330, 120, 23);

        jLabel2.setText("Tamaño:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 370, 60, 17);
        jPanel1.add(txtTamanio);
        txtTamanio.setBounds(150, 370, 120, 23);

        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAsignar);
        btnAsignar.setBounds(100, 430, 110, 23);

        jLabel3.setText("Liberar Memoria");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(410, 300, 100, 17);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Proceso:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 330, 60, 17);

        comboAsignados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboAsignados);
        comboAsignados.setBounds(420, 330, 120, 23);

        btnLiberar.setText("Liberar");
        btnLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLiberar);
        btnLiberar.setBounds(430, 430, 110, 23);

        jLabel5.setText("Asignar Memoria");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(120, 300, 100, 17);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Memoria Desperdiciada:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(700, 370, 140, 17);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Memoria Disponible:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(700, 330, 120, 17);
        jPanel1.add(txtDesperdiciada);
        txtDesperdiciada.setBounds(860, 365, 150, 23);
        jPanel1.add(txtD);
        txtD.setBounds(860, 330, 150, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1138, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        Nodo efectivo;
        
        efectivo = L.asignarProceso(Integer.parseInt(txtTamanio.getText()), String.valueOf(jComboBox1.getSelectedItem()));
        if(efectivo != null)
        {
            
            enMemoria[L.asignados] = String.valueOf(jComboBox1.getSelectedItem());
            L.asignados ++;
            for (int i = 0; i < abecedario.length; i++) 
            {
                if(abecedario[i].equals(String.valueOf(jComboBox1.getSelectedItem())))
                {
                    String[] nuevoAbecedario = new String[abecedario.length - 1];

                    for (int j = 0, k = 0; j < abecedario.length; j++) {
                        if (j != i) 
                        {
                            nuevoAbecedario[k++] = abecedario[j];
                        }   
                    }
                    abecedario = nuevoAbecedario;
                    DefaultComboBoxModel<String> nuevoModel = new DefaultComboBoxModel<>(abecedario);
                    jComboBox1.setModel(nuevoModel);
                    break; // Termina el bucle una vez que se elimina la letr
                }
            }
            opcionesNoVacias.clear();
            for (String opcion : enMemoria) {
                if (opcion != null && !opcion.isEmpty()) {
                    opcionesNoVacias.add(opcion);
                }
            }

            // Crea un nuevo modelo con las opciones no vacías
            DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(opcionesNoVacias.toArray(new String[0]));
            
            comboAsignados.setModel(model2);
            comboAsignados.setVisible(true);
            btnLiberar.setVisible(true);
            jLabel1.setVisible(true);
            jLabel3.setVisible(true);
            jPanel1.remove(efectivo.representacion);
            jPanel1.remove(efectivo.etiqueta);
            efectivo.representacion= null;
            asignarFiguras(L.nil.prev);
            
            jPanel1.repaint();
            txtD.setText(String.valueOf(L.memoriaDisponible()));
            //txtDesperdiciada.setText(String.valueOf(T.memoriaDesperdiciada(T.root)));
            System.out.println(L);
            
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void btnLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarActionPerformed
        Nodo a = L.liberarProceso(String.valueOf(comboAsignados.getSelectedItem()), jPanel1);
        if(a != null)
        {
            
            String[] nuevoAbecedario = new String[abecedario.length + 1];
            asignarFiguras(L.nil.prev);

            for (int j = 0; j < abecedario.length; j++) {

                    nuevoAbecedario[j] = abecedario[j];

            }
            nuevoAbecedario[abecedario.length] = String.valueOf(comboAsignados.getSelectedItem());
            abecedario = nuevoAbecedario;
            DefaultComboBoxModel<String> nuevoModel = new DefaultComboBoxModel<>(abecedario);
            jComboBox1.setModel(nuevoModel);

            for (int i = 0; i <enMemoria.length; i++) {
                if(enMemoria[i].equals(String.valueOf(comboAsignados.getSelectedItem())))
                {
                    enMemoria[i]=" ";
                }
            }
            String[] si = new String [27];
            Arrays.fill(si, "");
            for (int i = 0, k=0; i < enMemoria.length; i++) {
                if(!enMemoria[i].equals(" ") )
                {
                    si[k] = enMemoria[i];
                    k++;
                }
            }
            enMemoria = si;

            L.asignados--;
            opcionesNoVacias.clear();
                for (String opcion : enMemoria) {
                    if (opcion != null && !opcion.isEmpty()) {
                        opcionesNoVacias.add(opcion);
                    }
                }
            model2 =  new DefaultComboBoxModel<>(opcionesNoVacias.toArray(new String[0]));
            comboAsignados.setModel(model2);
            if(opcionesNoVacias.isEmpty())
            {
                comboAsignados.setVisible(false);
                btnLiberar.setVisible(false);
                jLabel1.setVisible(false);
                jLabel3.setVisible(false);
            }
            //jPanel1.remove(a.representacion);
            //a.representacion = null;
            asignarFiguras(L.nil.prev);
            jPanel1.repaint();
            txtD.setText(String.valueOf(L.memoriaDisponible()));
        }
    }//GEN-LAST:event_btnLiberarActionPerformed
    
    public void asignarFiguras(Nodo x)
    {
       JPanel si;
       if(x != L.nil)
        {
            //System.out.println(x.tamanio);
            if(x.representacion == null )
            {
                si = generarRegion(x.inicio + 50, x.tamanio, x);
                x.representacion = si;
                x.representacion.setVisible(true);
                jPanel1.add(si);
                
            }
            
            asignarFiguras(x.prev); 
        }
       
    }
    
    public JPanel generarRegion(int x, int width,  Nodo z)
    {
        Color colorOcupados = new Color(245, 108, 103);
        Color colorLibre = new Color(8, 191, 165);
        JLabel label;
        JPanel panelRectangular = new JPanel();
        if(z.ocupado == true && !z.proceso.equals(" "))
        {
             label = new JLabel(z.proceso);
             
        }
        else
        {
             label = new JLabel(String.valueOf(width));
        }
        
        if(z.tamanio <40)
        {
            label.setBounds(x+(z.tamanio)/2 -5 , 50, 100, 50); // Establece la ubicación (x, y) y el tamaño (ancho, alto) del JLabel    
        }
        else
        {
            if(z.tamanio <=20)
            {
                label.setBounds(x, 50, 100, 50); // Establece la ubicación (x, y) y el tamaño (ancho, alto) del JLabel    
            }
            else
            {
                
                label.setBounds(x+(z.tamanio)/2 , 50, 100, 50); // Establece la ubicación (x, y) y el tamaño (ancho, alto) del JLabel    
                
            }
        }
        LineBorder bordeNegro = new LineBorder(Color.BLACK, 1);
        z.etiqueta = label;
        jPanel1.add(label);
        //z.etiqueta.setVisible(false);
        
        panelRectangular.setBounds(x, 50, width, 50);
        panelRectangular.setBorder(bordeNegro);
        Random rand = new Random();
        if(z.ocupado == false)
        {
            panelRectangular.setBackground(colorLibre);
        }
        else
        {
            panelRectangular.setBackground(colorOcupados);
        }
        
        jPanel1.add(panelRectangular);
        return panelRectangular;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazPrimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnLiberar;
    private javax.swing.JComboBox<String> comboAsignados;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtD;
    private javax.swing.JTextField txtDesperdiciada;
    private javax.swing.JTextField txtTamanio;
    // End of variables declaration//GEN-END:variables
}
