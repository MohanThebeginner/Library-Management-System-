package lms;

//import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class RBooks extends JFrame implements ActionListener {

    int x = 80;
    int txtX = 250;
    int txtWidth = 200;
    int txtHeight = 40;

    Font font = new Font("Tahoma", Font.BOLD,20);
    Font fontTxt = new Font("Tahoma", Font.PLAIN,20);

    JButton add,add2,c2;
    JTextField bookname, bookno, author;
    RBooks(){
        setSize(600,320);

        JLabel l1  = new JLabel("Book name");
        l1.setBounds(x,50,150,40);
        l1.setFont(font);
        add(l1);

        JLabel l2  = new JLabel("Book No");
        l2.setBounds(x,100,150,40);
        l2.setFont(font);
        add(l2);

        JLabel l3  = new JLabel("Author");
        l3.setBounds(x,150,150,40);
        l3.setFont(font);
        add(l3);

        bookname = new JTextField();
        bookname.setBounds(txtX, 50,  txtWidth,txtHeight);
        bookname.setFont(fontTxt);
        add(bookname);

        bookno = new JTextField();
        bookno.setBounds(txtX, 100,  txtWidth,txtHeight);
        bookno.setFont(fontTxt);
        add(bookno);

        author = new JTextField();
        author.setBounds(txtX, 150,  txtWidth,txtHeight);
        author.setFont(fontTxt);
        add(author);

        ButtonGroup btn = new ButtonGroup();

        add = new JButton("CONFIRM");
        add.setBounds(300,220,120,50);
        add.setFont(new Font("Tahoma", Font.BOLD , 15));
        add.addActionListener(this);
        add(add);

        ButtonGroup btn2 = new ButtonGroup();

        add2 = new JButton("CANCEL");
        add2.setBounds(100,220,120,50);
        add2.setFont(new Font("Tahoma",Font.BOLD,15));
        add2.addActionListener(this);
        add(add2);



        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==add){
            String bookname =  this.bookname.getText();
            String bookno = this.bookno.getText();
            String author = this.author.getText();

            conn c = new conn();

            String query = "update book_details set Name='"+bookname+"' where Sr = '"+bookno+"';";
            String query2 = "update book_details set Author='"+author+"' where Sr = '"+bookno+"';";

            try{
                c.l.executeUpdate(query);
                c.l.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Data Added Successfully!");
            }catch (Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Some error occured :(");
            }




        }
        if(ae.getSource()==add2){
            new trmenu();
            setVisible(false);
        }


    }


    public static void main(String[] args) {
        new RBooks();
    }
}
