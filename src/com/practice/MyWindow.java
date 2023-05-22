package com.practice;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MyWindow extends JFrame {
    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("", Font.BOLD, 35);

    MyWindow(){ //constructor

        super.setTitle("MyClock");
        super.setSize(550, 400);
        super.setLocation(300, 50);
        createGUI();
        super.setVisible(true);
    }
    public void createGUI(){
        heading = new JLabel("MyClock");
        clockLabel = new JLabel("Clock");
        heading.setFont(font);
        clockLabel.setFont(font);
        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);
        //startClock();
        startClockUsingThreading();
    }

    public void startClock(){
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String dateTime = new Date().toString();
                String dateTime1 = new Date().toLocaleString();
                clockLabel.setText(dateTime1);
            }
        });
        timer.start();
    }

    public void startClockUsingThreading(){
        Thread t = new Thread(){
            public void run(){
                try{
                    while(true){
                        String dateTime1 = new Date().toLocaleString();
                        clockLabel.setText(dateTime1);
                        Thread.sleep(1000);
                    }
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
