package jf;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jf.Print.printProperties;
import static jf.Print.printsln;

public class MP{

public static Properties pattern=new java.util.Properties();
public static File patternFile=new File("/jar/conf/pattern.properties");

public static void setPattern(){
	FileOutputStream fos=null;
	InputStreamReader fin=null;


	pattern.setProperty("calendar","\\d{4}[年|\\-|\\.]\\d{1,2}[月|\\-|\\.]\\d{1,2}日?");
	pattern.setProperty("atag","<a[\\s\\S]+?</a>");
	pattern.setProperty("herf","href=\"([\\w\\s./:]+?)\"");
	pattern.setProperty("zh","[\u4e00-\u9fa5]");
	pattern.setProperty("spaceline","\\n\\s*\\r");
	pattern.setProperty("tag","<(\\S*?)[^>]*>.*?</>|<.*? />");
	pattern.setProperty("headTailSpace","^\\s*|\\s*$");
	try{
		fos=new FileOutputStream(patternFile);
		pattern.store(fos,"pattern");
	}catch(java.io.IOException e){
		e.printStackTrace();
	}finally{
		if(null!=fos)
			try{
				fos.flush();
				fos.close();
				fos=null;
			}catch(Exception e){
				e.printStackTrace();
			}

	}
}

public static void loadPattern(){

	InputStreamReader fin=null;
	try{
		java.io.FileInputStream fin1=new java.io.FileInputStream(patternFile);
		pattern.load(fin1);

	}catch(Exception e){
		e.printStackTrace();
	}finally{
	}
	printProperties(pattern);

}


public static String getURLContent(String urlStr,String charset){
	StringBuilder sb=new StringBuilder();
	try{
		URL url=new URL(urlStr);
		BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(charset)));
		String temp="";
		while((temp=reader.readLine())!=null){
			sb.append(temp);
		}
	}catch(MalformedURLException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
	return sb.toString();
}

public static String getURLContent(String urlStr){
	return getURLContent(urlStr,"utf-8");
}


public static List<String> getMatherSubstrs(String destStr,String regexStr){
	Pattern p=Pattern.compile(regexStr);
	Matcher m=p.matcher(destStr);
	List<String> result=new ArrayList<String>();
	while(m.find()){
		result.add(m.group());
	}
	return result;
}

public static String getMatherStr(String destStr,String regexStr){
	Pattern p=Pattern.compile(regexStr);
	Matcher m=p.matcher(destStr);
	StringBuilder stringBuilder=new StringBuilder();
	while(m.find()) stringBuilder.append(m.group());
	return stringBuilder.toString();
}

public static List<String> pmList(String pattern,String msrc){
	return getMatherSubstrs(msrc,pattern);
}

public static String mpStr(String msrc,String pattern){
	Pattern p=Pattern.compile(pattern);
	Matcher m=p.matcher(msrc);
	StringBuilder stringBuilder=new StringBuilder();
	while(m.find()) stringBuilder.append(m.group());
	return stringBuilder.toString();
}


public static void main(String[] args){
	//setPattern();
	loadPattern();
	String destStr=getURLContent("http://www.163.com","gbk");

////		Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");		//取到的超链接的整个内容
////	List<String> result=getMatherSubstrs(destStr,pattern.getProperty("atag"));
//	printIter(result);
	printsln(mpStr(destStr,pattern.getProperty("herf")));
}
}




