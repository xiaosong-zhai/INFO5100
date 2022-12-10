/*
 * Created by JFormDesigner on Wed Dec 07 20:16:52 PST 2022
 */

package com.zxsipromise.view;

import com.zxsipromise.Dao.UserDao;
import com.zxsipromise.utils.StringUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        initComponents();
    }

    private void regRegactionPerformed(ActionEvent e) {
        // TODO add your code here
        String name = this.regUserNameText.getText();
        String pwd = new String(this.regPasswordText.getPassword());
        int i = UserDao.reg(name,pwd);
        if (StringUtils.isEmpty(name)){
            JOptionPane.showMessageDialog(null,"UserName is empty");
            return;
        }
        if (StringUtils.isEmpty(pwd)){
            JOptionPane.showMessageDialog(null,"Password is empty");
        }

        if (i > 0){
            //reg success
            dispose();
            new LoginFrame().setVisible(true);
        }else {
            //reg failed
            JOptionPane.showMessageDialog(null,"Register failed");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        regUserNameText = new JTextField();
        regPasswordText = new JPasswordField();
        regRegbutton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //---- label1 ----
        label1.setText("Library Management System");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u9986.png")));

        //---- label2 ----
        label2.setText("Register For Join With Us");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));
        label2.setForeground(Color.pink);

        //---- label3 ----
        label3.setText("UserName:");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u6ce8\u518c.png")));

        //---- label4 ----
        label4.setText("Password:");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));
        label4.setIcon(new ImageIcon(getClass().getResource("/images/\u5bc6\u7801.png")));

        //---- regRegbutton ----
        regRegbutton.setText("Register");
        regRegbutton.setFont(regRegbutton.getFont().deriveFont(regRegbutton.getFont().getSize() + 3f));
        regRegbutton.setIcon(new ImageIcon(getClass().getResource("/images/\u6ce8\u518c\u6ce8\u518c.png")));
        regRegbutton.addActionListener(e -> regRegactionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(regPasswordText, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                .addComponent(regUserNameText, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                .addComponent(regRegbutton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                            .addGap(85, 85, 85))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
                            .addGap(44, 44, 44))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(regUserNameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(regPasswordText)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                    .addComponent(regRegbutton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField regUserNameText;
    private JPasswordField regPasswordText;
    private JButton regRegbutton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
