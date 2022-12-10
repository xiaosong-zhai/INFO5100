/*
 * Created by JFormDesigner on Sun Dec 04 00:59:39 PST 2022
 */

package com.zxsipromise.view;

import com.zxsipromise.utils.LoginConfig;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import info.clearthought.layout.*;



/**
 * @author xiaosong zhai
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
    }

    public void fillName(){
        List<String> reader = LoginConfig.reader();
        this.userNameMenu.setText(reader.get(0));
    }

    private void PasswordactionPerformed(ActionEvent e) {
        // TODO add your code here
        new UpdatePwdFrame().setVisible(true);
    }


    private void MyBookShelf(ActionEvent e) {
        // TODO add your code here
        new MyBookshelf().setVisible(true);
    }

    private void BookShelfMenu(ActionEvent e) {
        // TODO add your code here
    }

    private void logoutActionPerformed(ActionEvent e) {
        // TODO add your code here
        int x = JOptionPane.showConfirmDialog(null,"confirm to exist?");
        if (x == 0){
            dispose();
            LoginConfig.clean();
        }
    }

    private void searchBookactionPerformed(ActionEvent e) {
        // TODO add your code here
        new SearchBookFrame().setVisible(true);
    }

    private void subscribeActionPerformed(ActionEvent e) {
        // TODO add your code here
        new BorrowBookFrame().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        userNameMenu = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        label1 = new JLabel();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u9986.png")).getImage());
        setTitle("MainFrame");
        var contentPane = getContentPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //======== menuBar1 ========
        {

            //======== userNameMenu ========
            {
                userNameMenu.setText("UserName");
                userNameMenu.setFont(userNameMenu.getFont().deriveFont(userNameMenu.getFont().getSize() + 5f));
                userNameMenu.setBackground(new Color(0x009999));
                userNameMenu.setForeground(Color.orange);
                userNameMenu.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237\u7ba1\u7406.png")));

                //---- menuItem1 ----
                menuItem1.setText("PassWord");
                menuItem1.setIcon(new ImageIcon(getClass().getResource("/images/\u53d8\u66f4\u5bc6\u7801.png")));
                menuItem1.addActionListener(e -> PasswordactionPerformed(e));
                userNameMenu.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("My Bookshelf");
                menuItem2.setIcon(new ImageIcon(getClass().getResource("/images/\u4e66\u67b6.png")));
                menuItem2.addActionListener(e -> MyBookShelf(e));
                userNameMenu.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("Log Out");
                menuItem3.setIcon(new ImageIcon(getClass().getResource("/images/\u9000\u51fa.png")));
                menuItem3.addActionListener(e -> logoutActionPerformed(e));
                userNameMenu.add(menuItem3);
            }
            menuBar1.add(userNameMenu);

            //======== menu2 ========
            {
                menu2.setText("Book Manage");
                menu2.setFont(menu2.getFont().deriveFont(menu2.getFont().getSize() + 5f));
                menu2.setBackground(new Color(0x3366ff));
                menu2.setIcon(new ImageIcon(getClass().getResource("/images/\u4e66\u7c4d\u7ba1\u7406.png")));

                //---- menuItem4 ----
                menuItem4.setText("Search Books");
                menuItem4.setIcon(new ImageIcon(getClass().getResource("/images/\u641c\u7d22\u5c0f.png")));
                menuItem4.addActionListener(e -> searchBookactionPerformed(e));
                menu2.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("Subscrib Books");
                menuItem5.setIcon(new ImageIcon(getClass().getResource("/images/\u8ba2\u9605.png")));
                menuItem5.addActionListener(e -> subscribeActionPerformed(e));
                menu2.add(menuItem5);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 21));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/mainFrameBG.jpg")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );
        fillName();
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu userNameMenu;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
