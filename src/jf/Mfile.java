package jf;

import java.io.*;
import java.lang.reflect.Method;

import static jf.Print.prints;
import static jf.Print.printsln;
import static jf.Util.now;

public class Mfile{

/**
 * ********************************down is Mfile************************************************
 */

public static void copyDir(String srcPath,String destPath) throws Exception{

	if(srcPath.equals(destPath)) throw new Exception("src must != dest \n");
	File src=new File(srcPath);
	File dest=new File(destPath);
	copyDir(src,dest);

}

//fileOper

public static void filesOper(String operatename,String srcPath) throws Exception{
	File src=new File(srcPath);
	Method operate=jf.Util.class.getDeclaredMethod(operatename,File.class);
	filesOper(src,operate);
}

public static void filesOper(File src,Method operate) throws Exception{
	if(src.isFile()) operate.invoke(jf.Util.class,src);
	File[] sub;
	if(src.isDirectory()) {
		sub=src.listFiles();
		for(File file : sub){
			filesOper(file,operate);
		}
	}
}


public static void filesOperXXX(String srcPath,String tail,String operatename) throws Exception{
	int dotindex=operatename.lastIndexOf(".");
	String class4oper=operatename.substring(0,dotindex);
	operatename=operatename.substring(dotindex);
	//prints(class4oper+"："+operatename);
	filesOper(srcPath,tail,class4oper,operatename);
}

public static void filesOper(String srcPath,final String tail,String class4per,String operatename) throws Exception{
	File src=new File(srcPath);
	Class c=Class.forName(class4per);
	Method operate=c.getDeclaredMethod(operatename,File.class);
	if(src.isFile()) operate.invoke(jf.Util.class,src);
	File[] sub;
	if(src.isDirectory()) {
		sub=src.listFiles(new FileFilter(){

			public boolean accept(File file){
				if(file.isDirectory() || file.getName().endsWith(tail)) return true;
				else
					return false;
			}
		});
		printsln(now()+" filter get sub.length "+sub.length);
		for(File file : sub){
			filesOper(file,tail,operate);
		}
	}
}

public static FileFilter javafilter=(File file)->{
	if(file.isDirectory() || file.getName().endsWith("java")) return true;
	else
		return false;
};

public static FileFilter fileTailFilter(String tail){
	FileFilter fileTailFilter=(File file)->{
		if(file.isDirectory() || file.getName().endsWith(tail)) return true;
		else
			return false;
	};
	return fileTailFilter;
}

public static FileFilter filenameContainFilter(String contain){
	FileFilter fileFilter=(File file)->{
		if(file.isDirectory() || file.getName().contains(contain)) return true;
		else
			return false;
	};
	return fileFilter;

}


public static void filesOper(File src,final String tail,Method operate) throws Exception{
	if(src.isFile()) operate.invoke(null,src);
	File[] sub;
	if(src.isDirectory()) {
		sub=src.listFiles(fileTailFilter(tail));
		//printsln(now()+" filter get sub.length "+sub.length);
		for(File file : sub){
			filesOper(file,tail,operate);
		}
	}
}


public static void copyDir(File src,File dest) throws Exception{
	if(src.isDirectory()) {
		dest=new File(dest,src.getName());
		StringBuilder desthead=new StringBuilder();
		desthead.append(dest.getAbsolutePath().substring(0,src.getAbsolutePath().length()+1));
		if(desthead.equals(src.getAbsolutePath()+"/")) throw new Exception("父目录不能拷贝到子目录中");
	}
	copyDirDetail(src,dest);
}


public static void copyDirDetail(File src,File dest) throws Exception{
	if(src.isFile()) {
		try{
			copyFile(src,dest);
		}catch(Exception e){
			e.printStackTrace();
		}
	}else if(src.isDirectory()) {
		dest.mkdirs();
		for(File file : src.listFiles()){
			copyDirDetail(file,new File(dest,file.getName()));
		}
	}
}


//cp file ,with check;
public static void copyFile(File src,File dest) throws Exception{
	if(!src.isFile()) throw new Exception("copyFile只能拷贝文件"+src.getAbsolutePath()+" err\n");
	if(dest.isDirectory()) throw new Exception("不能建立文件夹同名的文件"+dest.getAbsolutePath()+" err\n");

	copy(src,dest);
}

//cp file ,with check;
public static void copyFile(File src,File dest,boolean force) throws Exception{

	if(!src.isFile()) throw new Exception("copyFile只能拷贝文件"+src.getAbsolutePath()+" err\n");
	if(dest.isDirectory()) throw new Exception("不能建立文件夹同名的文件"+dest.getAbsolutePath()+" err\n");
	if(dest.exists()) throw new Exception("文件exist,no override"+dest.getAbsolutePath()+" err\n");

	copy(src,dest);
}

//just do copy
public static void copy(File src,File dest) throws Exception{

	if(!src.isFile()) {
		System.out.println("copyFile source err");
		throw new IOException("copyFile source err");
	}

	InputStream is=null;
	OutputStream os=null;
	try{
		is=new BufferedInputStream(new FileInputStream(src));
		os=new BufferedOutputStream(new FileOutputStream(dest));

		byte[] flush=new byte[4096];
		int len=0;
		while(-1!=(len=is.read(flush))) os.write(flush,0,len);

	}catch(Exception e){
		e.printStackTrace();

	}finally{

		try{
			if(null!=os) os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(null!=is) os.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}

public static void copy(String srcPath,String destPath) throws Exception{

	File src=new File(srcPath);
	File dest=new File(destPath);


	copy(src,dest);

}


public static void copyl(String srcPath,String destPath) throws Exception{
	File src=new File(srcPath);
	File dest=new File(destPath);

	//不是文件或者为null
	if(!src.isFile()) {
		prints("source err");
		throw new IOException("source err");
	}

	BufferedReader reader=null;
	BufferedWriter writer=null;
	try{
		reader=new BufferedReader(new FileReader(src));
		writer=new BufferedWriter(new FileWriter(dest));

		String line=null;
		int i=1;
		while(null!=(line=reader.readLine())){
			writer.append(i+++"\t");
			writer.write(line);
//			writer.append("\r\n");
			writer.newLine(); //换行符号
		}
		writer.flush();
	}catch(FileNotFoundException e){
		e.printStackTrace();
		prints("FileNotFound");
	}catch(IOException e){
		e.printStackTrace();
		prints("FileNotFound");
	}finally{
		try{
			if(null!=writer) writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(null!=reader) reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}


public static void fconvert(String filepath,String srcCharset,String destCharset) throws Exception{

	File file=new File(filepath);
	fconvert(file,srcCharset,destCharset);
}

public static void fconvert(File file,String srcCharset,String destCharset) throws Exception{

	String filepath=file.getAbsolutePath();
	File filetmp=new File(filepath+".tmp");
	BufferedReader br=null;
	BufferedWriter bw=null;
	try{
		//指定解码字符集
		br=new BufferedReader(
				new InputStreamReader(
						new BufferedInputStream(
								new FileInputStream(file)),srcCharset)
		);
		//写出文件 编码
		bw=new BufferedWriter(
				new OutputStreamWriter(
						new BufferedOutputStream(
								new FileOutputStream(filetmp)),destCharset));

		String info=null;

		while(null!=(info=br.readLine())){
			bw.write(info);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
		bw=null;
		br=null;

		file.delete();
		filetmp.renameTo(file);
		printsln(file.getAbsolutePath()+" convert from "+srcCharset+" to "+destCharset);

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(null!=bw) {
			bw.flush();
			bw.close();
			bw=null;
		}
		if(null!=br) {
			br.close();
			br=null;
		}
	}


}

public static void gbk2utf8(String filepath) throws Exception{
	fconvert(filepath,"gbk","utf-8");
}

public static void gbk2utf8(File file) throws Exception{
	fconvert(file,"gbk","utf-8");
}

public static void utf82gbk(String filepath) throws Exception{
	fconvert(filepath,"utf-8","gbk");
}

public static void utf82gbk(File file) throws Exception{
	fconvert(file,"utf-8","gbk");
}


/**
 * ********************************up is Mfile************************************************
 */

public static void main(String[] args){
	try{

		Util.main(args);
	}catch(Exception e){
		e.printStackTrace();
	}
}
}



