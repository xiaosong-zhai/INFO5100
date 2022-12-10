/*
 * Created by JFormDesigner on Thu Dec 08 01:34:52 PST 2022
 */

package com.zxsipromise.view;

import java.awt.event.*;
import com.zxsipromise.Dao.UserDao;
import com.zxsipromise.model.Book;
import com.zxsipromise.model.BookAndBookType;
import com.zxsipromise.model.User;
import com.zxsipromise.utils.LoginConfig;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.util.List;
import java.util.Vector;

/**
 * @author xiaosong zhai
 */
public class BorrowBookFrame extends JFrame {
    public BorrowBookFrame() {
        initComponents();
    }

    public void fillTable(String bookName){
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        //search data
        List<BookAndBookType> b = UserDao.listBook3(bookName);
        for (BookAndBookType book2 : b){
            Vector v = new Vector<>();
            v.add(book2.getId());
            v.add(book2.getBookName());
            v.add(book2.getAuthor());
            v.add(book2.getPrice());
            v.add(book2.getBookDesc());
            dtm.addRow(v);
        }
    }

    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        bookIDText.setText(String.valueOf((int)table1.getValueAt(row,0)));
        bookNameText.setText((String) table1.getValueAt(row,1));
        authorText.setText((String) table1.getValueAt(row,2));
        PriceText.setText(String.valueOf((float) table1.getValueAt(row,3)));
        bookDescText.setText((String) table1.getValueAt(row,4));
    }

    public void reset(){
        bookIDText.setText("");
        bookNameText.setText("");
        authorText.setText("");
        PriceText.setText("");
        bookDescText.setText("");
    }

    private void subButton(ActionEvent e) {
        // TODO add your code here
        int bookId = Integer.parseInt(this.bookIDText.getText());
        String bookName = this.bookNameText.getText();
        String author = this.authorText.getText();
        float price = Float.parseFloat(this.PriceText.getText());
        String bookDesc = this.bookDescText.getText();
        Book book = UserDao.SelectBook(bookId);
        if (book != null){
            JOptionPane.showMessageDialog(null,"This book has been subscribed");
            reset();
        }else {
            int i = UserDao.borrowBook(bookId);
            if (i > 0){
                List<String> reader = LoginConfig.reader();
                String name = reader.get(0);
                User u = UserDao.selectUname(name);
                int id = u.getId();
                int j = UserDao.insertBorrow(id,bookId);
                if (j > 0){
                    JOptionPane.showMessageDialog(null,"Subscribe successfully");
                    reset();
                }
            }
        }
    }

    private void searchActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookName = this.bookNameText.getText();
        fillTable(bookName);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        bookIDText = new JTextField();
        authorText = new JTextField();
        bookNameText = new JTextField();
        PriceText = new JTextField();
        label5 = new JLabel();
        bookDescText = new JTextField();
        searchButton = new JButton();
        subButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "BookID", "BookName", "Author", "Price", "BookDesc"
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

        //---- label1 ----
        label1.setText("BookID");

        //---- label2 ----
        label2.setText("Author");

        //---- label3 ----
        label3.setText("BookName");

        //---- label4 ----
        label4.setText("Price");

        //---- label5 ----
        label5.setText("BookDesc");

        //---- searchButton ----
        searchButton.setText("Search");
        searchButton.addActionListener(e -> searchActionPerformed(e));

        //---- subButton ----
        subButton.setText("Subscribe");
        subButton.addActionListener(e -> subButton(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bookIDText, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PriceText, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(authorText, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(subButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE))))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(PriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(subButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        fillTable("");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField bookIDText;
    private JTextField authorText;
    private JTextField bookNameText;
    private JTextField PriceText;
    private JLabel label5;
    private JTextField bookDescText;
    private JButton searchButton;
    private JButton subButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
