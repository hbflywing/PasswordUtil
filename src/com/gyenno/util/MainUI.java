package com.gyenno.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shawn.zeng on 2018/5/18.
 */
public class MainUI extends JFrame implements ActionListener{

    private JLabel jLabel1,jLabel2,jLabel3;

    private JTextField username;

    private JTextField password;

    private JTextField encodepassword;

    private JButton ok;

    private JPanel jp1,jp2,jp3,jp4;

    public MainUI(){
        jLabel1 = new JLabel("用户名：");
        jLabel2 = new JLabel("密  码：");
        jLabel3 = new JLabel("加密后：");
        username = new JTextField(20);
        password = new JTextField(20);
        encodepassword = new JTextField(20);
        ok = new JButton("计算");
        jp1= new JPanel();
        jp2= new JPanel();
        jp3 =  new JPanel();
        jp4 = new JPanel();
        jp1.add(jLabel1);
        jp1.add(username);
        jp2.add(jLabel2);
        jp2.add(password);
        jp3.add(jLabel3);
        jp3.add(encodepassword);
        jp4.add(ok);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        //设置监听
        ok.addActionListener(this);
        this.setLayout(new GridLayout(4,1));
        this.setTitle("密码计算器");
        this.setSize(400,300);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new MainUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(username.getText().isEmpty() || password.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"请填写完整信息！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else {
            encodepassword.setText(PasswordUtil.encrypt(username.getText(),password.getText(),PasswordUtil.getStaticSalt()));
        }
    }


}
