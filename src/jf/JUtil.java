package jf;


public class JUtil{
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


/*************************************up is normal arr sub and value move*************************************/


/*************************************down is  normal prints***************************************/
public static String now(){
	java.util.Date now;
	now=java.util.Calendar.getInstance().getTime();
	String nowStr=now.getYear()+"."+now.getMonth()+"."+now.getDay()+"."+now.getHours()+"."+now.getMinutes()+"."+now.getSeconds();
	return nowStr;
}

public static void printsln(String string_args){
	System.out.println(string_args);
}

public static void prints(String string_args){
	System.out.print(string_args);
}

public static <T> void prints(T o){
	System.out.print(o+"");
}

public static <T> void printsln(T o){
	System.out.println(o+"");
}

public static <T> void prints(T[] a,String str){
	if(a==null) return;

	for(int i=0;i<a.length;i++)
		prints(a[i]+str);
}

public static <T> void printsln(T[] a,String str){
	if(a==null) return;

	for(int i=0;i<a.length;i++)
		printsln(a[i]+str);
}

public static <T> void prints(T[] a,char ch){
	if(a==null) return;

	for(int i=0;i<a.length;i++)
		prints(a[i]+""+ch);
}

public static <T> void printsln(T[] a,char ch){
	if(a==null) return;

	for(int i=0;i<a.length;i++)
		printsln(a[i]+""+ch);
}


public static <T> void prints(T[] a){
	prints(a,'\n');
}

public static <T> void printsln(T[] a){
	prints(a,'\n');
}

public static void prints(int[] a,String str){
	if(a==null) return;

	for(int i=0;i<a.length;i++)
		prints(a[i]+str);
}

public static void printsln(int[] a,String str){
	if(a==null) return;

	for(int i=0;i<a.length;i++)
		printsln(a[i]+str);
}

public static void prints(int[] a,char ch){
	if(a==null) return;

	for(int i=0;i<a.length;i++)
		prints(a[i]+""+ch);
}

public static void printsln(int[] a,char ch){
	if(a==null) return;

	for(int i=0;i<a.length;i++)
		printsln(a[i]+""+ch);
}

public static void prints(int[] a){
	prints(a,'\n');
}

public static void printsln(int[] a){
	prints(a,'\n');
}


public static void printc(char ch_args){
	System.out.print(ch_args);
}

public static void printcln(char ch_args){
	System.out.println(ch_args);
}

public static void printi(long int_args){
	System.out.print(int_args);
}

public static void printiln(long int_args){
	System.out.println(int_args);
}

public static void printl(long long_args){
	System.out.print(long_args);
}

public static void printlln(long long_args){
	System.out.println(long_args);
}


public static void printnch(long largs,long i2){
	for(int i=1;i<=largs;i++)
		System.out.print(i2);
}

public static void printnchln(long largs,long i2){
	for(int i=1;i<=largs;i++)
		System.out.print(i2);
	System.out.println();
}

public static void printnch(double largs,long i2){
	for(int i=1;i<=(long) largs;i++)
		System.out.print(i2);
}

public static void printnchln(double largs,long i2){
	for(int i=1;i<=(long) largs;i++)
		System.out.print(i2);
	System.out.println();

}

public static String nch(long largs,char i2){

	String nch="";
	for(int i=1;i<=largs;i++)
		nch+=i2;
	return nch;
}

public static String nch(long largs,String i2Str){
	String nch="";
	char i2=i2Str.charAt(0);
	for(int i=1;i<=largs;i++)
		nch+=i2;
	return nch;
}

public static String nch(double largs,String i2Str){
	String nch="";
	char i2=i2Str.charAt(0);
	for(int i=1;i<=(long) largs;i++)
		nch+=i2;
	return nch;
}

public static void printnch(int nargs,int int_args){
	char chargs=(char) int_args;
	for(int i=1;i<=nargs;i++)
		System.out.print(chargs);
}

public static void printnchln(int nargs,int int_args){
	char chargs=(char) int_args;
	for(int i=1;i<=nargs;i++)
		System.out.print(chargs);
	System.out.println();

}


public static void printnch(int nargs,String string_args){
	char chargs=string_args.charAt(0);
	for(int i=1;i<=nargs;i++)
		System.out.print(chargs);
}

public static void printnchln(int nargs,String string_args){
	char chargs=string_args.charAt(0);
	for(int i=1;i<=nargs;i++)
		System.out.print(chargs);
	System.out.println();

}

public static void printnch(double nargs,String string_args){
	char chargs=string_args.charAt(0);
	for(int i=1;i<=(long) nargs;i++)
		System.out.print(chargs);
}

public static void printnchln(double nargs,String string_args){
	char chargs=string_args.charAt(0);
	for(int i=1;i<=(long) nargs;i++)
		System.out.print(chargs);
	System.out.println();
}

public static String wideStr(String StrArgs,long n,long spW){
	int LEN=StrArgs.length();
	if(StrArgs.length()<n)
		for(int i=1;i<=(n-LEN)*spW;i++)
			StrArgs+=" ";
	return StrArgs;
}

public static void printhr(int n,String string_args){
	char ch=string_args.charAt(0);
	prints("\n");
	printnch(100,ch);
	prints("\n");
}

public static void printhr(){
	char ch='_';
	prints("\n");
	printnch(100,ch);
	prints("\n");
}

public static void printsClass(Class<?> c){
	printhr();
	prints("class of "+c+":\n");
	for(Class e : c.getDeclaredClasses()) prints(e+"\n");
	prints("methods of "+c+":\n");
	for(java.lang.reflect.Method e : c.getDeclaredMethods()) prints(e+"\n");
	prints("fields of "+c+":\n");
	for(java.lang.reflect.Field e : c.getDeclaredFields()) prints(e+"\n");
	prints("constructor of "+c+":\n");
	for(java.lang.reflect.Constructor e : c.getDeclaredConstructors()) prints(e+"\n");
	printhr();
}

public static void printSys(){
	printhr();
	prints("System.getProperty "+":\n");
	for(java.util.Map.Entry<Object, Object> entry : System.getProperties().entrySet())
		prints(entry.getKey()+"\t=\t"+entry.getValue()+"\n");
	printhr();
}


/************************************* up is normal prints***************************************/


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

public static String sqlDateNow(){

	return new java.sql.Date(new java.util.Date().getTime()).toString();
}

public static void main(String[] args) {
	try{
		Util.main(args);
		//Thread.sleep(600000);
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
