package jf;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static jf.Print.printsln;
import static jf.Util.close;

public class Zip{
public static void zip(String srcPath){
	zip(srcPath,srcPath+".zip");
}

public static void zip(String srcPath,String destPath){
	Zip zipper=new Zip();
	File destFile=null;
	File srcFile=null;
	try{
		srcFile=new File(srcPath);
		destFile=new File(destPath);
		zipper.zip(srcFile,destFile);
	}catch(Exception e){
		e.printStackTrace();
	}
}


public void zip(File srcFile,File destFile) throws Exception{
	BufferedOutputStream bo=null;
	ZipOutputStream out=null;
	try{
		System.out.println("压缩中...");
		out=new ZipOutputStream(new FileOutputStream(destFile));
		bo=new BufferedOutputStream(out);
		zip(out,srcFile,srcFile.getName(),bo);
		System.out.println("压缩完成");
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		close(bo);
		close(out);
	}
}

public void zip(String destFilePath,File srcFile) throws Exception{
	File destFile=new java.io.File(destFilePath);
	zip(srcFile,destFile);
}

/**
 * @param f    file to deal
 * @param base base in ZipOutputStream which the dealed files locate at zipFS
 * @out OutputStream for zipFS
 * @bo BufferedOutputStream for zipFS,usually from out;normally it is buffered out
 */

public void zip(ZipOutputStream out,File f,String base,BufferedOutputStream bo) throws Exception{
	FileInputStream in=null;
	BufferedInputStream bi=null;
	try{
		if(f.isDirectory()) {
			File[] fl=f.listFiles();
			if(fl.length==0) {
				out.putNextEntry(new ZipEntry(base+"/")); /*创建zip压缩进入点base*/
				System.out.println(base+"/");
			}
			for(int i=0;i<fl.length;i++) zip(out,fl[i],base+"/"+fl[i].getName(),bo); /*递归遍历子文件夹*/
		}else {
			out.putNextEntry(new ZipEntry(base)); /*创建zip压缩进入点base*/
			in=new FileInputStream(f);
			bi=new BufferedInputStream(in);
			int b;
			while((b=bi.read())!=-1) bo.write(b);
			System.out.println(f.getAbsolutePath()+" to "+"zipFS:"+base);
		}
	}catch(Exception e){
		e.printStackTrace();
		printsln("jf.Zip.zip() err");
	}finally{
		close(bi);
		close(in);
	}
}

/*外包装的流先关闭，最后关闭文件流；万一出异常，能关闭多少关闭多少；*/
public static void unzip(String srcZipPath,String destDirPath){
	long startTime=System.currentTimeMillis();
	ZipInputStream zin=null;
	BufferedInputStream bin=null;

	FileOutputStream out=null;
	BufferedOutputStream bout=null;
	try{
		zin=new ZipInputStream(new FileInputStream(srcZipPath));
		bin=new BufferedInputStream(zin);
		String Parent=destDirPath;
		ZipEntry entry;
		while((entry=zin.getNextEntry())!=null && !entry.isDirectory()){
			File fout=new File(Parent,entry.getName());
			if(!fout.exists()) (new java.io.File(fout.getParent())).mkdirs();
			out=new FileOutputStream(fout);
			bout=new BufferedOutputStream(out);
			int b;
			while((b=bin.read())!=-1) bout.write(b);
			System.out.println(fout+"解压成功");
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		close(bout);
		close(out);
		close(bin);
		close(zin);
	}
	long endTime=System.currentTimeMillis();
	System.out.println("耗费时间： "+(endTime-startTime)+" ms");
}

public static void main(String[] args){
	try{
		Util.main(args);
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
