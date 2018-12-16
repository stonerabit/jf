package jf;

public class Print{

public static void printnow(){
	java.util.Date now=java.util.Calendar.getInstance().getTime();
	prints(""+now);
}

public static void printlnnow(){
	java.util.Date now=java.util.Calendar.getInstance().getTime();
	printsln(""+now);
}


public static String head0(int num,int n){
	String numstr=num+"";
	if(numstr.length() >= n || n<=0) return numstr;
	else return nch(n-numstr.length(),'0')+num;
}

public static String head0(long num,int n){
	String numstr=num+"";
	if(numstr.length() >= n || n<=0) return numstr;
	else return nch(n-numstr.length(),'0')+num;
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

public static String wideStr(String StrArgs){

	return wideStr(StrArgs,16,1);
}

public static String wideStr(String StrArgs,long n){

	return wideStr(StrArgs,n,1);
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

public static void printsClass(String classname){
	try{
		Class c=Class.forName(classname);
		printsClass(c);
	}catch(Exception e){
		e.printStackTrace();
	}


}

public static void printclassf(String classname){
	try{
		Class c=Class.forName(classname);
		if(c.getDeclaredMethods().length>0) {
			prints("\nmethods of "+c+":\n");
			for(java.lang.reflect.Method e : c.getDeclaredMethods()) prints(e+"\n");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}

public static void printsClass(Class<?> c){
	printhr();
	printsln(c.toString()+" info:");
	if(c.getDeclaredClasses().length>0) {
		prints("member class of "+c+":\n");
		for(Class e : c.getDeclaredClasses()) prints(e+"\n");
	}


	if(c.getDeclaredMethods().length>0) {
		prints("\nmethods of "+c+":\n");
		for(java.lang.reflect.Method e : c.getDeclaredMethods()) prints(e+"\n");
	}


	if(c.getDeclaredFields().length>0) {
		prints("\nfields of "+c+":\n");
		for(java.lang.reflect.Field e : c.getDeclaredFields()) prints(e+"\n");
	}

	prints("\nconstructor of "+c+":\n");
	for(java.lang.reflect.Constructor e : c.getDeclaredConstructors()) prints(e+"\n");

	if(c.getInterfaces().length>0) {
		prints("\nInterface in "+c+":\n");
		for(Class e : c.getInterfaces()) printsln(e);
	}

	if(c.getDeclaredClasses().length>0) {
		prints("\ndetail of DeclaredClasses as members in "+c+":");
		for(Class e : c.getDeclaredClasses()) printsClass(e);
	}

	printhr();
}

public static void printSys(){
	printhr();
	prints("System.getProperty "+":\n");
	for(java.util.Map.Entry<Object, Object> entry : System.getProperties().entrySet())
		prints(entry.getKey()+"\t=\t"+entry.getValue()+"\n");
	printhr();
}

public static <T extends Iterable<? super T>> void printIterable(T iterable){
	for(Object o : iterable) printsln(o);
}

public static void printIter(Iterable iterable){
	printiter(iterable.iterator());
}

public static void printiter(Iterable iterable){
	printiter(iterable.iterator());
}

public static void printIter(java.util.Iterator iterable){
	printiter(iterable);
}

public static void printiter(java.util.Iterator iterable){
	printhr(80,"_");
	while(iterable.hasNext()) printsln(iterable.next());
	printhr(80,"_");
}

public static void printProperties(java.util.Properties properties){
	java.util.Enumeration propertyNames=properties.propertyNames();
	String name=null;
	while(propertyNames.hasMoreElements()){
		name=(String) propertyNames.nextElement();
		printsln(name+"="+properties.getProperty(name));
	}
}

public static void printpid(){
	int pid=Integer.valueOf(java.lang.management.ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
	printsln(pid);
}

public static void printhd(){
	Thread th=Thread.currentThread();
	printsln(""+th.getId()+":"+th+" load by "+th.getContextClassLoader());
}


/************************************* up is normal prints***************************************/
}
