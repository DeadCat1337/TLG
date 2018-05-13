/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author leha
 */
public class Window extends JFrame{
    final int LABEL_WIDTH = 200, LIGHT_WIDTH = 60, LIGHT_HEIGHT = 60;
    
    JButton field;
    //JLabel lCarsDown, lCarsLeft, lCarsUp, lCarsRight, lTime;
    JLabel lTime, lCars[];
    BLight bl[];
    
    public Window(){
        super("TrafficLight");
        lCars = new JLabel[4];
        bl = new BLight[4];
        
        initW();
        initComp();
        
        repaint();
    }
    
    private void initW(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(890, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private void initComp(){
        field = new JButton("lol");
        field.setLayout(null);
        //field.setEnabled(false);
        
        ImageIcon icon = createIcon("back.png");
        field.setIcon(icon);
        
        field.setLocation(0, 0);
        field.setSize(getContentPane().getWidth(), getContentPane().getHeight());
        add(field);
        
        for(int i = 0; i < 4; i++){
            lCars[i] = new JLabel("Cars: " + i);
            lCars[i].setSize(LABEL_WIDTH, field.getHeight()/3);
            lCars[i].setFont(lCars[i].getFont().deriveFont((float)30));
            lCars[i].setHorizontalAlignment(JLabel.CENTER);
            field.add(lCars[i]);
        }
        lCars[0].setLocation(field.getWidth()/2 - LABEL_WIDTH/2, 2*field.getHeight()/3);
        lCars[1].setLocation(field.getWidth()/6 - LABEL_WIDTH/2, field.getHeight()/3);
        lCars[2].setLocation(field.getWidth()/2 - LABEL_WIDTH/2, 0);
        lCars[3].setLocation(5*field.getWidth()/6 - LABEL_WIDTH/2, field.getHeight()/3);
        
        lTime = new JLabel("Time:");
        lTime.setSize(LABEL_WIDTH, field.getHeight()/3);
        lTime.setFont(lTime.getFont().deriveFont((float)30));
        lTime.setHorizontalAlignment(JLabel.CENTER);
        lTime.setLocation(field.getWidth()/2 - LABEL_WIDTH/2, field.getHeight()/3);
        field.add(lTime);
        
        for(int i = 0; i < 4; i++){
            bl[i] = new BLight();
            bl[i].setSize(LIGHT_WIDTH, LIGHT_HEIGHT);
            field.add(bl[i]);
        }
        
        bl[0].setLocation(field.getWidth()/2 - LIGHT_WIDTH/2, 2*field.getHeight()/3);
        bl[1].setLocation(field.getWidth()/3 - LIGHT_WIDTH, field.getHeight()/2 - LIGHT_HEIGHT/2);
        bl[2].setLocation(field.getWidth()/2 - LIGHT_WIDTH/2, field.getHeight()/3 - LIGHT_HEIGHT);
        bl[3].setLocation(2*field.getWidth()/3, field.getHeight()/2 - LIGHT_HEIGHT/2);
        
        
    }

    private ImageIcon createIcon(String path) {
        URL imgURL = Window.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }
    
    public void setParam(int cars[], int time, int state[]){
        for(int i = 0; i < 4; i++){
            lCars[i].setText("Cars: " + cars[i]);
            bl[i].setState(state[i]);
        }
        lTime.setText("Time: " + time);
    }
    
    public class BLight extends JButton{
        public static final int RED = 0, 
                RED_YELLOW = 1,
                GREEN = 2,
                GREEN_BLINK = 3,
                YELLOW = 4,
                YELLOW_BLINK = 5;
        
        private final Color C_RED = Color.RED, 
                                C_YELLOW = Color.YELLOW,
                                C_GREEN = Color.GREEN,
                                C_NO = Color.BLACK;
        int state;
        
        public BLight(){
            state = YELLOW_BLINK;
        }
        
        public void setState(int state){
            this.state = state;
            repaint();
        }
        
        @Override
        public void paint(Graphics g){
            if(state == RED){
                g.setColor(C_RED);
                g.fillRect(0, 0, getWidth(), getHeight());
            } else if(state == RED_YELLOW){
                g.setColor(C_RED);
                g.fillRect(0, 0, getWidth()/2, getHeight());
                g.setColor(C_YELLOW);
                g.fillRect(getWidth()/2, 0, getWidth(), getHeight());
            } else if(state == GREEN){
                g.setColor(C_GREEN);
                g.fillRect(0, 0, getWidth(), getHeight());
            } else if(state == GREEN_BLINK){
                g.setColor(C_GREEN);
                g.fillRect(0, 0, getWidth()/2, getHeight());
                g.setColor(C_NO);
                g.fillRect(getWidth()/2, 0, getWidth(), getHeight());
            } else if(state == YELLOW){
                g.setColor(C_YELLOW);
                g.fillRect(0, 0, getWidth(), getHeight());
            } else if(state == YELLOW_BLINK){
                g.setColor(C_YELLOW);
                g.fillRect(0, 0, getWidth()/2, getHeight());
                g.setColor(C_NO);
                g.fillRect(getWidth()/2, 0, getWidth(), getHeight());
            }
        }
    }

}
