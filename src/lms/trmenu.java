package lms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class trmenu extends JFrame implements ActionListener {

    JButton AddBook, modifyBooks, addQun, IB, nbr, cngp,addLib, logout;

    int x = 225;

    trmenu() {
        setSize(600, 700);

        AddBook = new JButton("ADD BOOK");
        AddBook.setBounds(x, 80, 150, 50);
        AddBook.addActionListener(this);
        add(AddBook);

        addQun = new JButton("ADD QUANTITY");
        addQun.setBounds(x, 160, 150, 50);
        addQun.addActionListener(this);
        add(addQun);

        modifyBooks = new JButton("MODIFY BOOKS");
        modifyBooks.setBounds(x, 240, 150, 50);
        modifyBooks.addActionListener(this);
        add(modifyBooks);

        IB = new JButton("BOOK REPORT");
        IB.setBounds(x, 320, 150, 50);
        IB.addActionListener(this);
        add(IB);

        cngp = new JButton("ADD STUDENT");
        cngp.setBounds(x, 400, 150, 50);
        cngp.addActionListener(this);
        add(cngp);

        addLib= new JButton("ADD LIBRARIAN");
        addLib.setBounds(x, 480, 150, 50);
        addLib.addActionListener(this);
        add(addLib);

        logout= new JButton("LOGOUT");
        logout.setBounds(x, 560, 150, 50);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/b8.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,600,700);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new trmenu();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == AddBook) {
            new AddBook();
            this.setVisible(false);
        }
        if (ae.getSource() == addQun) {
            new AddQun();
            this.setVisible(false);
        }
        if (ae.getSource() == modifyBooks) {
            new RBooks();
            this.setVisible(false);
        }
        if (ae.getSource() == IB) {
            new IB();
            this.setVisible(false);
        }
        if (ae.getSource() == cngp) {
            new addStud();
            this.setVisible(false);
        }
        if (ae.getSource() == addLib) {
            new addStud();
            this.setVisible(false);
        }
            if (ae.getSource() == logout) {
                new starter();
                setVisible(false);

            }
        }
    }
