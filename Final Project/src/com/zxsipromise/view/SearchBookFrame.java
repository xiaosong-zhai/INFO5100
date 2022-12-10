/*
 * Created by JFormDesigner on Thu Dec 08 00:38:48 PST 2022
 */

package com.zxsipromise.view;

import java.awt.event.*;
import com.zxsipromise.Dao.UserDao;
import com.zxsipromise.model.BookAndBookType;
import com.zxsipromise.model.BookAndBorrow;

import java.awt.*;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author xiaosong zhai
 */
public class SearchBookFrame extends JFrame {
    public SearchBookFrame() {
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
            v.add(book2.getBookTypeName());
            v.add(book2.getAuthor());
            v.add(book2.getPrice());
            v.add(book2.getBookDesc());
            dtm.addRow(v);
        }
    }

    private void searchActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookName = this.searchText.getText();
        fillTable(bookName);
    }

    private void resetActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.searchText.setText("");
        fillTable("");
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        searchScroll = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        searchText = new JTextField();
        searchButton = new JButton();
        resetButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== searchScroll ========
        {

            //---- table1 ----
            table1.setFont(table1.getFont().deriveFont(table1.getFont().getStyle() | Font.BOLD));
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                },
                new String[] {
                    "BookID", "BookName", "Category", "Author", "Price", "BookDesc"
                }
            ));
            searchScroll.setViewportView(table1);
        }

        //---- label1 ----
        label1.setText("BookName");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));

        //---- searchButton ----
        searchButton.setText("Search");
        searchButton.setFont(searchButton.getFont().deriveFont(searchButton.getFont().getSize() + 3f));
        searchButton.addActionListener(e -> searchActionPerformed(e));

        //---- resetButton ----
        resetButton.setText("Reset");
        resetButton.setFont(resetButton.getFont().deriveFont(resetButton.getFont().getSize() + 3f));
        resetButton.addActionListener(e -> resetActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(searchScroll, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(searchText, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                        .addComponent(resetButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(58, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(searchScroll, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchText, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        fillTable("");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane searchScroll;
    private JTable table1;
    private JLabel label1;
    private JTextField searchText;
    private JButton searchButton;
    private JButton resetButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
