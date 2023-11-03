package lms;

//import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class IB extends JFrame implements ActionListener {

    int x = 40;
    int txtX = 250;
    int txtWidth = 250;
    int txtHeight = 40;

    Font font = new Font("Tahoma", Font.BOLD,14);
    Font fontTxt = new Font("Tahoma", Font.PLAIN,18);
    
    JButton add,add2,c2;
    JScrollPane sp1;
    JTable details;

   // private Label gr;


   
    JTextField bookid,bookno,bookname,studentid,studentcontact,quantity;
    IB(){
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

    void getDetails(){

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
        new IB();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==c2){
            new trmenu();
            setVisible(false);
        }

    }
}
