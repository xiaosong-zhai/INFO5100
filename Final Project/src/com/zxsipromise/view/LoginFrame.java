/*
 * Created by JFormDesigner on Sat Dec 03 19:57:47 PST 2022
 */

package com.zxsipromise.view;

//import com.zxsipromise.Dao.UserDao;
import com.zxsipromise.Dao.UserDao;
import com.zxsipromise.model.User;
import com.zxsipromise.utils.LoginConfig;
import com.zxsipromise.utils.StringUtils;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author xiaosong zhai
 */
public class LoginFrame extends JFrame {
    public LoginFrame() {
        initComponents();
    }

    private void Register(ActionEvent e) {
        // TODO add your code here
        dispose();
        new RegisterFrame().setVisible(true);
    }

    private void Reset(ActionEvent e) {
        // TODO add your code here
        reset();
    }
    public void reset(){
        this.UserNameText.setText("");
        this.passwordTest.setText("");
    }

    private void Login(ActionEvent e) {
        // TODO add your code here
        String name = this.UserNameText.getText();
        String pwd =  new String(this.passwordTest.getPassword());
        if (StringUtils.isEmpty(name)){
            JOptionPane.showMessageDialog(null,"UserName is empty");
            return;
        }
        if (StringUtils.isEmpty(pwd)){
            JOptionPane.showMessageDialog(null,"Password is empty");
            return;
        }
        String userid = "";
        if (userradioButton.isSelected()){
            //User login
            userid = "0";
            List<User> list = UserDao.login(name,pwd,userid);
            if (list.size() != 0){
                //login success
                dispose();
                LoginConfig.save(new User(name,pwd,userid));
                new MainFrame().setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null,"UserName or Password is not correct");
            }
        }else if (adminradioButton.isSelected()){
            //admin login
            userid = "1";
            List<User> list = UserDao.login(name,pwd,userid);
            if (list.size() != 0){
                //login success
                dispose();
                LoginConfig.save(new User(name,pwd,userid));
                new AdminMainFrame().setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null,"Not found your account");
            }
        }else {
            //not select
            JOptionPane.showMessageDialog(null,"Not select identity");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        UserNameJlabel = new JLabel();
        PassWordJlabel = new JLabel();
        UserNameText = new JTextField();
        Registerbutton = new JButton();
        Loginbutton = new JButton();
        Resetbutton = new JButton();
        IdentityJlabel = new JLabel();
        passwordTest = new JPasswordField();
        userradioButton = new JRadioButton();
        adminradioButton = new JRadioButton();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u9986.png")).getImage());
        setTitle("Login");
        var contentPane = getContentPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //---- label1 ----
        label1.setText("Library Management System");
        label1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 21));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u9986.png")));

        //---- UserNameJlabel ----
        UserNameJlabel.setText("UserName:");
        UserNameJlabel.setFont(UserNameJlabel.getFont().deriveFont(UserNameJlabel.getFont().getSize() + 2f));
        UserNameJlabel.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237.png")));

        //---- PassWordJlabel ----
        PassWordJlabel.setText("PassWord :");
        PassWordJlabel.setFont(PassWordJlabel.getFont().deriveFont(PassWordJlabel.getFont().getSize() + 2f));
        PassWordJlabel.setIcon(new ImageIcon(getClass().getResource("/images/\u5bc6\u7801.png")));

        //---- Registerbutton ----
        Registerbutton.setText("Register");
        Registerbutton.setIcon(new ImageIcon(getClass().getResource("/images/\u6ce8\u518c.png")));
        Registerbutton.addActionListener(e -> Register(e));

        //---- Loginbutton ----
        Loginbutton.setText("Login");
        Loginbutton.setIcon(new ImageIcon(getClass().getResource("/images/ID\u767b\u5f55.png")));
        Loginbutton.addActionListener(e -> Login(e));

        //---- Resetbutton ----
        Resetbutton.setText("Reset");
        Resetbutton.setIcon(new ImageIcon(getClass().getResource("/images/\u91cd\u5236.png")));
        Resetbutton.addActionListener(e -> Reset(e));

        //---- IdentityJlabel ----
        IdentityJlabel.setText("Identity     :");
        IdentityJlabel.setFont(IdentityJlabel.getFont().deriveFont(IdentityJlabel.getFont().getSize() + 2f));
        IdentityJlabel.setIcon(new ImageIcon(getClass().getResource("/images/\u8eab\u4efd.png")));

        //---- userradioButton ----
        userradioButton.setText("User");

        //---- adminradioButton ----
        adminradioButton.setText("Admin");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(UserNameJlabel, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addComponent(PassWordJlabel)
                                        .addComponent(IdentityJlabel, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(UserNameText)
                                        .addComponent(passwordTest, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(userradioButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(Registerbutton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Loginbutton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(Resetbutton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(adminradioButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(54, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(label1)
                    .addGap(77, 77, 77)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(UserNameText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addComponent(UserNameJlabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(PassWordJlabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordTest, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(IdentityJlabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(userradioButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminradioButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Resetbutton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Registerbutton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Loginbutton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(userradioButton);
        buttonGroup1.add(adminradioButton);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel UserNameJlabel;
    private JLabel PassWordJlabel;
    private JTextField UserNameText;
    private JButton Registerbutton;
    private JButton Loginbutton;
    private JButton Resetbutton;
    private JLabel IdentityJlabel;
    private JPasswordField passwordTest;
    private JRadioButton userradioButton;
    private JRadioButton adminradioButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
