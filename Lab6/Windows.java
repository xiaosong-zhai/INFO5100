package com.zxsipromise.Lab6;

import javax.swing.*;
import java.awt.*;



public class Windows {
    JFrame jframe = new JFrame("WeightGrade");
    //define the frame width and weight
    final int WIDTH = 400;
    final int HEIGHT = 250;

    //private attributes
    JTextField totalPoint;
    JTextField earnedPoint;
    JTextField precentage;
    JTextField finalPoint;
    
    //initialization the frame
    public void init(){
        jframe.setVisible(true);
        /*
        ScreenUtils class is to get the user's width and height
         Keep the frame always in the center of the screen
         */
        jframe.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        totalPoint = new JTextField(10);
        earnedPoint = new JTextField(10);
        precentage = new JTextField(10);
        finalPoint = new JTextField(10);

        Box hbox = Box.createHorizontalBox();

        //create the totalpoint section
        Box tbox = Box.createVerticalBox();
        JLabel tLabel = new JLabel("Enter TotalPoint");
        tbox.add(tLabel);
        tbox.add(Box.createVerticalStrut(1));
        tbox.add(totalPoint);

        //create the earnedpoint section
        Box ebox = Box.createVerticalBox();
        JLabel eLabel = new JLabel("Enter earnedPoint");
        ebox.add(eLabel);
        ebox.add(Box.createVerticalStrut(1));
        ebox.add(earnedPoint);

        Box vbox = Box.createVerticalBox();

        //create the precentage section
        Box pbox = Box.createVerticalBox();
        JLabel pLabel = new JLabel("Enter precentage");
        pbox.add(pLabel);
        pbox.add(Box.createVerticalStrut(1));
        pbox.add(precentage);

        //create the clickbutton section
        Box fbox = Box.createVerticalBox();
        JButton clickButton = new JButton("Click here to calculate WeightGrade");
        JLabel fLabel = new JLabel("Your finalPoint");
        fbox.add(clickButton,BorderLayout.CENTER);
        fbox.add(Box.createVerticalStrut(10));
        fbox.add(fLabel);
        fbox.add(Box.createVerticalStrut(1));
        fbox.add(finalPoint);
        clickButton.addActionListener(new WeightGrade(this));


        //add boxes into the two big boxes
        hbox.add(tbox);
        hbox.add(Box.createHorizontalStrut(10));
        hbox.add(pbox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(ebox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(fbox);

        //add two big boxes into the frame
        jframe.add(hbox,BorderLayout.NORTH);
        jframe.add(vbox,BorderLayout.CENTER);

    }







}
