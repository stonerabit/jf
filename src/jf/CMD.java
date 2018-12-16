package jf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 * this is digest of other jf class,for cmd use purpose
 */

public class CMD{


/**
 * **********************down is linux shell******************************************************
 */

public static List<String> forkrun(String shStr) throws Exception{

	List<String> strList=new ArrayList();
	try{
		Process process;
		process=Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",shStr},null,null);

		//process = Runtime.getRuntime().exec(shStr);
		InputStreamReader ir=new InputStreamReader(process.getInputStream());
		LineNumberReader lr=new LineNumberReader(ir);
		BufferedReader br=new java.io.BufferedReader(lr);
		String lineStr;
		process.waitFor();
		//like join in thread;
		while((lineStr=br.readLine())!=null){
			System.out.println(lineStr);
			strList.add(lineStr);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return strList;
}

public static List<String> exec(String shStr) throws Exception{

	List<String> strList=new ArrayList();
	try{
		Process process;
		//process=Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",shStr},null,null);

		process=Runtime.getRuntime().exec(shStr);

		InputStreamReader ir=new InputStreamReader(process.getInputStream());
		LineNumberReader lr=new LineNumberReader(ir);
		BufferedReader br=new java.io.BufferedReader(lr);
		String lineStr;
		process.waitFor();
		//like join in thread;
		while((lineStr=br.readLine())!=null){
			System.out.println(lineStr);
			strList.add(lineStr);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return strList;
}


/**
 * **********************up is linux shell******************************************************
 */


public static void main(String[] args){
	try{
		Util.main(args);
		//Thread.sleep(600000);
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
