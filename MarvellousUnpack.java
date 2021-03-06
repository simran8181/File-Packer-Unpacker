/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvellous.packer.unpacker;
import java.lang.String;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 *
 * @author Admin
 */
public class MarvellousUnpack 
{

    FileOutputStream fo = null;
    
    public MarvellousUnpack(String src) throws Exception
    {
        initComponents();
        unpack(src);
    }

   
    

   
    public void unpack(String filePath) throws Exception
    {
        try
        {
            FileInputStream fi = new FileInputStream(filePath);
            byte header[] = new byte[100];
            int length = 0;
            
            byte Magic[] = new byte[12];
            fi.read(Magic, 0, Magic.length);
            
            String Magicstr = new String(Magic);
            
            if(!Magicstr.equals("Marvellous11"))
            {
                throw new InvalidFileException("Invalid packed file format");
            }
            
            while((length = fi.read(header,0,100))>0)
            {
                String str = new String(header);
                String ext = str.substring(str.lastIndexOf("/"));
                ext = ext.substring(1);
                String[] words = ext.split("\\s");
                String filename = words[0];
                
                int size = Integer.parseInt(words[1]);
                byte arr[] = new byte[size];
                fi.read(arr,0,size);
                FileOutputStream fout = new FileOutputStream(filename);
                fout.write(arr,0,size);
            }
        }
        catch(InvalidFileException obj)
        {
            throw new InvalidFileException("Invalid packed file format");
        }
        catch(Exception e)
        {
            
        }
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MarvellousUnpack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarvellousUnpack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarvellousUnpack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarvellousUnpack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new MarvellousUnpack().setVisible(true);
            }
        });
    }

}
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

