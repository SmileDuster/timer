package com.lxc.timer;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Mywindow {
	
	public static JFrame MainWindow = new JFrame("倒计时器 v1.2");
	public static Container Container2 = MainWindow.getContentPane();
	public static JLabel hour = new JLabel();
	public static JLabel min = new JLabel();
	public static JLabel sec = new JLabel();
	public static JRadioButton slot1 = new JRadioButton();
	public static JRadioButton slot2 = new JRadioButton();
	public static JRadioButton slot3 = new JRadioButton();
	
	public static int nowh;
	public static int nowm;
	public static int nows;
	
	public static Thread timegone;
	
	public static void main(String[] args) {
		//准备工作  开始
			Variable.Variableload();
			JProgressBar in = new JProgressBar();
			in.setStringPainted(true);
			in.setBounds(50, 275, 300, 75);
			in.setFont(new Font("", Font.BOLD, 25));
		//准备工作  结束
		
		
		//准备窗口  开始
		JFrame CheckWindow = new JFrame("启动中......");
		Container Container1 = CheckWindow.getContentPane();
		CheckWindow.setLayout(null);
		CheckWindow.setVisible(true);
		CheckWindow.setBounds(0,0,400, 400);
		CheckWindow.setResizable(false);
		CheckWindow.setLocationRelativeTo(null);
		CheckWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JButton start = new JButton("载入中...");
		start.setEnabled(false);
		start.setFont(new Font("", Font.BOLD, 25));
		start.setBounds(50, 275, 300, 75);
		
		JLabel title = new JLabel("倒计时器 v1.2");
		JLabel idea = new JLabel("距离高考还剩");
		JLabel day = new JLabel(Variable.lastday+"天");
		final JLabel name = new JLabel("梁笑尘制作");
		day.setForeground(new Color((int) ((365-Variable.lastday)*0.7), 0, 0));
		title.setFont(new Font("", Font.BOLD, 50));
		idea.setFont(new Font("", Font.BOLD, 40));
		day.setFont(new Font("", Font.BOLD, (int) (40+(365-Variable.lastday)*0.166)));
		name.setFont(new Font("", Font.BOLD, 25));
		title.setBounds(0, 0, 400, 70);
		idea.setBounds(0, 90, 400, 100);
		day.setBounds(0, 170, 400, 100);
		name.setBounds(0,50,400,50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		idea.setHorizontalAlignment(SwingConstants.CENTER);
		day.setHorizontalAlignment(SwingConstants.CENTER);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		Container1.add(title);
		Container1.add(idea);
		Container1.add(day);
		Container1.add(in);
		Container1.add(name);
		//准备窗口  结束
		in.setValue(0);
		in.setString("等待中...");
		try {
			Thread.sleep(750);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		//文件读取 开始
		in.setString("搬来储存数据");
		Myfile.diccheck();
		Myfile.set(0);
		Myfile.freshset(0);
		Myfile.data(0);
		//文件读取 结束
		try {
			int count = 0;
			while (count<=Variable.state1) {
				in.setValue(count++);
				Thread.sleep(Variable.stoptime);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//主窗口  开始
		in.setString("打造华丽地主界面");
		MainWindow.setLayout(null);
		MainWindow.setVisible(false);
		MainWindow.setBounds(0,0,800, 400);
		MainWindow.setResizable(false);
		MainWindow.setLocationRelativeTo(null);
		MainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		MainWindow.setAlwaysOnTop(false);
		
		JFrame SmallWindow = new JFrame("窗口已缩小");
		SmallWindow.setVisible(false);
		SmallWindow.setResizable(false);
		SmallWindow.setBounds(0,0,375,150);
		SmallWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		SmallWindow.setAlwaysOnTop(true);
		SmallWindow.setLocationRelativeTo(null);
		SmallWindow.setLayout(null);
		
		JButton re = new JButton("<html>恢<br/>复</html>");
		re.setFont(new Font("", Font.BOLD, 30));
		re.setBounds(300, 0, 75, 130);
		SmallWindow.add(re);

		duplicateCode1();
		JLabel b1 = new JLabel(":");
		JLabel b2 = new JLabel(":");
		JLabel mode = new JLabel();
		if(Variable.mode==1) {
			mode.setText("普通模式");
		}
		else if(Variable.mode==2) {
			mode.setText("播报员模式");
		}
		JLabel contant = new JLabel();
		if(Variable.mode==1) {
			contant.setText(Variable.musicname[Variable.endmusic]);
		}
		else if(Variable.mode==2) {
			contant.setText(Variable.chaname[Variable.reporter]);
		}
		hour.setBounds(20,20,140,150);
		min.setBounds(190,20,140,150);
		sec.setBounds(360,20,140,150);
		b1.setBounds(160,15,30,150);
		b2.setBounds(330,15,30,150);
		mode.setBounds(30,90,200,100);
		contant.setBounds(30,20,400,70);
		hour.setFont(new Font("", Font.PLAIN, 120));
		min.setFont(new Font("", Font.PLAIN, 120));
		sec.setFont(new Font("", Font.PLAIN, 120));
		b1.setFont(new Font("", Font.PLAIN, 100));
		b2.setFont(new Font("", Font.PLAIN, 100));
		mode.setFont(new Font("", Font.BOLD, 25));
		contant.setFont(new Font("", Font.BOLD, 25));
		Container2.add(hour);
		Container2.add(min);
		Container2.add(sec);
		Container2.add(b1);
		Container2.add(b2);
		
		JButton go = new JButton("开始",Variable.play);
		JButton stop = new JButton("停止",new ImageIcon(".\\image\\stop.png"));
		JButton up = new JButton(new ImageIcon(".\\image\\up.png"));
		JButton down = new JButton(new ImageIcon(".\\image\\down.png"));
		JButton settime = new JButton("输时间",new ImageIcon(".\\image\\input.png"));
		JButton rename = new JButton("重命名",new ImageIcon(".\\image\\rename.png"));
		JButton save = new JButton("保存",new ImageIcon(".\\image\\save.png"));
		JButton settings = new JButton("设置",new ImageIcon(".\\image\\set.png"));
		JButton top = new JButton(new ImageIcon(".\\image\\unlocked.png"));
		JButton minit = new JButton(new ImageIcon(".\\image\\min.png"));
		stop.setEnabled(false);
		save.setEnabled(false);
		
		JButton mute = new JButton();
		if(Variable.mute) {
			mute.setIcon(Variable.muteon);
		}
		else {
			mute.setIcon(Variable.muteoff);
		}
		go.setBounds(570, 40, 120, 50);
		minit.setBounds(710, 100, 50, 50);
		stop.setBounds(570, 100, 120, 50);
		top.setBounds(710, 40, 50, 50);
		up.setBounds(510, 40, 50, 50);
		down.setBounds(510, 100, 50, 50);
		settime.setBounds(230, 35, 130, 45);
		rename.setBounds(230, 85, 130, 45);
		save.setBounds(230, 135, 130, 45);
		settings.setBounds(180, 115, 120, 50);
		mute.setBounds(310, 115, 50, 50);
		go.setFont(new Font("", Font.PLAIN, 20));
		stop.setFont(new Font("", Font.PLAIN, 20));
		settime.setFont(new Font("", Font.PLAIN, 20));
		rename.setFont(new Font("", Font.PLAIN, 20));
		save.setFont(new Font("", Font.PLAIN, 20));
		settings.setFont(new Font("", Font.PLAIN, 20));
		Container2.add(go);
		Container2.add(stop);
		Container2.add(up);
		Container2.add(down);
		Container2.add(top);
		Container2.add(minit);
		
		
		slot1.setText(Variable.name[0]);
		slot2.setText(Variable.name[1]);
		slot3.setText(Variable.name[2]);
		switch(Variable.nowdata) {
		case 0:
			slot1.setSelected(true);
			break;
		case 1:
			slot2.setSelected(true);
			break;
		case 2:
			slot3.setSelected(true);
			break;
		}
		slot1.setBounds(30, 30, 200, 50);
		slot2.setBounds(30, 80, 200, 50);
		slot3.setBounds(30, 130, 200, 50);
		slot1.setFont(new Font("", Font.BOLD, 25));
		slot2.setFont(new Font("", Font.BOLD, 25));
		slot3.setFont(new Font("", Font.BOLD, 25));
		ButtonGroup slot = new ButtonGroup();
		slot.add(slot1);
		slot.add(slot2);
		slot.add(slot3);
		
		JPanel saveslot = new JPanel(null);
		JPanel setting = new JPanel(null);
		saveslot.setBounds(0, 170, 390, 200);
		setting.setBounds(400, 170, 390, 200);
		saveslot.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3), "计时存储", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("", Font.BOLD, 20)));
		setting.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3), "提醒音效", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("", Font.BOLD, 20)));
		saveslot.add(slot1);
		saveslot.add(slot2);
		saveslot.add(slot3);
		saveslot.add(settime);
		saveslot.add(rename);
		saveslot.add(save);
		setting.add(mode);
		setting.add(contant);
		setting.add(settings);
		setting.add(mute);
		Container2.add(saveslot);
		Container2.add(setting);
		//主窗口  结束
		try {
			int count = Variable.state1;
			while (count<=Variable.state2) {
				in.setValue(count++);
				Thread.sleep(Variable.stoptime);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//设置窗口 开始
		in.setString("正在装修设备库");
		JFrame setWindow = new JFrame("音效设置");
		Container Container3 = setWindow.getContentPane();
		setWindow.setLayout(null);
		setWindow.setVisible(false);
		setWindow.setBounds(0,0,800, 400);
		setWindow.setResizable(false);
		setWindow.setLocationRelativeTo(null);
		setWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JComboBox<String> end = new JComboBox<>(Variable.musicname);
		end.setFont(new Font("", Font.BOLD, 20));
		JComboBox<String> character = new JComboBox<>(Variable.chaname);
		character.setFont(new Font("", Font.BOLD, 20));
		end.setSelectedIndex(Variable.endmusic);
		character.setSelectedIndex(Variable.reporter);
		end.setBounds(150, 150, 200, 40);
		character.setBounds(550, 225, 200, 40);
		Container3.add(end);
		Container3.add(character);
		
		JPanel line = new JPanel();
		line.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 10));
		line.setBounds(400, 30, 3, 260);
		Container3.add(line);
		
		JButton saveset = new JButton("确定",new ImageIcon(".\\image\\save.png"));
		saveset.setBounds(350, 300, 100, 50);
		Container3.add(saveset);
		
		JRadioButton o = new JRadioButton("普通模式");
		JRadioButton b = new JRadioButton("播报员模式");
		if(Variable.mode==1) {
			o.setSelected(true);
			character.setEnabled(false);
		}
		else if(Variable.mode==2) {
			b.setSelected(true);
			end.setEnabled(false);
		}
		o.setBounds(130, 20, 200, 50);
		b.setBounds(510, 20, 200, 50);
		o.setFont(new Font("", Font.BOLD, 30));
		b.setFont(new Font("", Font.BOLD, 30));
		ButtonGroup voicemode = new ButtonGroup();
		voicemode.add(b);
		voicemode.add(o);
		Container3.add(o);
		Container3.add(b);
		
		JLabel texto = new JLabel("在计时结束或开始时播放提示音");
		JLabel textb = new JLabel("<html>在以下情况播放语音<br>1、开始、继续、暂停、停止计时时<br>2、时间过半（30分钟以上的计时有效）<br>3、剩余5分钟（20分钟以上的计时有效）<br>4、计时结束时</html>");
		JLabel choose1 = new JLabel("结束提示");
		JLabel choose3 = new JLabel("播报员");
		texto.setBounds(0,70,400,50);
		textb.setBounds(400,70,400,150);
		choose1.setBounds(20,150,120,50);
		choose3.setBounds(420,225,120,50);
		texto.setFont(new Font("", Font.PLAIN, 20));
		textb.setFont(new Font("", Font.PLAIN, 20));
		choose1.setFont(new Font("", Font.BOLD, 25));
		choose3.setFont(new Font("", Font.BOLD, 25));
		textb.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		Container3.add(texto);
		Container3.add(textb);
		Container3.add(choose1);
		Container3.add(choose3);
		
		//设置窗口 结束
		try {
			int count = Variable.state2;
			while (count<=Variable.state3) {
				in.setValue(count++);
				Thread.sleep(Variable.stoptime);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		//计时进程 开始
		in.setString("正在启动核心之力");
		timegone = new Thread(() -> {
			try {
				while(true) {
					Thread.sleep((Variable.speed));
					if(Variable.live&&!Variable.paused) {
						Variable.realtime--;
						if(--nows<=-1) {
							if(--nowm<=-1) {
								if(--nowh<=-1) {
									System.out.println("程序出错了");
								}
								else {
									nowm+=60;
									nows+=60;
								}
								if(nowh<=9) {
									hour.setText("0"+ nowh);
								}
								else {
									hour.setText(String.valueOf(nowh));
								}
							}
							else {
								nows+=60;
							}
							if(nowm<=9) {
								min.setText("0"+ nowm);
							}
							else {
								min.setText(String.valueOf(nowm));
							}
						}
						if(nows<=9) {
							sec.setText("0"+ nows);
						}
						else {
							sec.setText(String.valueOf(nows));
						}
						if(Variable.realtime==0) {
							if(Variable.mode==1&&Variable.endmusic!=0&&!Variable.mute) {
								AudioClip ending = Applet.newAudioClip(Variable.o[Variable.endmusic]);
								ending.play();
							}
							else if(Variable.mode==2&&Variable.reporter!=0&&!Variable.mute) {
								AudioClip ending = Applet.newAudioClip(Variable.Stop);
								ending.play();
							}
							duplicateCode2(go, stop, up, down, settime, rename, save, settings);
							if(Variable.minwindow) {
								SmallWindow.setVisible(false);
								MainWindow.setVisible(true);
								Variable.minwindow=false;
								duplicateCode3(b2);
							}
						}
						else if(Variable.realtime==(Variable.maxrealtime/2)) {
							if(Variable.mode==2&&Variable.reporter!=0&&Variable.maxrealtime>=1800&&!Variable.mute) {
								AudioClip ending = Applet.newAudioClip(Variable.Half);
								ending.play();
							}
						}
						else if(Variable.realtime==300) {
							if(Variable.mode==2&&Variable.reporter!=0&&!Variable.mute&&Variable.maxrealtime>=1200) {
								AudioClip ending = Applet.newAudioClip(Variable.Min5);
								ending.play();
							}
						}
					}
					System.out.println(Variable.realtime);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		//计时进程 结束
		try {
			int count = Variable.state3;
			while (count<=Variable.state4) {
				in.setValue(count++);
				Thread.sleep(Variable.stoptime);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//加载按钮  开始
		in.setString("正在启动超能力链接");
		save.addActionListener(e -> {
			save.setEnabled(false);
			Myfile.data(1);
		});
		up.addActionListener(e -> {
			if(++Variable.min[Variable.nowdata]>=60) {
				if(++Variable.hour[Variable.nowdata]>=100) {
					Variable.hour[Variable.nowdata]=99;
					Variable.min[Variable.nowdata]=59;
				}
				else {
					Variable.min[Variable.nowdata]-=60;
				}
			}
			duplicateCode4(save);
		});
		down.addActionListener(e -> {
			if(--Variable.min[Variable.nowdata]<=-1) {
				if(--Variable.hour[Variable.nowdata]<=-1) {
					Variable.min[Variable.nowdata]=0;
					Variable.hour[Variable.nowdata]=0;
				}
				else {
					Variable.min[Variable.nowdata]+=60;
				}
			}
			duplicateCode4(save);
		});
		start.addActionListener(e -> {
			CheckWindow.setVisible(false);
			MainWindow.setVisible(true);
		});
		settings.addActionListener(e -> {
			MainWindow.setVisible(false);
			setWindow.setVisible(true);
		});
		settime.addActionListener(e -> Inputwindow.settime());
		rename.addActionListener(e -> Inputwindow.rename());
		saveset.addActionListener(e -> {
			if(b.isSelected()) {
				Variable.mode=2;
			}
			else if(o.isSelected()) {
				Variable.mode=1;
			}
			Variable.endmusic=end.getSelectedIndex();
			Variable.reporter=character.getSelectedIndex();
			Myfile.set(1);
			if(Variable.mode==1) {
				mode.setText("普通模式");
				contant.setText(end.getItemAt(end.getSelectedIndex()));
			}
			else if(Variable.mode==2) {
				mode.setText("播报员模式");
				contant.setText(character.getItemAt(character.getSelectedIndex()));
			}
			setWindow.setVisible(false);
			MainWindow.setVisible(true);
		});
		mute.addActionListener(e -> {
			if(Variable.mute) {
				mute.setIcon(Variable.muteoff);
			}
			else {
				mute.setIcon(Variable.muteon);
			}
			Variable.mute=!Variable.mute;
			Myfile.freshset(1);
		});
		go.addActionListener(e -> {
			if(!Variable.live) {
				Variable.realtime=Variable.hour[Variable.nowdata]*3600+Variable.min[Variable.nowdata]*60+Variable.sec[Variable.nowdata];
				if(Variable.realtime==0) {
					return;
				}
				Variable.maxrealtime=Variable.realtime;
				rename.setEnabled(false);
				settime.setEnabled(false);
				save.setEnabled(false);
				settings.setEnabled(false);
				slot1.setEnabled(false);
				slot2.setEnabled(false);
				slot3.setEnabled(false);
				up.setEnabled(false);
				down.setEnabled(false);
				stop.setEnabled(true);
				go.setText("暂停");
				go.setIcon(Variable.pause);
				Variable.live=true;
				Variable.paused=false;
				nowh=Variable.hour[Variable.nowdata];
				nowm=Variable.min[Variable.nowdata];
				nows=Variable.sec[Variable.nowdata];
				if(!Variable.flag) {
					Variable.flag=true;
					timegone.start();
				}
				if(Variable.mode==2&&!Variable.mute&&Variable.reporter!=0) {
					AudioClip ending = Applet.newAudioClip(Variable.Begin);
					ending.play();
				}
			}
			else if(!Variable.paused) {
				go.setText("继续");
				go.setIcon(Variable.play);
				Variable.paused=true;
				if(Variable.mode==2&&!Variable.mute&&Variable.reporter!=0) {
					AudioClip ending = Applet.newAudioClip(Variable.Pause);
					ending.play();
				}
			}
			else {
				go.setText("暂停");
				go.setIcon(Variable.pause);
				Variable.paused=false;
				if(Variable.mode==2&&!Variable.mute&&Variable.reporter!=0) {
					AudioClip ending = Applet.newAudioClip(Variable.Continue);
					ending.play();
				}
			}

		});
		stop.addActionListener(e -> {
			duplicateCode2(go, stop, up, down, settime, rename, save, settings);
			duplicateCode1();
			if(Variable.mode==2&&!Variable.mute&&Variable.reporter!=0) {
				AudioClip ending = Applet.newAudioClip(Variable.Interruption);
				ending.play();
			}
		});
		minit.addActionListener(e -> {
			Variable.minwindow=true;
			MainWindow.setVisible(false);
			SmallWindow.setVisible(true);
			SmallWindow.add(b2);
			SmallWindow.add(min);
			SmallWindow.add(sec);
			min.setBounds(0,-10,140,150);
			sec.setBounds(170,-10,140,150);
			b2.setBounds(140,-10,30,150);
		});
		re.addActionListener(e -> {
			SmallWindow.setVisible(false);
			Variable.minwindow=false;
			MainWindow.setVisible(true);
			duplicateCode3(b2);
		});
		top.addActionListener(e -> {
			if(Variable.toplock) {
				Variable.toplock=false;
				top.setIcon(new ImageIcon(".\\image\\unlocked.png"));
				MainWindow.setAlwaysOnTop(false);
			}
			else {
				Variable.toplock=true;
				top.setIcon(new ImageIcon(".\\image\\locked.png"));
				MainWindow.setAlwaysOnTop(true);
			}
		});
		slot1.addActionListener(e -> {
			Variable.nowdata=0;
			Myfile.freshset(1);
			duplicateCode1();
		});
		slot2.addActionListener(e -> {
			Variable.nowdata=1;
			Myfile.freshset(1);
			duplicateCode1();
		});
		slot3.addActionListener(e -> {
			Variable.nowdata=2;
			Myfile.freshset(1);
			duplicateCode1();
		});
		o.addActionListener(e -> {
			Variable.mode=1;
			end.setEnabled(true);
			character.setEnabled(false);
		});
		b.addActionListener(e -> {
			Variable.mode=2;
			character.setEnabled(true);
			end.setEnabled(false);
		});
		//加载按钮  结束
		
		in.setString("投喂皮卡丘");
		try {
			int count = Variable.state4;
			while (count<=100) {
				in.setValue(count++);
				Thread.sleep(Variable.stoptime);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Container1.remove(in);
		Container1.add(start);
		start.setText("开始");
		CheckWindow.setTitle("已就绪");
		start.setEnabled(true);
	}

	private static void duplicateCode4(JButton save) {
		duplicateCode5();
		save.setEnabled(true);
	}

	private static void duplicateCode5() {
		if(Variable.hour[Variable.nowdata]<=9) {
			hour.setText("0"+ Variable.hour[Variable.nowdata]);
		}
		else {
			hour.setText(String.valueOf(Variable.hour[Variable.nowdata]));
		}
		if(Variable.min[Variable.nowdata]<=9) {
			min.setText("0"+ Variable.min[Variable.nowdata]);
		}
		else {
			min.setText(String.valueOf(Variable.min[Variable.nowdata]));
		}
	}

	private static void duplicateCode3(JLabel b2) {
		Container2.add(b2);
		Container2.add(min);
		Container2.add(sec);
		min.setBounds(190,20,140,150);
		sec.setBounds(360,20,140,150);
		b2.setBounds(330,15,30,150);
	}

	private static void duplicateCode2(JButton go, JButton stop, JButton up, JButton down, JButton settime, JButton rename, JButton save, JButton settings) {
		stop.setEnabled(false);
		Variable.live=false;
		Variable.paused=false;
		go.setText("开始");
		go.setIcon(Variable.play);
		rename.setEnabled(true);
		settime.setEnabled(true);
		save.setEnabled(true);
		settings.setEnabled(true);
		slot1.setEnabled(true);
		slot2.setEnabled(true);
		slot3.setEnabled(true);
		up.setEnabled(true);
		down.setEnabled(true);
	}

	private static void duplicateCode1() {
		duplicateCode5();
		if(Variable.sec[Variable.nowdata]<=9) {
			sec.setText("0"+ Variable.sec[Variable.nowdata]);
		}
		else {
			sec.setText(String.valueOf(Variable.sec[Variable.nowdata]));
		}
	}

}
