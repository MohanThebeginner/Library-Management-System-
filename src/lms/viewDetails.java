package lms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewDetails extends JFrame implements ActionListener {
    JScrollPane sp1;
    JTable details;

    JButton c2;
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/c3.png"));
        Image img1 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(img1);
        c2 = new JButton(i1);
        c2.setBounds(0,0 , 50,50);
        c2.addActionListener(this);
        add(c2);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==c2){
            new options();
            this.setVisible(false);
        }
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