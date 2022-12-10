/*
 * Created by JFormDesigner on Sun Dec 04 01:59:26 PST 2022
 */

package com.zxsipromise.view;

import com.zxsipromise.utils.LoginConfig;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class AdminMainFrame extends JFrame {
    public AdminMainFrame() {
        initComponents();
    }

    private void logoutActionPerformed(ActionEvent e) {
        // TODO add your code here
        int x = JOptionPane.showConfirmDialog(null,"confirm to exist?");
        if (x == 0){
            dispose();
            LoginConfig.clean();
        }
    }

    private void addCateActionPerformed(ActionEvent e) {
        // TODO add your code here
        new adminAddCateFrame().setVisible(true);
    }

    private void mainCateActionPerformed(ActionEvent e) {
        // TODO add your code here
        new adminMainCateFrame().setVisible(true);
    }

    private void addBookActionPerformed(ActionEvent e) {
        // TODO add your code here
        new adminAddBook().setVisible(true);
    }

    private void mainBookActionPerformed(ActionEvent e) {
        // TODO add your code here
        new adminMainBookFrame().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu2 = new JMenu();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu3 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem6 = new JMenuItem();
        label1 = new JLabel();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u9986.png")).getImage());
        setTitle("Admin");
        var contentPane = getContentPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //======== menuBar1 ========
        {

            //======== menu2 ========
            {
                menu2.setText("Book Manage");
                menu2.setFont(menu2.getFont().deriveFont(menu2.getFont().getSize() + 5f));
                menu2.setBackground(new Color(0x3366ff));
                menu2.setIcon(new ImageIcon(getClass().getResource("/images/\u4e66\u7c4d\u7ba1\u7406.png")));

                //======== menu1 ========
                {
                    menu1.setText("Book Category");
                    menu1.setIcon(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u5206\u7c7b.png")));

                    //---- menuItem1 ----
                    menuItem1.setText("Add Category");
                    menuItem1.setIcon(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u79cd\u7c7b\u6dfb\u52a0.png")));
                    menuItem1.addActionListener(e -> addCateActionPerformed(e));
                    menu1.add(menuItem1);

                    //---- menuItem3 ----
                    menuItem3.setText("Maintain Category");
                    menuItem3.setIcon(new ImageIcon(getClass().getResource("/images/\u79cd\u7c7b\u7ef4\u62a4\u5de5\u4f5c.png")));
                    menuItem3.addActionListener(e -> mainCateActionPerformed(e));
                    menu1.add(menuItem3);
                }
                menu2.add(menu1);

                //======== menu3 ========
                {
                    menu3.setText("Book Manage");
                    menu3.setIcon(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u7ba1\u7406.png")));

                    //---- menuItem2 ----
                    menuItem2.setText("Add Book");
                    menuItem2.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0\u56fe\u4e66.png")));
                    menuItem2.addActionListener(e -> addBookActionPerformed(e));
                    menu3.add(menuItem2);

                    //---- menuItem4 ----
                    menuItem4.setText("Maintain Book");
                    menuItem4.setIcon(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u7ef4\u62a4.png")));
                    menuItem4.addActionListener(e -> mainBookActionPerformed(e));
                    menu3.add(menuItem4);
                }
                menu2.add(menu3);

                //---- menuItem6 ----
                menuItem6.setText("Log Out");
                menuItem6.setIcon(new ImageIcon(getClass().getResource("/images/\u9000\u51fa.png")));
                menuItem6.addActionListener(e -> logoutActionPerformed(e));
                menu2.add(menuItem6);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 21));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/booksBG.jpg")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu2;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem2;
    private JMenuItem menuItem4;
    private JMenuItem menuItem6;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
