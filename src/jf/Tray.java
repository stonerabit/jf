package jf;

import static jf.Print.printsln;
import static jf.Reflectcmd.reflectcmd;

public class Tray implements java.awt.event.ActionListener{
java.awt.PopupMenu popup;
java.awt.MenuItem open, close;
java.awt.TrayIcon trayicon;/*javax.swing.JFrame jframe;*/
String classname="";
String methodname="";
String iconFilePath="image/desktop2.png";

public Tray(){/*this.jframe=jframe; 初始化托盘组件*/
	init();
}

public Tray(String iconFilePath){
	this.iconFilePath=iconFilePath;
	init();
}

public Tray(String classname,String methodname){
	this.classname=classname;
	this.methodname=methodname;/*	this.jframe=jframe; 初始化托盘组件*/
	init();
}


public Tray(String classname,String methodname,String iconFilePath){
	this.classname=classname;
	this.methodname=methodname;/*	this.jframe=jframe;*/
	this.iconFilePath=iconFilePath;/*初始化托盘组件*/
	init();
}
//</editor-fold>

public Tray(javax.swing.JFrame jframe){/*	this.jframe=jframe; 初始化托盘组件*/
	init();
}/*初始化程序托盘组件*/

private void init(){
	popup=new java.awt.PopupMenu();/*		open=new MenuItem("打开"); open.addActionListener(this);*/
	close=new java.awt.MenuItem("退出");
	close.addActionListener(this);/*popup.add(open);*/
	popup.add(close);/*检查平台是否受支持系统托盘*/
	if(java.awt.SystemTray.isSupported()) {/*printsln("SystemTray.isSupported()支持系统托盘");*/
		java.awt.SystemTray tray=java.awt.SystemTray.getSystemTray();
		try{
			trayicon=new java.awt.TrayIcon(javax.imageio.ImageIO.read(getClass().getClassLoader().getResource(iconFilePath)),null,popup);
		}catch(java.io.IOException e1){
			System.out.println("图片加载失败！");
		}
		trayicon.setImageAutoSize(true);
		trayicon.addMouseListener(new java.awt.event.MouseAdapter(){
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e){/*printsln("mouseReleased");*/
				try{
					reflectcmd(classname,methodname);
				}catch(Exception e2){
					e2.printStackTrace();/*printsln("reflectcmd() err");*/
				}
			}
		});
		printsln("trayicon.addMouseListener");
		try{
			tray.add(trayicon);
		}catch(java.awt.AWTException e){
			e.printStackTrace();
		}finally{
			printsln("trayicon added");
		}
	}else printsln("SystemTray.isSupported()支持系统托盘");
}/*托盘菜单*/

public void actionPerformed(java.awt.event.ActionEvent e){    /*右键托盘菜单选择打开，调用openJFrame函数*/
	if(e.getSource()==close) System.exit(-1);
}
}