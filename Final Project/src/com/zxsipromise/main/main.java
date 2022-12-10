package com.zxsipromise.main;

import com.zxsipromise.view.LoginFrame;

import java.awt.*;
/**
 * to run this program
 * @author xiaosong zhai
 */

public class main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    LoginFrame frame = new LoginFrame();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
