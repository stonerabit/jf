package jf;

public class Sleep4debug{
public static void main(String[] args){
	try{
		Util.main(args);
		Thread.sleep(600000);
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
