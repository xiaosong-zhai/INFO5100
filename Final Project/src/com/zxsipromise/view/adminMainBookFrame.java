/*
 * Created by JFormDesigner on Thu Dec 08 04:49:43 PST 2022
 */

package com.zxsipromise.view;

import java.awt.event.*;
import com.zxsipromise.Dao.AdminDao;
import com.zxsipromise.model.Book;
import com.zxsipromise.model.BookType;
import com.zxsipromise.utils.StringUtils;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.util.List;
import java.util.Vector;

/**
 * @author unknown
 */
public class adminMainBookFrame extends JFrame {
    public adminMainBookFrame() {
        initComponents();
    }

    public void reset(){
        this.idText.setText("");
        this.bookNameText.setText("");
        this.priceText.setText("");
        this.authorText.setText("");
        this.bookDescText.setText("");
    }

    public void fillTable(String bookName){
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        List<Book> b = AdminDao.listBook(bookName);
        for (Book book2 : b){
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
        idText.setText(String.valueOf(table1.getValueAt(row,0)));
        bookNameText.setText((String) table1.getValueAt(row,1));
        authorText.setText((String) table1.getValueAt(row,2));
        priceText.setText(String.valueOf((float) table1.getValueAt(row,3)));
        bookDescText.setText((String) table1.getValueAt(row,4));
    }

    private void searchActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookName = this.searchBookText.getText();
        fillTable(bookName);
    }

    private void modifyActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookName = this.bookNameText.getText();
        String author = this.authorText.getText();
        String price = this.priceText.getText();
        String bookDesc = this.bookDescText.getText();
        String id =idText.getText();
        int bid = Integer.parseInt(id);
        if (StringUtils.isEmpty(bookName)){
            JOptionPane.showMessageDialog(null,"bookName is empty");
            return;
        }
        if (StringUtils.isEmpty(author)){
            JOptionPane.showMessageDialog(null,"author is empty");
            return;
        }
        if (StringUtils.isEmpty(this.priceText.getText())){
            JOptionPane.showMessageDialog(null,"Price is empty");
            return;
        }
        if (StringUtils.isEmpty(bookDesc)){
            JOptionPane.showMessageDialog(null,"author is empty");
            return;
        }
        Book book =new Book(bookName,author,Float.parseFloat(price),bookDesc,bid);
        int i = AdminDao.updateBook(book);
        if (i > 0){
            JOptionPane.showMessageDialog(null,"Modify Successfully");
            reset();
            fillTable("");
        }else {
            JOptionPane.showMessageDialog(null,"Modify Failed");
        }

    }

    private void deleteActionPerformed(ActionEvent e) {
        // TODO add your code here
        String id = this.idText.getText();
        int bookId = Integer.parseInt(id);
        int i = AdminDao.deleteBook2(bookId);
        if (i > 0){
            JOptionPane.showMessageDialog(null,"Delete Successfully");
            reset();
            fillTable("");
        }else {
            JOptionPane.showMessageDialog(null,"Modify Failed");
            reset();
        }
    }

    

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        searchBookText = new JTextField();
        searchButton = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        idText = new JTextField();
        authorText = new JTextField();
        bookNameText = new JTextField();
        priceText = new JTextField();
        bookDescText = new JTextField();
        modifyButton = new JButton();
        deleteButton = new JButton();

        //======== this ========
        setTitle("Maintain Book");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Search BookName");

        //---- searchButton ----
        searchButton.setText("Search");
        searchButton.addActionListener(e -> searchActionPerformed(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setName("Maintain Book");

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, "", "", ""},
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
                    "ID", "BookName", "Author", "Price", "BookDesc"
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

        //---- label2 ----
        label2.setText("ID");

        //---- label3 ----
        label3.setText("Author");

        //---- label4 ----
        label4.setText("BookName");

        //---- label5 ----
        label5.setText("Price");

        //---- label6 ----
        label6.setText("BookDesc");

        //---- modifyButton ----
        modifyButton.setText("Modify");
        modifyButton.addActionListener(e -> modifyActionPerformed(e));

        //---- deleteButton ----
        deleteButton.setText("Delete");
        deleteButton.addActionListener(e -> deleteActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(modifyButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                            .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bookDescText))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(searchBookText, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(authorText, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(idText, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(63, 63, 63)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(priceText, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))))
                            .addGap(0, 20, Short.MAX_VALUE)))
                    .addContainerGap(20, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBookText, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(modifyButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        fillTable("");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField searchBookText;
    private JButton searchButton;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField idText;
    private JTextField authorText;
    private JTextField bookNameText;
    private JTextField priceText;
    private JTextField bookDescText;
    private JButton modifyButton;
    private JButton deleteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
