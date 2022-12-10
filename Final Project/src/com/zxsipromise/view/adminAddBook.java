/*
 * Created by JFormDesigner on Thu Dec 08 04:31:28 PST 2022
 */

package com.zxsipromise.view;

import com.zxsipromise.Dao.AdminDao;
import com.zxsipromise.model.BookType;
import com.zxsipromise.utils.DButils;
import com.zxsipromise.utils.StringUtils;

import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class adminAddBook extends JFrame {
    public adminAddBook() {
        initComponents();
    }

    private void confrimActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookName = this.bookNameText.getText();
        String author = this.authorText.getText();
        String sex = "";
        if (Male.isSelected()){
            sex = "Male";
        }else {
            sex = "Female";
        }
        BookType b = (BookType) bookTypeComboBox.getSelectedItem();
        int id = b.getId();
        float price = Float.parseFloat(this.priceText.getText());
        String bookDesc = this.bookDescText.getText();
        if (StringUtils.isEmpty(bookName)){
            JOptionPane.showMessageDialog(null,"BookName is empty");
        }
        if (StringUtils.isEmpty(author)){
            JOptionPane.showMessageDialog(null,"Author is empty");
        }
        if (StringUtils.isEmpty(this.priceText.getText())){
            JOptionPane.showMessageDialog(null,"Price is empty");
        }
        int j = AdminDao.addBook(bookName,author,sex,price,bookDesc,id);
        if (j > 0){
            JOptionPane.showMessageDialog(null,"Modify Successfully");
            reset();
        }else {
            JOptionPane.showMessageDialog(null,"Modify Failed");
        }

    }

    private void resetActionPerformed(ActionEvent e) {
        // TODO add your code here
        reset();
    }

    public void reset(){
        this.bookNameText.setText("");
        this.authorText.setText("");
        this.priceText.setText("");
        this.bookDescText.setText("");
    }

    public void fillBookType(){
        List<BookType> listBookTypes = AdminDao.listBookType("");
        for (BookType bookType : listBookTypes){
            String bookTypeName = bookType.getBookTypeName();
            int id = bookType.getId();
            BookType b = new BookType(bookTypeName,id);
            this.bookTypeComboBox.addItem(b);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        Male = new JRadioButton();
        Female = new JRadioButton();
        bookNameText = new JTextField();
        label3 = new JLabel();
        authorText = new JTextField();
        label4 = new JLabel();
        priceText = new JTextField();
        label5 = new JLabel();
        bookTypeComboBox = new JComboBox();
        label6 = new JLabel();
        bookDescText = new JTextField();
        confrimButton = new JButton();
        resetButton = new JButton();

        //======== this ========
        setTitle("Add Book");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("BookName");

        //---- label2 ----
        label2.setText("Author");

        //---- Male ----
        Male.setText("Male");

        //---- Female ----
        Female.setText("Female");

        //---- label3 ----
        label3.setText("Sex");

        //---- label4 ----
        label4.setText("Price");

        //---- label5 ----
        label5.setText("Category");

        //---- label6 ----
        label6.setText("BookDesc");

        //---- confrimButton ----
        confrimButton.setText("Confrim");
        confrimButton.addActionListener(e -> confrimActionPerformed(e));

        //---- resetButton ----
        resetButton.setText("Reset");
        resetButton.addActionListener(e -> resetActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label5, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(Male)
                                    .addGap(18, 18, 18)
                                    .addComponent(Female))
                                .addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
                            .addGap(41, 41, 41)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(authorText, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceText, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(bookTypeComboBox, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookDescText))
                    .addContainerGap(22, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(confrimButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                    .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                    .addGap(42, 42, 42))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Male)
                        .addComponent(Female)
                        .addComponent(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(62, 62, 62)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(confrimButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33))
        );
        fillBookType();
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(Male);
        buttonGroup1.add(Female);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JRadioButton Male;
    private JRadioButton Female;
    private JTextField bookNameText;
    private JLabel label3;
    private JTextField authorText;
    private JLabel label4;
    private JTextField priceText;
    private JLabel label5;
    private JComboBox bookTypeComboBox;
    private JLabel label6;
    private JTextField bookDescText;
    private JButton confrimButton;
    private JButton resetButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
