/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo_manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author vik0x
 */
public class archivo_manager {
    private File directorio;
    private String ext;
    
    /**
     *
     * @param dir
     * @param archivo
     */
    public archivo_manager(File dir, String archivo){
        int dot = archivo.lastIndexOf('.');
        String extension = (dot == -1) ? "" : archivo.substring(dot+1);
        if(!"txt".equals(extension)){
            ext = archivo + ".txt";
        }
        else{
            this.ext = archivo;
        }
        this.directorio = dir;
    }
    public void guardar_nuevo() throws IOException{
//        int seleccion = JOptionPane.showOptionDialog(
//        null,
//        "Desea sobreescribir el archivo",
//        "Archivo existente",
//        JOptionPane.YES_NO_OPTION,
//        JOptionPane.QUESTION_MESSAGE,
//        null,    // null para icono por defecto.
//        new Object[] { "SI", "NO" },   // null para YES, NO y CANCEL
//        "SI");
//
//        if (seleccion == 1){
//            //BufferedWriter ayuda a manejar los streams
//            //FileWriter nos ayuda a escribir dentro de archivos
//            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
//            //usamos el método .write para escribir la cadena
//            bw.write(texto);
//            //Muy importante, siempre cerrar el archivo.
//            bw.close();
//        }
    }
}
