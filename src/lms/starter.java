package lms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class starter extends JFrame implements ActionListener {

    JButton login;
    JButton studentlogin;

    starter(){
        setSize(1000,600);

        JLabel l1 = new JLabel("Library Management System");
        //l1.setBackground();
        l1.setBounds(280,50,500,100);
        l1.setFont(new Font("Tahoma", Font.BOLD , 32));
        add(l1);


        login = new JButton("LOGIN");
        login.setBounds(700,400,150,80);
        login.setBackground(Color.cyan);
        login.addActionListener(this);
        add(login);

        studentlogin = new JButton("STUDENT LOGIN");
        studentlogin.setBounds(160,400,150,80);
        studentlogin.setBackground(Color.green);
        studentlogin.addActionListener(this);
        add(studentlogin);


        setLayout(null);
        setLocationRelativeTo(null);//takes the frame to center
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            new login();
            setVisible(false);
        }
        if(ae.getSource()==studentlogin){
            new studentlogin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new starter();
    }
}
