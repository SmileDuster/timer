package com.lxc.timer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Myfile {
	public static void diccheck() {
		File checker1 = new File(".\\image");
		if(checker1.exists()) {
			if(!checker1.isDirectory()) {
				checker1.delete();
				checker1.mkdirs();
			}
		}
		else {
			checker1.mkdirs();
		}
		
		File checker2 = new File(".\\data");
		if(checker2.exists()) {
			if(!checker2.isDirectory()) {
				checker2.delete();
				checker2.mkdirs();
			}
		}
		else {
			checker2.mkdirs();
		}
	}
	public static void freshset(int mode){
		/* 1、静音
		 * 2、时间槽
		 * */
		File f = new File(".\\data\\freshset.lxc");
		switch(mode) {
		case 0://读
			if(f.exists()) {
				try {
					FileReader fr1 = new FileReader(f);
					BufferedReader br1 = new BufferedReader(fr1);
					Variable.mute= Integer.parseInt(br1.readLine()) == 1;
					Variable.nowdata=Integer.parseInt(br1.readLine());
					br1.close();
					fr1.close();
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					f.createNewFile();
					FileWriter fw1 = new FileWriter(f);
					BufferedWriter bw1 = new BufferedWriter(fw1);
					bw1.write("0");
					bw1.newLine();
					bw1.write("1");
					bw1.close();
					fw1.close();
					Variable.mute=false;
					Variable.nowdata=1;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		case 1://写
			if(!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				FileWriter fw1 = new FileWriter(f);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				if(Variable.mute) {
					bw1.write("1");
				}
				else {
					bw1.write("0");
				}
				bw1.newLine();
				bw1.write(String.valueOf(Variable.nowdata));
				bw1.close();
				fw1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	public static void set(int mode) {
		/*
		 * 1、模式 
		 * 2、结束音效
		 * 3、开始音效
		 * 4、播报员
		 * */
		File f = new File(".\\data\\set.lxc");
		switch(mode) {
		case 0://读
			if(f.exists()) {
				try {
					FileReader fr1 = new FileReader(f);
					BufferedReader br1 = new BufferedReader(fr1);
					Variable.mode=Integer.parseInt(br1.readLine());
					Variable.endmusic=Integer.parseInt(br1.readLine());
					Variable.beginmusic=Integer.parseInt(br1.readLine());
					Variable.reporter=Integer.parseInt(br1.readLine());
					br1.close();
					fr1.close();
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					f.createNewFile();
					FileWriter fw1 = new FileWriter(f);
					BufferedWriter bw1 = new BufferedWriter(fw1);
					bw1.write("1");
					bw1.newLine();
					bw1.write("1");
					bw1.newLine();
					bw1.write("1");
					bw1.newLine();
					bw1.write("1");
					bw1.close();
					fw1.close();
					Variable.mode=1;
					Variable.endmusic=1;
					Variable.beginmusic=1;
					Variable.reporter=1;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		case 1://写
			if(!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				FileWriter fw1 = new FileWriter(f);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write(String.valueOf(Variable.mode));
				bw1.newLine();
				bw1.write(String.valueOf(Variable.endmusic));
				bw1.newLine();
				bw1.write(String.valueOf(Variable.beginmusic));
				bw1.newLine();
				bw1.write(String.valueOf(Variable.reporter));
				bw1.close();
				fw1.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			break;
		}
	}
	public static void data(int mode) {
		/*
		 * 1、时间1 2 3
		 * 2、名字1 2 3 
		 * */
		File f = new File(".\\data\\data.lxc");
		switch(mode) {
		case 0://读
			if(f.exists()) {
				try {
					FileReader fr1 = new FileReader(f);
					BufferedReader br1 = new BufferedReader(fr1);
					for(int i=0;i<=2;i++) {
						Variable.hour[i]=Integer.parseInt(br1.readLine());
						Variable.min[i]=Integer.parseInt(br1.readLine());
						Variable.sec[i]=Integer.parseInt(br1.readLine());
						Variable.name[i]=br1.readLine();
					}
					br1.close();
					fr1.close();
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					f.createNewFile();
					FileWriter fw1 = new FileWriter(f);
					BufferedWriter bw1 = new BufferedWriter(fw1);
					for(int i=0;i<=2;i++) {
						bw1.write("0");
						bw1.newLine();
						bw1.write("0");
						bw1.newLine();
						bw1.write("0");
						bw1.newLine();
						bw1.write("未命名存档");
						bw1.newLine();
					}
					bw1.close();
					fw1.close();
					for(int i=0;i<=2;i++) {
						Variable.hour[i]=0;
						Variable.min[i]=0;
						Variable.sec[i]=0;
						Variable.name[i]="未命名存档";
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		case 1://写
			if(!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				FileWriter fw1 = new FileWriter(f);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				for(int i=0;i<=2;i++) {
					bw1.write(String.valueOf(Variable.hour[i]));
					bw1.newLine();
					bw1.write(String.valueOf(Variable.min[i]));
					bw1.newLine();
					bw1.write(String.valueOf(Variable.sec[i]));
					bw1.newLine();
					bw1.write(Variable.name[i]);
					bw1.newLine();
				}
				bw1.close();
				fw1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}
}
