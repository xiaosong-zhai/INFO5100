/*
 * Created by JFormDesigner on Wed Dec 07 21:28:46 PST 2022
 */

package com.zxsipromise.view;

import java.awt.event.*;
import com.zxsipromise.Dao.UserDao;
import com.zxsipromise.model.Book;
import com.zxsipromise.model.BookAndBorrow;
import com.zxsipromise.model.User;
import com.zxsipromise.utils.LoginConfig;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.beans.PropertyVetoException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.*;

/**
 * @author xiaosong zhai
 */
public class MyBookshelf extends JFrame {
    public MyBookshelf() {
        initComponents();
    }
    public void fillTabel(){
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        //search data
        List<String> reader = LoginConfig.reader();
        String UserName = reader.get(0);
        User u = UserDao.selectUname(UserName);
        List<BookAndBorrow> b = UserDao.listBook(u.getId());
        for (BookAndBorrow book2 : b){
            Vector v = new Vector<>();
            v.add(dtm.getRowCount() + 1);
            v.add(book2.getBookName());
            v.add(book2.getAuthor());
            v.add(book2.getPrice());
            v.add(book2.getBtime());
            dtm.addRow(v);
        }
    }

    public void reset(){
        this.bookNameText.setText("");
        this.AuthorText.setText("");
        this.PriceText.setText("");
        this.BorrowDateText.setText("");
    }

    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        bookNameText.setText((String) table1.getValueAt(row,1));
        AuthorText.setText((String) table1.getValueAt(row,2));
        PriceText.setText(String.valueOf((float) table1.getValueAt(row,3)));
        BorrowDateText.setText(String.valueOf((Date) table1.getValueAt(row,4)));
    }

    private void returnActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookName = this.bookNameText.getText();
        Book b = UserDao.selectBookId(bookName);
        int bookid = b.getId();
        List<String> reader = LoginConfig.reader();
        String name = reader.get(0);
        User u = UserDao.selectUname(name);
        int userid = u.getId();
        int i = UserDao.updateIsFlag(bookid);
        if (i > 0){
            int j = UserDao.updateRtime(userid,bookid);
            if (j > 0){
                JOptionPane.showMessageDialog(null,"Return Successfully");
                fillTabel();
                reset();
            }else {
                JOptionPane.showMessageDialog(null,"Return Failed");
            }
        }else {
            JOptionPane.showMessageDialog(null,"Return Failed");
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label4 = new JLabel();
        bookNameText = new JTextField();
        label5 = new JLabel();
        PriceText = new JTextField();
        AuthorText = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        BorrowDateText = new JTextField();
        button1 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("MyBookshelf");
        setResizable(true);
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, "", ""},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, "", "", null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "ID", "BookName", "Author", "Price", "BorrowDate"
                }
            ));
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    table1MousePressed(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- label4 ----
        label4.setText("BookName");

        //---- label5 ----
        label5.setText("Price");

        //---- label2 ----
        label2.setText("Author");

        //---- label3 ----
        label3.setText("Borrow");

        //---- button1 ----
        button1.setText("Return Book");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 3f));
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u56fe\u4e66\u5f52\u8fd8\u4e2d.png")));
        button1.addActionListener(e -> returnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label4)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(PriceText, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(bookNameText, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addGap(70, 70, 70)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AuthorText))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BorrowDateText, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(197, 197, 197)
                            .addComponent(button1)))
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(AuthorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(43, 43, 43)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(label3)
                        .addComponent(BorrowDateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(PriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23))
        );
        pack();
        fillTabel();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label4;
    private JTextField bookNameText;
    private JLabel label5;
    private JTextField PriceText;
    private JTextField AuthorText;
    private JLabel label2;
    private JLabel label3;
    private JTextField BorrowDateText;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
