/*
 * Created by JFormDesigner on Thu Dec 08 04:07:23 PST 2022
 */

package com.zxsipromise.view;

import com.zxsipromise.Dao.AdminDao;
import com.zxsipromise.Dao.UserDao;
import com.zxsipromise.model.BookType;
import com.zxsipromise.utils.StringUtils;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class adminAddCateFrame extends JFrame {
    public adminAddCateFrame() {
        initComponents();
    }

    private void resetActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.bookCateText.setText("");
        this.cateDescText.setText("");
    }

    private void confirmActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookTypeName = this.bookCateText.getText();
        String bookTypeDesc = this.cateDescText.getText();
        if (StringUtils.isEmpty(bookTypeName)){
            JOptionPane.showMessageDialog(null,"Book Category is empty");
            return;
        }
        if (StringUtils.isEmpty(bookTypeDesc)){
            JOptionPane.showMessageDialog(null,"Category Desc is empty");
            return;
        }
        BookType b = AdminDao.selectBookTypeName(bookTypeName);
        if (b == null){
            int i = AdminDao.addBookType(bookTypeName,bookTypeDesc);
            if (i > 0){
                JOptionPane.showMessageDialog(null,"Add Successfully");
                this.bookCateText.setText("");
                this.cateDescText.setText("");
            }else {

            }
        }else {
            JOptionPane.showMessageDialog(null,"This category already exists");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        cateDescText = new JTextField();
        bookCateText = new JTextField();
        confirmButton = new JButton();
        resetButton = new JButton();

        //======== this ========
        setTitle("AddCategory");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Book Category");

        //---- label2 ----
        label2.setText("Category Desc");

        //---- confirmButton ----
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(e -> confirmActionPerformed(e));

        //---- resetButton ----
        resetButton.setText("Reset");
        resetButton.addActionListener(e -> resetActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(confirmButton, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(cateDescText, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookCateText, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE))
                        .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(38, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookCateText, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addGap(51, 51, 51)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cateDescText, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(confirmButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                    .addGap(54, 54, 54))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField cateDescText;
    private JTextField bookCateText;
    private JButton confirmButton;
    private JButton resetButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
