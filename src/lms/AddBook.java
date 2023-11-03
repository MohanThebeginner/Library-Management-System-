package lms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBook extends JFrame implements ActionListener {

    int x = 80;
    int txtX = 250;
    int txtWidth = 200;
    int txtHeight = 40;

    Font font = new Font("Tahoma", Font.BOLD,20);
    Font fontTxt = new Font("Tahoma", Font.PLAIN,20);
    JButton add,add2;

    JComboBox bldGrp;
    JTextField bookname,author , bookno,publisher,quantity;
    AddBook(){
        setSize(600,500);

        JLabel l1  = new JLabel("Book name");
        l1.setBounds(x,70,150,40);
        l1.setFont(font);
        add(l1);

        JLabel l2  = new JLabel("Book No");
        l2.setBounds(x,130,150,40);
        l2.setFont(font);
        add(l2);

        JLabel l3  = new JLabel("Author");
        l3.setBounds(x,190,150,40);
        l3.setFont(font);
        add(l3);


        JLabel l5  = new JLabel("Quantity");
        l5.setBounds(x,250,150,40);
        l5.setFont(font);
        add(l5);


        bookname = new JTextField();
        bookname.setBounds(txtX, 70,  txtWidth,txtHeight);
        bookname.setFont(fontTxt);
        add(bookname);

        bookno = new JTextField();
        bookno.setBounds(txtX, 130,  txtWidth,txtHeight);
        bookno.setFont(fontTxt);
        add(bookno);

        author = new JTextField();
        author.setBounds(txtX, 190,  txtWidth,txtHeight);
        author.setFont(fontTxt);
        add(author);


        quantity= new JTextField();
        quantity.setBounds(txtX, 250,  txtWidth,txtHeight);
        quantity.setFont(fontTxt);
        add(quantity);

        ButtonGroup btn = new ButtonGroup();

        add = new JButton("CONFIRM");
        add.setBounds(300,380,150,70);
        add.setFont(font);
        add.addActionListener(this);
        add(add);

        ButtonGroup btn2 = new ButtonGroup();

        add2 = new JButton("CANCEL");
        add2.setBounds(150,380,150,70);
        add2.setFont(font);
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
            String quantity = this.quantity.getText();


            conn c = new conn();

            String query = "insert into book_details (Name,Sr, Author, Quantity) values ('"+bookname+"','"+bookno+"', '"+author+"','"+quantity+"');";

            try{
                c.l.executeUpdate(query);
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
        new AddBook();
    }
}
