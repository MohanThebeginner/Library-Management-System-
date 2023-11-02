package lms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;

public class viewDetails extends JFrame {
    JScrollPane sp1;
    JTable details;
    viewDetails(){
        setSize(1600,600);

        sp1 = new JScrollPane();
        sp1.setBounds(10,80,1500,400);
        add(sp1);

        details = new JTable();
        details.setFont(new Font("Tahoma", Font.PLAIN, 14));
        details.setRowHeight(30);
        sp1.setViewportView(details);

        getDetails();

        JTableHeader tb1 = details.getTableHeader();
        tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
        tb1.setBackground(Color.cyan);



        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    void getDetails(){
//        data fetching code
        conn c = new conn();
        String query = "select * from book_details";
        try{
            ResultSet rs = c.l.executeQuery(query);
            details.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new viewDetails();
    }
}