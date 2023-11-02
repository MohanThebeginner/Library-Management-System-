package lms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class buyBook extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField gr, name;
    JButton display , submit, back;
    JScrollPane sp1;
    JTable details;


    Font f1 = new Font("Tahoma", Font.PLAIN, 22);

    private Label Issuedto;
    private Label Name;

    buyBook(){
        setSize(650,600);

        l1 = new JLabel("Enter Book SR No. ");
        l1.setBounds(70,10,250,50);
        l1.setFont(f1);
        add(l1);

        gr = new JTextField();
        gr.setBounds(250,10,120,50);
        gr.setFont(f1);
        add(gr);

        l2 = new JLabel("Enter your Name");
        l2.setBounds(70,90,250,50);
        l2.setFont(f1);
        add(l2);

        name = new JTextField();
        name.setBounds(250,90,120,50);
        name.setFont(f1);
        add(name);


        display = new JButton("Display");
        display.setBounds(400, 60, 150,50);
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


      //  l2 = new JLabel("Update Attendance");
        //l2.setFont(f1);
        //l2.setBounds(80,350,200,50);
        //add(l2);

       // attendance = new JTextField();
      //  attendance.setBounds(320,350,120,50);
        //attendance.setFont(f1);
        //add(attendance);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setBounds(250,450,150,50);
        submit.setFont(f1);
        add(submit);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
//        Image img1 = i1.getImage().getScaledInstance(75,50,Image.SCALE_DEFAULT);
//        i1 = new ImageIcon(img1);
//        back = new JButton(i1);
//        back.setBounds(0,0 , 50,50);
//        back.addActionListener(this);
//        add(back);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        UIManager.put("OptionPane.messageFont", f1); // to set font of MessageDialogue

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
//           String Issuedto = this.Issuedto.getText();
//           String Dayleft = this.Dayleft.getText();
            String Name = this.name.getText();


            conn c = new conn();


            String query4 = "update book_details set Dayleft = 10 where Sr = '"+gr+"';";
            String query3 = "update book_details set Issuedto = '"+Name+"' where Sr = '"+gr+"';";
            String query2 = "update book_details set Quantity = Quantity-1 where Sr = '"+gr+"';";
            try{

                c.l.executeUpdate(query4);
                c.l .executeUpdate(query2);
                c.l.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Book Added successfully!");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

        if(ae.getSource()==back){
            new issueBook();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new buyBook();
    }
}
