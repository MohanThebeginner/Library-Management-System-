package lms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class cngp extends JFrame implements ActionListener {

    JScrollPane sp1 ;
    JTable attendanceDetails ;
    JLabel l1 , cR;
    JButton addUpdate , defaulters , refresh;

    Font font = new Font("Tahoma", Font.PLAIN, 20);
    cngp(){
        setSize(1000,700);

        l1  = new JLabel("Book Price Update Section");
        l1.setBounds(280,50,500,100);
        l1.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 32));
        add(l1);

        cR = new JLabel("Costly Books");
        cR.setBounds(400,150,200,50);
        cR.setFont(new Font("Tahoma", Font.ITALIC, 24));
        add(cR);
        cR.setVisible(false);

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

        addUpdate = new JButton("Add / Update");
        addUpdate.setBounds(60,200, 200,50);
        addUpdate.setFont(font);
        addUpdate.addActionListener(this);
        add(addUpdate);

        defaulters = new JButton("Costly Books");
        defaulters.setBounds(60,350,200,50);
        defaulters.setFont(font);
        defaulters.addActionListener(this);
        add(defaulters);

        refresh = new JButton("Refresh");
        refresh.setBounds(60,500,200,50);
        refresh.setFont(font);
        refresh.addActionListener(this);
        add(refresh);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==defaulters){
            String cutoff =  JOptionPane.showInputDialog("Enter Defaulter CutOff");
            conn c = new conn();
            String query2 = "select gr, name , attendance from stud_details where attendance < '"+cutoff+"';";
            try {
                ResultSet defaultersRs = c.l.executeQuery(query2);
                attendanceDetails.setModel(DbUtils.resultSetToTableModel(defaultersRs));
                cR.setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }

        }

        if(ae.getSource()==refresh){
            getDetails();
            cR.setVisible(false);
        }

        if(ae.getSource()==addUpdate){
            new cngp();
            this.setVisible(false);
        }
    }

    void getDetails(){
        conn c = new conn();
        String query = "select gr , name , attendance from stud_details;";
        try{
            ResultSet rs = c.l.executeQuery(query) ;
            attendanceDetails.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new cngp();
    }
}

