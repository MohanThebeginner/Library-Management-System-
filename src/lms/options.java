package lms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class options extends JFrame implements ActionListener {

    JButton issueBook, viewBook, returnBook;

    int x = 225;

    options() {
        setSize(600, 400);


        issueBook = new JButton(" BOOK SHOP");
        issueBook.setBounds(x, 80, 150, 50);
        issueBook.addActionListener(this);
        add(issueBook);

        viewBook = new JButton("VIEW BOOK");
        viewBook.setBounds(x, 160, 150, 50);
        viewBook.addActionListener(this);
        add(viewBook);

        returnBook = new JButton("RETURN BOOK");
        returnBook.setBounds(x, 240, 150, 50);
        returnBook.addActionListener(this);
        add(returnBook);



        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/b7.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,650,400);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new options();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == issueBook) {
            new issueBook();
        }
        if (ae.getSource() == viewBook) {
            new viewDetails();
        }
        if (ae.getSource() == returnBook) {
            new returnBook();
        }

    }
}
