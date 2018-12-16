package jf;

import static jf.Print.*;
import static jf.Reflectcmd.reflectcmd;

public class Util{
//public Class<?> TYPE;
public static String[] args=null;
public static Util tool=null;

public Util(){

}

public Util(String[] args){
	this.args=args;
}

/*************************************normal arr sub and value move**************************************/

public static <T> void ex(T[] a,int n1,int n2){
	//if (a == null) return true;
	T t=a[n1];
	a[n1]=a[n2];
	a[n2]=t;
	//return false;
}

public static void ex(int[] a,int n1,int n2){
	//if (a == null) return false;
	int t=a[n1];
	a[n1]=a[n2];
	a[n2]=t;
	//return true;
}

public static void ex(long[] a,int n1,int n2){
	//if (a == null) return false;
	long t=a[n1];
	a[n1]=a[n2];
	a[n2]=t;
	//return true;
}

public static <T> void swap(T[] a,int n1,int n2){
	ex(a,n1,n2);
}

public static <T extends Comparable<? super T>> boolean min2submin(T[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=hi;i>lo;i--)
		if(a[i].compareTo(a[i-1])<0) {
			ex(a,i,i-1);
			ordered=false;
		}
	return ordered;
}

public static <T extends Comparable<? super T>> boolean max2submin(T[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=hi;i>lo;i--)
		if(a[i].compareTo(a[i-1])>0) {
			ex(a,i,i-1);
			ordered=false;
		}
	return ordered;
}

public static <T extends Comparable<? super T>> boolean min2submax(T[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=lo;i<hi;i++)
		if(a[i].compareTo(a[i+1])<0) {
			ex(a,i,i+1);
			ordered=false;
		}
	return ordered;
}

public static <T extends Comparable<? super T>> boolean max2submax(T[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=lo;i<hi;i++)
		if(a[i].compareTo(a[i+1])>0) {
			ex(a,i,i+1);
			ordered=false;
		}
	return ordered;
}


public static boolean min2submin(int[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=hi;i>lo;i--)
		if(a[i]<a[i-1]) {
			ex(a,i,i-1);
			ordered=false;
		}
	return ordered;
}

public static boolean max2submin(int[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=hi;i>lo;i--)
		if(a[i]>a[i-1]) {
			ex(a,i,i-1);
			ordered=false;
		}
	return ordered;
}


public static boolean min2submax(int[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=lo;i<hi;i++)
		if(a[i]<a[i+1]) {
			ex(a,i,i+1);
			ordered=false;
		}
	return ordered;
}


public static boolean max2submax(int[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=lo;i<hi;i++)
		if(a[i]>a[i+1]) {
			ex(a,i,i+1);
			ordered=false;
		}
	return ordered;
}

public static void min2smin(int[] a,int lo,int hi){
	for(int i=hi;i>lo;i--)
		if(a[i]<a[i-1]) ex(a,i,i-1);
}

public static void max2smin(int[] a,int lo,int hi){
	for(int i=hi;i>lo;i--)
		if(a[i]>a[i-1]) ex(a,i,i-1);
}

public static void min2smax(int[] a,int lo,int hi){
	for(int i=lo;i<hi;i++)
		if(a[i]<a[i+1]) ex(a,i,i+1);
}

public static void max2smax(int[] a,int lo,int hi){
	for(int i=lo;i<hi;i++)
		if(a[i]>a[i+1]) ex(a,i,i+1);
}

public static void cparr(int[] a1,int lo1,int hi1,int[] a2,int lo2,int hi2,boolean head){
	int len1=hi1-lo1, len2=hi2-lo2;
	if(len1>len2 || a1==null || a2==null) return;
	if(head) for(int i=0;i<hi1-lo1;i++) a2[lo2+i]=a1[lo1+i];
	else if(!head) for(int i=0;i<hi1-lo1+1;i++) a2[hi2-i]=a1[hi1-i];
}

public static void cparr(int[] a1,int lo1,int hi1,int[] a2,int lo2,int hi2){
	cparr(a1,lo1,hi1,a2,lo1,hi2,true);
}

public static void cparr(int[] a1,int[] a2){
	int lo1=0, hi1=a1.length-1, lo2=0, hi2=a2.length-1;
	cparr(a1,lo1,hi1,a2,lo1,hi2,true);
}

public static void cparr(int[] a1,int[] a2,boolean head){
	int lo1=0, hi1=a1.length-1, lo2=0, hi2=a2.length-1;
	cparr(a1,lo1,hi1,a2,lo1,hi2,head);
}

/**
 * long to byte[j]
 */
public static void long2ba(long l,byte[] ba,int lo){
	ba[lo]=(byte) (l&0xffL);
	ba[lo+1]=(byte) ((l >>> 8)&0xffL);
	ba[lo+2]=(byte) ((l >>> 16)&0xffL);
	ba[lo+3]=(byte) ((l >>> 24)&0xffL);
}

/**
 * long to byte[j]
 */
public static void int2ba(int i,byte[] ba,int lo){
	ba[lo]=(byte) (i&0xffL);
	ba[lo+1]=(byte) ((i >>> 8)&0xffL);
}

public static void ba42long(byte[] ba,int lo,long l){
	l=byte2int(ba[lo])|(byte2int(ba[lo+1])<<8)|(byte2int(ba[lo+2])<<16)|(byte2int(ba[lo+3])<<24);
}

/**
 * @param ba
 * @param loba lo of ba
 * @param hiba hi of ba
 * @param la
 * @param lola lo of la
 */
public static void ba2la(byte[] ba,int loba,int hiba,long[] la,int lola){
	for(;loba<hiba;lola++,loba+=4)
		la[lola]=byte2int(ba[loba])|(byte2int(ba[loba+1])<<8)|(byte2int(ba[loba+2])<<16)|(byte2int(ba[loba+3])<<24);
}

public static long byte2int(byte b){
	return b<0 ? b&0x7F+128 : b;/*  return byte b as int b,then auto long;*/
}
/*************************************up is normal arr sub and value move*************************************/


/*************************************down is  normal prints***************************************/
public static String now(){

	java.util.Date now=java.util.Calendar.getInstance().getTime();
	return date2dots(now);
}

public static String date2dots(java.util.Date date){
	long mills=date.getTime()%1000;
	String year="20"+date.getYear()%100;
	String nowStr=year+"."+head0(date.getMonth(),2)+"."+head0(date.getDay(),2)+"."+head0(date.getHours(),2)+"."+head0(date.getMinutes(),2)+"."+head0(date.getSeconds(),2)+"."+head0(mills,3);
	return nowStr;
}

public static String calendar2dots(java.util.Calendar calendar){
	return date2dots(calendar.getTime());
}


public static void encrypt(String srcFile,String destFile){
	java.io.FileInputStream fis=null;
	java.io.FileOutputStream fos=null;

	try{
		fis=new java.io.FileInputStream(srcFile);
		fos=new java.io.FileOutputStream(destFile);

		int temp=-1;
		while((temp=fis.read())!=-1){
			fos.write(temp^0xff);  //取反操作
		}

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(fis!=null) fis.close();
		}catch(java.io.IOException e){
			e.printStackTrace();
		}
		try{
			if(fos!=null) fos.close();
		}catch(java.io.IOException e){
			e.printStackTrace();
		}
	}
}

