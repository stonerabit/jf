package jf;

import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_M;

public class KB{

public static java.awt.Robot robot=null;

static{
	try{
		robot=new java.awt.Robot();
	}catch(java.awt.AWTException e){
		e.printStackTrace();
	}
}

public static void groupkey(int key1,int key2){
	robot.keyPress(key1);
	robot.keyPress(key2);
//	robot.delay(30);
	robot.keyRelease(key1);
	robot.keyRelease(key2);
}

public static void showDesktop(){
	groupkey(VK_CONTROL,VK_M);

}

public static void showDesktopTray(String iconFilePath){
	iconFilePath=(iconFilePath==null) ? "image/desktop1.jpg" : iconFilePath;
	new jf.DesktopTray(iconFilePath);
}

public static void showDesktopTray(){
	new jf.DesktopTray();
}

public static void main(String[] args){
	showDesktopTray();
}
}
