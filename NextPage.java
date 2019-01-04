/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvellous.packer.unpacker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class NextPage extends Template implements ActionListener
{

    JLabel label;
    JButton pack,unpack;
    
    public NextPage(String value) 
    {
        //initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        label = new JLabel("Welcome"+value);
        Dimension size = label.getPreferredSize();
        label.setBounds(40, 50, size.width + 60, size.height);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Centuary", Font.BOLD,17));
        
        pack = new JButton("Pack files");
        Dimension bsize = pack.getPreferredSize();
        pack.setBounds(100, 100, bsize.width, bsize.height);
        pack.addActionListener(this);
        
        unpack = new JButton("Unpack files");
        Dimension b2size = pack.getPreferredSize();
        unpack.setBounds(100, 100, b2size.width, b2size.height);
        unpack.addActionListener(this);
        
        _header.add(label);
        _content.add(pack);
        _content.add(unpack);
        
        clockhome();
        this.setSize(600,600);
        this.setResizable(false);
        this.setVisible(true);
    }

    private NextPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== exit)
        {
            this.setVisible(false);
            System.exit(0);
        }
         if(ae.getSource()== minimize)
        {
            this.setState(this.ICONIFIED);
        }
        if(ae.getSource()== pack)
        {
            this.setVisible(false);
            try
            {
                MarvellousPackFront obj = new MarvellousPackFront();
            }
            catch(Exception e){}
        }
        if(ae.getSource()== unpack)
        {
            this.setVisible(false);
            MarvellousUnpackFront obj = new MarvellousUnpackFront();
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

    public static void main(String args[])
    {
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
            java.util.logging.Logger.getLogger(NextPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NextPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NextPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NextPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new NextPage().setVisible(true);
            }
            
        });
    }

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

