package lms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
public class addLib extends JFrame implements ActionListener {

    int x = 40;
    int txtX = 250;
    int txtWidth = 250;
    int txtHeight = 40;

    Font font = new Font("Tahoma", Font.BOLD,14);
    Font fontTxt = new Font("Tahoma", Font.PLAIN,18);

    JButton add,add2;


    JComboBox bldGrp;
    JTextField name,email,password,contact,address,city;
    addLib(){
        setSize(600,700);
        JLabel l0 = new JLabel("Add Librarin");
        l0.setBounds(200,10,180,40);
        l0.setForeground(Color.BLUE);
        l0.setFont(new Font("Tahoma",Font.BOLD,26));
        add(l0);


        JLabel l1  = new JLabel("Name");
        l1.setBounds(x,70,150,40);
        l1.setFont(font);
        add(l1);

        JLabel l2  = new JLabel("Password");
        l2.setBounds(x,130,150,40);
        l2.setFont(font);
        add(l2);

        JLabel l3  = new JLabel("E-Mail");
        l3.setBounds(x,190,150,40);
        l3.setFont(font);
        add(l3);

        JLabel l4  = new JLabel("Contact");
        l4.setBounds(x,250,150,40);
        l4.setFont(font);
        add(l4);

        JLabel l5  = new JLabel("Address");
        l5.setBounds(x,310,150,40);
        l5.setFont(font);
        add(l5);

//        JLabel l6  = new JLabel("City");
//        l6.setBounds(x,370,150,40);
//        l6.setFont(font);
//        add(l6);

        name = new JTextField();
        name.setBounds(txtX, 70,  txtWidth,txtHeight);
        name.setFont(fontTxt);
        add(name);

        password = new JPasswordField();
        password.setBounds(txtX,130, txtWidth,txtHeight);
        add(password);

        email = new JTextField();
        email.setBounds(txtX, 190,  txtWidth,txtHeight);
        email.setFont(fontTxt);
        add(email);


        contact = new JTextField();
        contact.setBounds(txtX, 250,  txtWidth,txtHeight);
        contact.setFont(fontTxt);
        add(contact);

        address = new JTextField();
        address.setBounds(txtX, 310,  txtWidth,txtHeight);
        address.setFont(fontTxt);
        add(address);


//        city = new JTextField();
//        city.setBounds(txtX, 370,  txtWidth,txtHeight);
//        city.setFont(fontTxt);
//        add(city);

        ButtonGroup btn = new ButtonGroup();

        add = new JButton("Add Librarian");
        add.setBounds(200,580,150,70);
        add.setFont(font);
        add.addActionListener(this);
        add(add);

        ButtonGroup btn2 = new ButtonGroup();

        add2 = new JButton("CANCEL");
        add2.setBounds(200,780,150,70);
        add2.setFont(font);
        add2.addActionListener(this);
        add(add2);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==add){
            String name =  this.name.getText();
            String password = this.password.getText();
            String email = this.email.getText();
            String contact = this.contact.getText();
//            String city = this.city.getText();
            String address = this.address.getText();




            conn c = new conn();

            String query = "insert into login (username,password,email,contact,address) values ('"+name+"','"+password+"','"+email+"', '"+contact+"','"+address+"');";

            try{
                c.l.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Added Successfully!");
            }catch (Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Some error occured :(");
            }




        }

    }


    public static void main(String[] args) {
        new addLib();
    }
}
