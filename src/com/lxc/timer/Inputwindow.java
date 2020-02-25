package com.lxc.timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Inputwindow {
	public static void settime() {
		JDialog time = new JDialog(Mywindow.MainWindow, "输入时间");
		time.setSize(400, 200);
		time.setResizable(false);
		time.setLocationRelativeTo(null);
		time.setLayout(null);
		
		JTextField h = new JTextField();
		JTextField m = new JTextField();
		JTextField s = new JTextField();
		h.setBounds(50,30,60,60);
		m.setBounds(150,30,60,60);
		s.setBounds(250,30,60,60);
		h.setFont(new Font("", 1, 30));
		m.setFont(new Font("", 1, 30));
		s.setFont(new Font("", 1, 30));
		time.add(h);
		time.add(m);
		time.add(s);
		
		JLabel hh = new JLabel("时");
		JLabel mm = new JLabel("分");
		JLabel ss = new JLabel("秒");
		hh.setBounds(115, 40, 40, 40);
		mm.setBounds(215, 40, 40, 40);
		ss.setBounds(315, 40, 40, 40);
		hh.setFont(new Font("", 1, 30));
		mm.setFont(new Font("", 1, 30));
		ss.setFont(new Font("", 1, 30));
		time.add(hh);
		time.add(mm);
		time.add(ss);
		
		JButton accept = new JButton("保存",new ImageIcon(".\\image\\save.png"));
		accept.setBounds(150, 115, 100, 40);
		time.add(accept);
		
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(h.getText().equals("")) {
					h.setText("0");
				}
				if(m.getText().equals("")) {
					m.setText("0");
				}
				if(s.getText().equals("")) {
					s.setText("0");
				}
				if(Integer.valueOf(h.getText())>99||Integer.valueOf(m.getText())>60||Integer.valueOf(s.getText())>60) {
					return;
				}
				Variable.hour[Variable.nowdata]=Integer.valueOf(h.getText());
				Variable.min[Variable.nowdata]=Integer.valueOf(m.getText());
				Variable.sec[Variable.nowdata]=Integer.valueOf(s.getText());
				Myfile.data(1);
				if(Variable.hour[Variable.nowdata]<=9) {
					Mywindow.hour.setText("0"+String.valueOf(Variable.hour[Variable.nowdata]));
				}
				else {
					Mywindow.hour.setText(String.valueOf(Variable.hour[Variable.nowdata]));
				}
				if(Variable.min[Variable.nowdata]<=9) {
					Mywindow.min.setText("0"+String.valueOf(Variable.min[Variable.nowdata]));
				}
				else {
					Mywindow.min.setText(String.valueOf(Variable.min[Variable.nowdata]));
				}
				if(Variable.sec[Variable.nowdata]<=9) {
					Mywindow.sec.setText("0"+String.valueOf(Variable.sec[Variable.nowdata]));
				}
				else {
					Mywindow.sec.setText(String.valueOf(Variable.sec[Variable.nowdata]));
				}
				time.dispose();
			}
		});
		
		time.setModal(true);//设置聚焦时必须为不可见
		time.setVisible(true);
	}
	public static void rename() {
		JDialog name = new JDialog(Mywindow.MainWindow, "重命名");
		name.setSize(400, 200);
		name.setResizable(false);
		name.setLocationRelativeTo(null);
		name.setLayout(null);
		
		JTextField h = new JTextField();
		h.setBounds(100,30,200,60);
		h.setFont(new Font("", 1, 30));
		name.add(h);
		
		JButton accept = new JButton("保存",new ImageIcon(".\\image\\save.png"));
		accept.setBounds(150, 115, 100, 40);
		name.add(accept);
		
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(!h.getText().equals("")) {
					Variable.name[Variable.nowdata]=h.getText();
				}
				else {
					Variable.name[Variable.nowdata]="未命名存档";
				}
				Myfile.data(1);
				switch(Variable.nowdata) {
				case 0:
					Mywindow.slot1.setText(Variable.name[Variable.nowdata]);
					break;
				case 1:
					Mywindow.slot2.setText(Variable.name[Variable.nowdata]);
					break;
				case 2:
					Mywindow.slot3.setText(Variable.name[Variable.nowdata]);
					break;
				}
				name.dispose();
			}
		});
		
		name.setModal(true);//设置聚焦时必须为不可见
		name.setVisible(true);
	}
}
