/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvellous.packer.unpacker;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Admin
 */
class clocklabel extends JLabel implements ActionListener
{
    String type;
    SimpleDateFormat sdf;
    
    public clocklabel(String type)
    {
        this.type = type;
        setForeground(Color.green);
    
    switch(type)
    {
        case "date" : 
                        sdf = new SimpleDateFormat("MM DD YYYY");
                        setFont(new Font("sans-serif" , Font.PLAIN,16));
                        setHorizontalAlignment(SwingConstants.LEFT);
                        break;
        
        case "time" : 
                        sdf = new SimpleDateFormat("hh : mm : ss");
                        setFont(new Font("sans-serif" , Font.PLAIN,40));
                        setHorizontalAlignment(SwingConstants.CENTER);
                        break;
            
        case "day" : 
                        sdf = new SimpleDateFormat("EEEE");
                        setFont(new Font("sans-serif" , Font.PLAIN,16));
                        setHorizontalAlignment(SwingConstants.RIGHT);
                        break;
         
        default : 
                        sdf = new SimpleDateFormat();
                        break;
    }
        Timer t = new Timer(1000,this);
        t.start();
}

    public void actionPerformed(ActionEvent ae)
    {
        Date d = new Date();
        setText(sdf.format(d));
    }
}
public class Template extends JFrame implements ActionListener
{
    JPanel _header;
    JPanel _content;
    JPanel _top;
    
    clocklabel daylabel;
    clocklabel timelabel;
    clocklabel datelabel;
    
    JButton minimize , exit;
    
    public Template() 
    {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        
        _top = new JPanel();
        _top.setBackground(Color.LIGHT_GRAY);
        _top.setLayout(null);
        
        getContentPane().add(_top, new GridBagConstraints(0,0,1,1,1,5, GridBagConstraints.BASELINE ,GridBagConstraints.BOTH , new Insets(0,0,0,0),0,0 ));
        
        _header = new JPanel();
        _header.setBackground(Color.WHITE);
        _header.setLayout(null);
        
        getContentPane().add(_header, new GridBagConstraints(0,1,1,1,1,20, GridBagConstraints.BASELINE ,GridBagConstraints.BOTH , new Insets(0,0,0,0),0,0 ));
        
        _content = new JPanel();
        _content.setBackground(Color.LIGHT_GRAY);
        _content.setLayout(null);
        
        JScrollPane jsp = new JScrollPane(_content, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        getContentPane().add(jsp, new GridBagConstraints(0,2,1,1,1,75, GridBagConstraints.BASELINE ,GridBagConstraints.BOTH , new Insets(0,0,0,0),0,0 ));
        setTitle("Marvellous Packer-Unpacker");
        clock();
        closeAndmin();
    }
    
    void closeAndmin()
    {
        minimize = new JButton("-");
        minimize.setBackground(Color.LIGHT_GRAY);
        minimize.setBounds(MAXIMIZED_HORIZ, 0, 45, 20);
        
        exit = new JButton("X");
        
        exit.setBackground(Color.LIGHT_GRAY);
        exit.setBounds(MAXIMIZED_HORIZ, 0, 45, 20);
        _top.add(minimize);
        _top.add(exit);
        
        exit.addActionListener(this);
        minimize.addActionListener(this);
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
    }
    
    void clock()
    {
        datelabel = new clocklabel("date");
        timelabel = new clocklabel("time");
        daylabel = new clocklabel("day");
        
        datelabel.setForeground(Color.BLUE);
        timelabel.setForeground(Color.BLUE);
        daylabel.setForeground(Color.BLUE);
        
        daylabel.setFont(new Font("Centuary", Font.BOLD,15));
        daylabel.setBounds(700, 10, 200, 100);
        
        datelabel.setFont(new Font("Centuary", Font.BOLD,15));
        datelabel.setBounds(800, -40, 200, 100);
        
        timelabel.setFont(new Font("Centuary", Font.BOLD,15));
        timelabel.setBounds(760, -15, 200, 100);
        
        _header.add(datelabel);
        _header.add(timelabel);
        _header.add(daylabel);
    }
    
    void clockhome()
    {
        datelabel = new clocklabel("date");
        timelabel = new clocklabel("time");
        daylabel = new clocklabel("day");
        
        datelabel.setForeground(Color.BLUE);
        timelabel.setForeground(Color.BLUE);
        daylabel.setForeground(Color.BLUE);
        
        daylabel.setFont(new Font("Centuary", Font.BOLD,15));
        daylabel.setBounds(200, 20, 200, 100);
        
        datelabel.setFont(new Font("Centuary", Font.BOLD,15));
        datelabel.setBounds(300, -40, 200, 100);
        
        timelabel.setFont(new Font("Centuary", Font.BOLD,15));
        timelabel.setBounds(260, -15, 200, 100);
        
        _header.add(datelabel);
        _header.add(timelabel);
        _header.add(daylabel);
        
    }

    
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
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Template().setVisible(true);
            }
        });
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

