package com.lxc.timer;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;

public class Variable {
	public static final long speed = 1000;
	public static final int state1 = 24;
	public static final int state2 = 45;
	public static final int state3 = 68;
	public static final int state4 = 85;
	public static final int stoptime = 5;
	
	public static final String[] musicname = new String[4];
	public static final String[] chaname = new String[2];
	
	public static String[] name = new String[3];
	
	public static final URL[] o = new URL[4];
	public static  URL Begin;
	public static  URL Continue;
	public static  URL Half;
	public static  URL Stop;
	public static  URL Min5;
	public static  URL Pause;
	public static  URL Interruption;
	
	public static int[] hour = new int[3];
	public static int[] min = new int[3];
	public static int[] sec = new int[3];
	public static int lastday;
	public static long realtime;
	public static long maxrealtime;
	public static int nowdata;
	
	public static int mode;
	public static int beginmusic;
	public static int endmusic;
	public static int reporter;
	
	public static boolean mute=false;
	public static boolean live=false;
	public static boolean paused=false;
	public static boolean flag=false;
	public static boolean toplock=false;
	public static boolean minwindow=false;
	
	public static ImageIcon muteoff = new ImageIcon(".\\image\\muteoff.png");
	public static ImageIcon muteon = new ImageIcon(".\\image\\muteon.png");
	public static ImageIcon play = new ImageIcon(".\\image\\play.png");
	public static ImageIcon pause = new ImageIcon(".\\image\\pause.png");
	
	public static void Variableload() {  
		musicname[0]="无";
		musicname[1]="原始的吉他和音";
		musicname[2]="空灵的提琴和音";
		musicname[3]="温暖的特殊钢琴和弦";
		chaname[0]="无";
		chaname[1]="百度翻译播报员";
		
		try {
			o[1] = new URL("file:sound/m1.wav");
			o[2] = new URL("file:sound/m2.wav");
			o[3] = new URL("file:sound/m3.wav");
			Begin = new URL("file:sound/begin.wav");
			Continue = new URL("file:sound/continue.wav");
			Half = new URL("file:sound/half.wav");
			Min5 = new URL("file:sound/5min.wav");
			Stop = new URL("file:sound/stop.wav");
			Interruption = new URL("file:sound/interruption.wav");
			Pause = new URL("file:sound/pause.wav");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		
		
		int m;
		int d;
		SimpleDateFormat df = new SimpleDateFormat("MM"); 
		m=Integer.parseInt(df.format(System.currentTimeMillis()));
		SimpleDateFormat df2 = new SimpleDateFormat("dd"); 
		d=Integer.parseInt(df2.format(System.currentTimeMillis()));
		int count=0;
		while(m!=6||d!=7) {
			d++;
			count++;
			if(d>28)
			if(m==2) {
				d=1;
				m++;
			}
			else if(m == 4 || m == 6 || m == 9 || m == 11) {
				if(d>30) {
					d=1;
					m++;
				}
			}
			else if(m==1||m==3||m==5||m==7||m==8||m==10||m==12){
				if(d>31) {
					d=1;
					m++;
				}
			}
			if(m==13) {
				m=1;
			}
		}
		lastday=count;
	}
}
