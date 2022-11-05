package com.zxsipromise.Lab7;

import com.zxsipromise.Lab6.ScreenUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class window {
    JFrame jframe = new JFrame("Read Write File");
    //define the frame width and weight
    final int WIDTH = 1000;
    final int HEIGHT = 500;

    JTextField readFileName;
    JTextField writeFileName;

    JTextArea readArea;
    JTextArea writeArea;

    public void init() {
        jframe.setVisible(true);
        /*
        ScreenUtils class is to get the user's width and height
         Keep the frame always in the center of the screen
         */
        jframe.setBounds((com.zxsipromise.Lab6.ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        readFileName = new JTextField(20);
        writeFileName = new JTextField(20);
        readArea = new JTextArea();
        readArea.setColumns(5);//limit columns to 5
        writeArea = new JTextArea();
        writeArea.setColumns(5);//limit columns to 5


        Box hbox = Box.createHorizontalBox();//the first main horizontal box
        //create top section
        //top read file
        Box rbox = Box.createVerticalBox();
        JLabel rlabel = new JLabel("Read File Name");
        rbox.add(rlabel);
        rbox.add(Box.createVerticalStrut(10));
        rbox.add(readFileName);
        //top write file
        Box wbox = Box.createVerticalBox();
        JLabel wlabel = new JLabel("Write File Name");
        wbox.add(wlabel);
        wbox.add(Box.createVerticalStrut(10));
        wbox.add(writeFileName);
        //add to main box
        hbox.add(rbox);
        hbox.add(Box.createHorizontalStrut(10));
        hbox.add(wbox);


        //bottom button section
        Box hbox2 = Box.createHorizontalBox();
        Box rbox2 = Box.createVerticalBox();
        JButton readButton = new JButton("Click to read from file");
        JLabel rlabel2 = new JLabel("First five lines of file");
        rbox2.add(readButton, BorderLayout.CENTER);
        rbox2.add(Box.createVerticalStrut(10));
        rbox2.add(rlabel2);
        rbox2.add(Box.createVerticalStrut(10));
        JScrollPane readScrollpane = new JScrollPane(readArea);
        rbox2.add(readScrollpane);
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File myFile = new File("GUIdemo/src/com/zxsipromise/Lab7/annual.csv");
                    FileReader reader = new FileReader(myFile.getAbsolutePath());

                    char[] buffer = new char[1024];
                    StringBuffer result = new StringBuffer();
                    int len;
                    while((len = reader.read(buffer)) != -1) {
                        result.append(buffer,0,len);
                    }
                    reader.close();
                    readFileName.setText(myFile.getName()); //let the jtextfield to show file's name
                    readArea.setText(result.toString());//let the jtestArea to show file's context

                    System.out.println("successfully loaded");
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        //create bottom section
        Box wbox2 = Box.createVerticalBox();
        JButton writeButton = new JButton("Click to write to file");
        JLabel wlabel2 = new JLabel("First five lines of file");
        wbox2.add(writeButton, BorderLayout.CENTER);
        wbox2.add(Box.createVerticalStrut(10));
        wbox2.add(wlabel2);
        wbox2.add(Box.createVerticalStrut(10));
        JScrollPane writeScrollpane = new JScrollPane(writeArea);
        wbox2.add(writeScrollpane);
        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = writeFileName.getText();

                    String path = "GUIdemo" + File.separator + "src"+ File.separator + "com" +File.separator + "zxsipromise" +File.separator + "Lab7" +File.separator + name;
                    File f = new File(path);
                    if (f.exists())
                    {
                        f.delete(); // if have this file,first delete it
                    }
                    f.createNewFile(); //then create new file


                    FileWriter writer = new FileWriter(f);
                    //get writeArea
                    String result = writeArea.getText();

                    //write
                    writer.write(result);

                    //close stream
                    writer.close();

                    //clear textArea
                    writeArea.setText("");

                    System.out.println("successfully saved");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });


        //add to main box
        hbox2.add(rbox2);
        hbox.add(Box.createHorizontalStrut(10));
        hbox2.add(wbox2);
        //add to frame
        jframe.add(hbox,BorderLayout.NORTH);
        jframe.add(hbox2,BorderLayout.CENTER);
    }
}