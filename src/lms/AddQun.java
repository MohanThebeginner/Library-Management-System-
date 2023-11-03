package lms;



import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddQun extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField gr, attendance;
    JButton display , submit, c2;
    JScrollPane sp1;
    JTable details;


    Font f1 = new Font("Tahoma", Font.PLAIN, 22);
    AddQun(){
        setSize(650,600);

        l1 = new JLabel("Enter Book Sr no.");
        l1.setBounds(80,60,200,50);
        l1.setFont(f1);
        add(l1);

        gr = new JTextField();
        gr.setBounds(265,60,170,50);
        gr.setFont(f1);
        add(gr);

        display = new JButton("Display");
        display.setBounds(450, 60, 150,50);
        display.addActionListener(this);
        display.setFont(f1);
        add(display);

        sp1 = new JScrollPane();
        sp1.setBounds(70,200,500,80);
        add(sp1);

        details = new JTable();
        details.setRowHeight(40);
        sp1.setViewportView(details);
        details.setFont(f1);

        JTableHeader th1 = details.getTableHeader();
        th1.setFont(f1);
        th1.setBackground(Color.decode("#96e37b"));


        l2 = new JLabel("Update Book Quantity");
        l2.setFont(f1);
        l2.setBounds(80,350,250,50);
        add(l2);

        attendance = new JTextField();
        attendance.setBounds(320,350,120,50);
        attendance.setFont(f1);
        add(attendance);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setBounds(250,450,150,50);
        submit.setFont(f1);
        add(submit);

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
        UIManager.put("OptionPane.messageFont", f1);

        String gr = this.gr.getText();

        if(ae.getSource()==display){
            conn c = new conn();
            String query1 = "select Sr, Name ,Author from book_details where Sr = '"+gr+"';";
            try{
                ResultSet rs1 = c.l.executeQuery(query1);
                details.setModel(DbUtils.resultSetToTableModel(rs1));
            }catch (Exception e){
                System.out.println(e);
            }
        }

        if(ae.getSource()==submit){
            String attendance = this.attendance.getText();

            conn c = new conn();
            String query2 = "update book_details set Quantity = '"+attendance+"' where Sr = '"+gr+"';";
            try{
                c.l.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Quantity updated successfully!");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

        if(ae.getSource()==c2){
            new trmenu();
            setVisible(false);
        }


        }



    public static void main(String[] args) {
        new AddQun();
    }
}
