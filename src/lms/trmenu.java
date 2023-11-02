package lms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class trmenu extends JFrame implements ActionListener {

    JButton AddBook, modifyBooks, addQun, IB, nbr, cngp,addLib;

    int x = 225;

    trmenu() {
        setSize(600, 600);

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

//        cngp = new JButton("CHANGE PRICE");
//        cngp.setBounds(x, 400, 150, 50);
//        cngp.addActionListener(this);
//        add(cngp);

        addLib= new JButton("ADD LIBRARIAN");
        addLib.setBounds(x, 400, 150, 50);
        addLib.addActionListener(this);
        add(addLib);

        ;
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
        }
        if (ae.getSource() == addQun) {
            new AddQun();
        }
        if (ae.getSource() == modifyBooks) {
            new RBooks();
        }
        if (ae.getSource() == IB) {
            new IB();
        }
        if (ae.getSource() == cngp) {
            new cngp();
        }
        if (ae.getSource() == addLib) {
            new addLib();

        }
    }
}
