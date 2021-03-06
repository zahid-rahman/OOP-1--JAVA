package StudentCourses;

import DatabaseConnection.DataAccess;
import StudentFrame.StudentFrame;
import java.awt.CheckboxGroup;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Courses extends JFrame implements ActionListener {
    DataAccess da = new DataAccess();
    public JCheckBox pl1 = new JCheckBox("Programming Language 1 (C)");
    public JCheckBox pl2 = new JCheckBox("Programming Language 2 (C++)");
    public JCheckBox pl3 = new JCheckBox("Object Oriented Programming 1 (JAVA)");
    public JCheckBox pl4 = new JCheckBox("Object Oriented Programming 2 (C#)");
    public JCheckBox pl5 = new JCheckBox("PHP");
    JButton conf = new JButton("Confirm");
    JButton back = new JButton("Back");
    JButton ref = new JButton("Refresh");
    JLabel l1 = new JLabel("**Please Refresh this page every time you entered");
    JLabel l2 = new JLabel("to see your selected courses");
    CheckboxGroup cg = new CheckboxGroup();
    Container c;
    String passName, passID;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    String s1,s2,s3,s4,s5;
    static int i1,i2,i3,i4,i5;
    
    public Courses(String passName, String passID){
        this.passName = passName;
        this.passID = passID;
        this.setTitle("Courses List");
        this.setBounds(550,200,380,400);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        c = this.getContentPane();
        c.setLayout(null);
        pl1.setBounds(10,10,200,30);
        pl2.setBounds(10,50 ,220 ,30);
        pl3.setBounds(10,85,280,30);
        pl4.setBounds(10, 120, 280, 30);
        pl5.setBounds(10,155,100,30);
        conf.setBounds(10,190,150,40);
        back.setBounds(170,190,150,40);
        ref.setBounds(110,240,150,40);
        l1.setBounds(10,270,300,50);
        l2.setBounds(10,300,200,50);
        
        c.add(pl1);
        c.add(pl2);
        c.add(pl3);
        c.add(pl4);
        c.add(pl5);
        c.add(conf);
        c.add(back);
        c.add(ref);
        c.add(l1);
        c.add(l2);
        
        
        conf.addActionListener(this);
        back.addActionListener(this);
        pl1.addActionListener(this);
        pl2.addActionListener(this);
        pl3.addActionListener(this);
        pl4.addActionListener(this);
        pl5.addActionListener(this);
        ref.addActionListener(this);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == back){
            StudentFrame sf = new StudentFrame(passName, passID);
            dispose();
        }
        else if(ae.getSource() == conf){
            
            String sql5 = "select course1, course2, course3, course4, course5 from st_course where id='"+passID+"'";
            rs = da.getData(sql5);
            try {
                while(rs.next()){
                    String s1 = rs.getString("course1");
                    String s2 = rs.getString("course2");
                    String s3 = rs.getString("course3");
                    String s4 = rs.getString("course4");
                    String s5 = rs.getString("course5");
                    JOptionPane.showMessageDialog(null,s1+"\n"+s2+"\n"+s3+"\n"+s4+"\n"+s5,"Courses List",JOptionPane.PLAIN_MESSAGE);
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource() == pl1){
            if(i1<5){
                
                if(pl1.isSelected()){
                    i1++;
                     
                    String sql = "update st_course set course1 = 'Programming Language 1(C)' where id = '"+passID+"'";
                    int i = da.updateDB(sql);
                   
                    //System.out.println(i1);

                }
                else{
                   String sql9 = "update st_course set course1 = '' where id = '"+passID+"'";
                    int p = da.updateDB(sql9);
                    i1--;
                    //System.out.println(i1);
                }
            }
            else{
                pl1.setVisible(false);
                JOptionPane.showMessageDialog(null,"Full", "Warning",JOptionPane.WARNING_MESSAGE);
            }
           
            
        }
        else if(ae.getSource() == pl2){
            if(i2<5){
                
            if(pl2.isSelected()){
                i2++;
                String sql = "update st_course set course2 = 'Programming Language 2 (C++)' where id = '"+passID+"'";
            int i = da.updateDB(sql);
            
            }
            else{
                String sql9 = "update st_course set course2 = '' where id = '"+passID+"'";
                int p = da.updateDB(sql9);
                i2--;
            }
            }
            else{
                pl2.setVisible(false);
                JOptionPane.showMessageDialog(null,"Full", "Warning",JOptionPane.WARNING_MESSAGE);
            }

            
            
        }
        else if(ae.getSource() == pl3){
            if(i3<5){
            if(pl3.isSelected()){
                i3++;
                String sql = "update st_course set course3 = 'Object Oriented Programming 1 (JAVA)' where id = '"+passID+"'";
             int i = da.updateDB(sql);
             
             
            }
            else{
                String sql9 = "update st_course set course3 = '' where id = '"+passID+"'";
                int p = da.updateDB(sql9);
                i3--;
            }}
            else{
                pl3.setVisible(false);
                JOptionPane.showMessageDialog(null,"Full", "Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(ae.getSource() == pl4){
            if(i4<5){
            if(pl4.isSelected()){
                i4++;
                String sql = "update st_course set course4 = 'Object Oriented Programming 2 (C#)' where id = '"+passID+"'";
              int i = da.updateDB(sql);
              
            }
            else{
                String sql9 = "update st_course set course4 = '' where id = '"+passID+"'";
                int p = da.updateDB(sql9);
                i4--;
            }
            }
            else{
                pl4.setVisible(false);
                JOptionPane.showMessageDialog(null,"Full", "Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(ae.getSource() == pl5){
            if(i5<5){
            if(pl5.isSelected()){
                i5++;
                String sql = "update st_course set course5 = 'PHP' where id = '"+passID+"'";
              int i = da.updateDB(sql);
              
            }
            else{
                String sql9 = "update st_course set course5 = '' where id = '"+passID+"'";
                int p = da.updateDB(sql9);
                i5--;
            }
            }
            else{
                pl5.setVisible(false);
                JOptionPane.showMessageDialog(null,"Full", "Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(ae.getSource() == ref){
            String sql5 = "select course1, course2, course3, course4, course5 from st_course where id= '"+passID+"'";
             rs1 = da.getData(sql5);
        try {
            while(rs1.next()){
                this.s1 = rs1.getString("course1");
                this.s2 = rs1.getString("course2");
                this.s3 = rs1.getString("course3");
                this.s4 = rs1.getString("course4");
                this.s5 = rs1.getString("course5");
               if(s1.equals("")){
                    pl1.setSelected(false);
                    //JOptionPane.showMessageDialog(null,"You haven't select Programming Language 1 (C)");
                }
                else{
                     pl1.setSelected(true);
                } 
               if(s2.equals("")){
                    pl2.setSelected(false);
                    //JOptionPane.showMessageDialog(null,"You haven't select Programming Language 2 (C++)");
                }
                else{
                     pl2.setSelected(true);
                }
               if(s3.equals("")){
                    pl3.setSelected(false);
                    //JOptionPane.showMessageDialog(null,"You haven't select Object Oriented Programming 1 (JAVA)");
                }
                else{
                     pl3.setSelected(true);
                }
               if(s4.equals("")){
                    pl4.setSelected(false);
                    //JOptionPane.showMessageDialog(null,"You haven't select Object Oriented Programmin 2 (C#)");
                }
                else{
                     pl4.setSelected(true);
                }
               if(s5.equals("")){
                    pl5.setSelected(false);
                    //JOptionPane.showMessageDialog(null,"You haven't select PHP");
                }
                else{
                     pl5.setSelected(true);
                }
               if(s1.equals("") && s2.equals("")&& s3.equals("")&& s4.equals("")&& s5.equals("")){
                   JOptionPane.showMessageDialog(null,"You haven's select any course");
               }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
    }
    
}
