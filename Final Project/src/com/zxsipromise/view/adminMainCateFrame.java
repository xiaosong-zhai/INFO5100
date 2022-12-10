/*
 * Created by JFormDesigner on Thu Dec 08 04:16:03 PST 2022
 */

package com.zxsipromise.view;

import java.awt.event.*;
import com.zxsipromise.Dao.AdminDao;
import com.zxsipromise.Dao.UserDao;
import com.zxsipromise.model.BookAndBookType;
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
public class adminMainCateFrame extends JFrame {
    public adminMainCateFrame() {
        initComponents();
    }

    public void fillTable(String bookTypeName){
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        //search data
        List<BookType> b = AdminDao.listBookType(bookTypeName);
        for (BookType book2 : b){
            Vector v = new Vector<>();
            v.add(book2.getId());
            v.add(book2.getBookTypeName());
            v.add(book2.getBookTypeDesc());
            dtm.addRow(v);
        }
    }

    private void searchActionPerformed(ActionEvent e) {
        // TODO add your code here
        String BookTypeName = this.searchText.getText();
        fillTable(BookTypeName);

    }

    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        cateIdText.setText(String.valueOf(table1.getValueAt(row,0)));
        cateNameText.setText((String) table1.getValueAt(row,1));
        cateDescText.setText((String) table1.getValueAt(row,2));
    }

    private void modifyActionPerformed(ActionEvent e) {
        // TODO add your code here
        String bookTypeName = this.cateNameText.getText();
        String bookTypeDesc = this.cateDescText.getText();
        String id = cateIdText.getText();
        int btid = Integer.parseInt(id);
        if (StringUtils.isEmpty(bookTypeName)){
            JOptionPane.showMessageDialog(null,"cateName is empty");
            return;
        }
        if (StringUtils.isEmpty(bookTypeDesc)){
            JOptionPane.showMessageDialog(null,"cateDesc is empty");
            return;
        }
        int i = AdminDao.updateBookType(bookTypeName,bookTypeDesc,btid);
        if (i > 0){
            JOptionPane.showMessageDialog(null,"Modify Successfully");
            reset();
            fillTable("");
        }else {
            JOptionPane.showMessageDialog(null,"Modify Failed");
        }
    }

    public void reset(){
        this.cateIdText.setText("");
        this.cateNameText.setText("");
        this.cateDescText.setText("");
    }

    private void deleteActionPerformed(ActionEvent e) {
        // TODO add your code here
        String id = this.cateIdText.getText();
        int bookTypeid = Integer.parseInt(id);
        int i = AdminDao.deleteBook(bookTypeid);
        int j = AdminDao.deleteBookType(bookTypeid);
        if (j > 0){
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
        searchText = new JTextField();
        searchButton = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        cateIdText = new JTextField();
        cateNameText = new JTextField();
        cateDescText = new JTextField();
        modifyButton = new JButton();
        deleteButton = new JButton();

        //======== this ========
        setTitle("Maintain Category");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Search");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));

        //---- searchButton ----
        searchButton.setText("Search");
        searchButton.addActionListener(e -> searchActionPerformed(e));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, "", null},
                    {null, null, null},
                },
                new String[] {
                    "ID", "Category Name", "Category Desc"
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
        label2.setText("Category ID");

        //---- label3 ----
        label3.setText("Category Name");

        //---- label4 ----
        label4.setText("Category Desc");

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
                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(searchText, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(cateIdText, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cateDescText, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(modifyButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 33, Short.MAX_VALUE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(cateNameText, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))))))
                    .addGap(51, 51, 51))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cateIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cateNameText, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                    .addGap(4, 4, 4)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cateDescText, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addComponent(modifyButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        fillTable("");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField searchText;
    private JButton searchButton;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField cateIdText;
    private JTextField cateNameText;
    private JTextField cateDescText;
    private JButton modifyButton;
    private JButton deleteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
