/*
 * Created by JFormDesigner on Wed Dec 07 01:34:34 PST 2022
 */

package com.zxsipromise.view;

import java.awt.*;
import com.zxsipromise.Dao.UserDao;
import com.zxsipromise.utils.LoginConfig;

import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author xiaosong zhai
 */
public class UpdatePwdFrame extends JFrame {
    public UpdatePwdFrame() {
        initComponents();
    }

    public void reset(){
        OldpasswordField.setText("");
        NewpasswordField.setText("");
        RepasswordField.setText("");
    }

    public void fillName(){
        List<String> reader = LoginConfig.reader();
        this.UserNameText.setText(reader.get(0));
    }

    private void ConfirmactionPerformed(ActionEvent e) {
        // TODO add your code here
                List<String> reader = LoginConfig.reader();
        String password = new String(OldpasswordField.getPassword());
        String Newpassword = new String(NewpasswordField.getPassword());
        String Repassword = new String(RepasswordField.getPassword());
        String name = reader.get(0);
        //confirm
        String oldPwd = reader.get(1);
        if (oldPwd.equals(password)){
            if (Newpassword.equals(Repassword)){
                int i = UserDao.updatePwd(Newpassword,name);
                if (i > 0){
                    JOptionPane.showMessageDialog(null,"Update successfully");
                    reset();
                }
            }else {
                JOptionPane.showMessageDialog(null,"New Passwords do not match");
                reset();
            }
        }else {
                JOptionPane.showMessageDialog(null,"Old Password is not correct");
                reset();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        table = new JDesktopPane();
        label4 = new JLabel();
        label5 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        OldpasswordField = new JPasswordField();
        NewpasswordField = new JPasswordField();
        RepasswordField = new JPasswordField();
        UserNameText = new JTextField();

        //======== this ========
        setVisible(true);
        setResizable(true);
        setTitle("updatePassword");
        var contentPane = getContentPane();

        //======== table ========
        {
            table.setBackground(Color.white);

            //---- label4 ----
            label4.setText("UserName:");
            table.add(label4, JLayeredPane.DEFAULT_LAYER);
            label4.setBounds(70, 35, 80, label4.getPreferredSize().height);

            //---- label5 ----
            label5.setText("Old PassWord :");
            table.add(label5, JLayeredPane.DEFAULT_LAYER);
            label5.setBounds(70, 80, 105, label5.getPreferredSize().height);

            //---- label2 ----
            label2.setText("New PassWord :");
            table.add(label2, JLayeredPane.DEFAULT_LAYER);
            label2.setBounds(70, 125, 105, 20);

            //---- label3 ----
            label3.setText("Re PassWord :");
            table.add(label3, JLayeredPane.DEFAULT_LAYER);
            label3.setBounds(70, 180, 100, label3.getPreferredSize().height);

            //---- button1 ----
            button1.setText("Confirm");
            button1.addActionListener(e -> ConfirmactionPerformed(e));
            table.add(button1, JLayeredPane.DEFAULT_LAYER);
            button1.setBounds(65, 225, 90, 32);

            //---- button2 ----
            button2.setText("Cancel");
            table.add(button2, JLayeredPane.DEFAULT_LAYER);
            button2.setBounds(315, 225, 90, 32);
            table.add(OldpasswordField, JLayeredPane.DEFAULT_LAYER);
            OldpasswordField.setBounds(185, 75, 155, 25);
            table.add(NewpasswordField, JLayeredPane.DEFAULT_LAYER);
            NewpasswordField.setBounds(185, 120, 155, 25);
            table.add(RepasswordField, JLayeredPane.DEFAULT_LAYER);
            RepasswordField.setBounds(185, 170, 155, 25);
            table.add(UserNameText, JLayeredPane.DEFAULT_LAYER);
            UserNameText.setBounds(185, 30, 155, 25);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(table, GroupLayout.Alignment.TRAILING)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(table, GroupLayout.Alignment.TRAILING)
        );
        fillName();
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JDesktopPane table;
    private JLabel label4;
    private JLabel label5;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JPasswordField OldpasswordField;
    private JPasswordField NewpasswordField;
    private JPasswordField RepasswordField;
    private JTextField UserNameText;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
