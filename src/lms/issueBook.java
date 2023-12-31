package lms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class issueBook extends JFrame implements ActionListener {

    JScrollPane sp1 ;
    JTable attendanceDetails ;
    JLabel l1 , chupaRustom;
    JButton addUpdate , defaulters , refresh;

    Font font = new Font("Tahoma", Font.PLAIN, 20);
    issueBook(){
        setSize(1000,700);

        l1  = new JLabel("BOOK SHOP");
        l1.setBounds(400,50,400,100);
        l1.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 38));
        l1.setForeground(Color.YELLOW);
        add(l1);

        chupaRustom = new JLabel("Book List");
        chupaRustom.setBounds(400,150,150,50);
        chupaRustom.setFont(new Font("Tahoma", Font.ITALIC, 24));
        chupaRustom.setForeground(Color.YELLOW);
        add(chupaRustom);
        chupaRustom.setVisible(false);

        sp1 = new JScrollPane();
        sp1.setBounds(400, 200,500,400);
        add(sp1);

        attendanceDetails = new JTable();
        sp1.setViewportView(attendanceDetails);
        attendanceDetails.setFont(font);
        attendanceDetails.setRowHeight(40);

        JTableHeader th1 = attendanceDetails.getTableHeader();
        th1.setFont(font);
        th1.setBackground(Color.decode("#96e37b"));

        getDetails();

        addUpdate = new JButton("Add Book");
        addUpdate.setBounds(60,200, 200,50);
        addUpdate.setFont(font);
        addUpdate.addActionListener(this);
        add(addUpdate);

        defaulters = new JButton("Display");
        defaulters.setBounds(60,350,200,50);
        defaulters.setFont(font);
        defaulters.addActionListener(this);
        add(defaulters);

        refresh = new JButton("Refresh");
        refresh.setBounds(60,500,200,50);
        refresh.setFont(font);
        refresh.addActionListener(this);
        add(refresh);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/gray.png"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(300,50,460,100);
        add(i3);

        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("images/b2.jpg"));
        JLabel i4 = new JLabel(i2);
        i4.setBounds(0,0,1000,700);
        add(i4);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==defaulters){
//            String cutoff =  JOptionPane.showInputDialog("Enter Defaulter CutOff");
            conn c = new conn();
            String query2 = "select Sr no, Name , Author from book_details  ";
            try {
                ResultSet defaultersRs = c.l.executeQuery(query2);
                attendanceDetails.setModel(DbUtils.resultSetToTableModel(defaultersRs));
                chupaRustom.setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }

        }

        if(ae.getSource()==refresh){
            getDetails();
            chupaRustom.setVisible(false);
        }

        if(ae.getSource()==addUpdate){
            new buyBook();
            this.setVisible(false);
        }
    }

    void getDetails(){
        conn c = new conn();
        String query = "select Sr, Name , Author from book_details;";
        try{
            ResultSet rs = c.l.executeQuery(query) ;
            attendanceDetails.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new issueBook();
    }
}