public static byte[] fs2ba(String rootDir,String classname){
	String path=rootDir+"/"+classname.replace('.','/')+".class";
	java.io.InputStream is=null;
	byte[] ba=null;
	try{
		is=new java.io.FileInputStream(path);  //fis直接构建；
		ba=is2ba(is);
	}finally{
		try{
			if(is!=null) is.close();
		}catch(java.io.IOException e){
			e.printStackTrace();
		}
		return ba;
	}
}

public static byte[] is2ba(java.io.InputStream is){
	java.io.ByteArrayOutputStream baos=new java.io.ByteArrayOutputStream(); //输出流出生在内存中；从流到数组；
	byte[] ba=null;
	try{

		byte[] buffer=new byte[1024];
		int temp;
		while((temp=is.read(buffer))!=-1) baos.write(buffer,0,temp);
		ba=baos.toByteArray();
	}catch(Exception e){
		e.printStackTrace();

	}finally{

		try{
			if(baos!=null) baos.close();
		}catch(java.io.IOException e){
			e.printStackTrace();
		}
		return ba;
	}
}

public static byte[] url2ba(String rootUrl,String classname){

	String path=rootUrl+"/"+classname.replace('.','/')+".class";
	java.io.InputStream is=null;
	byte[] ba=null;

	try{
		java.net.URL url=new java.net.URL(path);
		is=url.openStream();  //URL
		ba=is2ba(is);
	}finally{
		try{
			if(is!=null) is.close();
		}catch(java.io.IOException e){
			e.printStackTrace();
		}
		return ba;
	}

}

public static void regClass(String str){
	try{
		Class.forName(str);
	}catch(ClassNotFoundException e){
		System.out.println(str+"reg error");
		e.printStackTrace();
	}
}// regClass

public static void closeAll(java.sql.ResultSet rs,java.sql.Statement pstmt,java.sql.Connection conn){
	try{
		if(rs!=null) {
			rs.close();
			rs=null;
		}
		if(pstmt!=null) {
			pstmt.close();
			pstmt=null;
		}
		if(conn!=null) {
			conn.close();
			conn=null;
		}
	}catch(Exception e){

		e.printStackTrace();
	}

}// closeAll

public static void close(java.sql.ResultSet rs){
	try{
		if(rs!=null) {
			rs.close();
			rs=null;
		}

	}catch(Exception e){

		e.printStackTrace();
	}

}// close(ResultSet rs)

public static void close(java.sql.Statement stmt){
	try{
		if(stmt!=null) {
			stmt.close();
			stmt=null;
		}

	}catch(Exception e){

		e.printStackTrace();
	}

}// close(ResultSet rs)

public static void close(java.sql.Connection conn){
	try{
		if(conn!=null) {
			conn.close();
			conn=null;
		}

	}catch(Exception e){

		e.printStackTrace();
	}
}

public static void close(java.io.Closeable closeable){
	try{
		if(null!=closeable) {
			if(closeable instanceof java.io.Flushable) ((java.io.Flushable) closeable).flush();
			closeable.close();
			closeable=null;
		}
	}catch(java.io.IOException e){
		e.printStackTrace();
	}
}

public static String sqlDateNow(){

	return new java.sql.Date(new java.util.Date().getTime()).toString();
}


public static String[] removeHead(String[] args){
	String[] args2=new String[args.length-1];
	for(int i=1;i<=args.length-1;i++){
		args2[i-1]=args[i];
		//prints(i-1+":"+args2[i-1]);
	}
	args=args2;
	return args;
}


public static void main() throws Exception{
	try{
		printhr();
		printpid();
		printhd();
		printsln(now());
		printsln("");
		//exec("day");

	}catch(Exception e){
		e.printStackTrace();

	}
}


public static void main(String[] args) throws Exception{

	main();
	try{
		reflectcmd(args);

	}catch(Exception e){
		e.printStackTrace();
	}
}
}
