
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import archivo_manager.archivo_manager;
//import javafx.scene.web.PromptData;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vik0x
 */
public class IDE extends javax.swing.JFrame {
    public static File directorio = null;
    public static String ext = null;

    /**
     * Creates new form IDE
     */
    public IDE() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt_codigo = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_nuevo = new javax.swing.JMenuItem();
        menu_abrir = new javax.swing.JMenuItem();
        menu_guardar = new javax.swing.JMenuItem();
        menu_guardarcomo = new javax.swing.JMenuItem();
        menu_eliminar = new javax.swing.JMenuItem();
        menu_salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(txt_codigo);

        jMenu1.setText("Archivo");

        menu_nuevo.setText("Nuevo");
        menu_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_nuevoActionPerformed(evt);
            }
        });
        jMenu1.add(menu_nuevo);

        menu_abrir.setText("Abrir");
        menu_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_abrirActionPerformed(evt);
            }
        });
        jMenu1.add(menu_abrir);

        menu_guardar.setText("Guardar");
        menu_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardarActionPerformed(evt);
            }
        });
        jMenu1.add(menu_guardar);

        menu_guardarcomo.setText("Guardar como...");
        menu_guardarcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardarcomoActionPerformed(evt);
            }
        });
        jMenu1.add(menu_guardarcomo);

        menu_eliminar.setText("Eliminar");
        menu_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_eliminarActionPerformed(evt);
            }
        });
        jMenu1.add(menu_eliminar);

        menu_salir.setText("Salir");
        menu_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_salirActionPerformed(evt);
            }
        });
        jMenu1.add(menu_salir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardarActionPerformed
        // TODO add your handling code here:
        try{
            if(directorio == null){
                
                JFileChooser dir = new JFileChooser();
                dir.setDialogTitle("Guardar Archivo");
                if(dir.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                    directorio = dir.getCurrentDirectory();
                    File nombre;
                    nombre = dir.getSelectedFile();
                    ext = dir.getDescription(nombre);
                    int dot = ext.lastIndexOf('.');
                    String extension = (dot == -1) ? "" : ext.substring(dot+1);
                    if(!"txt".equals(extension)){
                        ext = ext + ".txt";
                    }
                    File archivo = new File (directorio+"/"+ext);
                    if(archivo.exists()){
                        int seleccion = JOptionPane.showOptionDialog(
                        rootPane,
                        "Desea sobreescribir el archivo",
                        "Archivo existente",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,    // null para icono por defecto.
                        new Object[] { "SI", "NO" },   // null para YES, NO y CANCEL
                        "SI");

                        if (seleccion == 1){
                            //BufferedWriter ayuda a manejar los streams
                            //FileWriter nos ayuda a escribir dentro de archivos
                            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                            //usamos el método .write para escribir la cadena
                            bw.write(txt_codigo.getText());
                            //Muy importante, siempre cerrar el archivo.
                            bw.close();
                        }
                    }
                }
            }
            else{
                File archivo = new File (directorio+"/"+ext);
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(txt_codigo.getText());            
                bw.close();
            }
        }catch(IOException e1){
            JOptionPane.showMessageDialog(rootPane, "Error crear archivo");
        }
    }//GEN-LAST:event_menu_guardarActionPerformed

    private void menu_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menu_salirActionPerformed

    private void menu_guardarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardarcomoActionPerformed
        // TODO add your handling code here:
        try{
            JFileChooser dir = new JFileChooser();
            dir.setDialogTitle("Guardar Archivo como...");
            if(dir.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                directorio = dir.getCurrentDirectory();
                File nombre;
                nombre = dir.getSelectedFile();
                ext = dir.getDescription(nombre);
                int dot = ext.lastIndexOf('.');
                String extension = (dot == -1) ? "" : ext.substring(dot+1);
                if(!"txt".equals(extension)){
                    ext = ext + ".txt";
                }
                File archivo = new File (directorio+"/"+ext);
                if(archivo.exists()){
                    int seleccion = JOptionPane.showOptionDialog(
                    rootPane,
                    "Desea sobreescribir el archivo",
                    "Archivo existente",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,    // null para icono por defecto.
                    new Object[] { "SI", "NO" },   // null para YES, NO y CANCEL
                    "SI");

                    if (seleccion == 1){
                        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                        bw.write(txt_codigo.getText());
                        bw.close();
                    }
                }
            }
        }catch(IOException e1){
            JOptionPane.showMessageDialog(rootPane, "Error crear archivo");
        }
    }//GEN-LAST:event_menu_guardarcomoActionPerformed

    private void menu_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_abrirActionPerformed
        // TODO add your handling code here:
        String aux="";   
        String texto="";
        try{
            /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser dir=new JFileChooser();
            if(dir.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                /**abrimos el archivo seleccionado*/
                directorio = dir.getCurrentDirectory();
                File nombre=dir.getSelectedFile();
                ext = dir.getDescription(nombre);

                /**recorremos el archivo, lo leemos para plasmarlo
                *en el area de texto*/
                if(nombre!=null){     
                    FileReader archivos=new FileReader(nombre);
                    BufferedReader lee=new BufferedReader(archivos);
                    while((aux=lee.readLine())!=null){
                        texto+= aux+ "\n";
                    }
                    lee.close();
                }
                txt_codigo.setText(texto);
            }
        }
        catch(IOException ex){
        JOptionPane.showMessageDialog(null,"\nNo se ha encontrado el archivo",
                 "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_menu_abrirActionPerformed

    private void menu_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_nuevoActionPerformed
        // TODO add your handling code here:
        txt_codigo.setText("");
        directorio = null;
        ext = null;
    }//GEN-LAST:event_menu_nuevoActionPerformed

    private void menu_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_eliminarActionPerformed
        // TODO add your handling code here:
        if(directorio != null && ext != null){
            File archivo = new File(directorio+"/"+ext);
            if(archivo.exists()){
                archivo.delete();
                directorio=null;
                ext=null;
                txt_codigo.setText("");
            }
        }
    }//GEN-LAST:event_menu_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IDE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menu_abrir;
    private javax.swing.JMenuItem menu_eliminar;
    private javax.swing.JMenuItem menu_guardar;
    private javax.swing.JMenuItem menu_guardarcomo;
    private javax.swing.JMenuItem menu_nuevo;
    private javax.swing.JMenuItem menu_salir;
    private javax.swing.JTextPane txt_codigo;
    // End of variables declaration//GEN-END:variables
}
