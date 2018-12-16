package jf;

import static jf.Print.*;

public class Reflectcmd{
public static StringBuilder cmd_help(String classname){
	StringBuilder cmd_help=new StringBuilder();
	cmd_help.append("you can use as:\n");
	cmd_help.append(""+"java -cp /jar/jf.jar "+classname+" copy src dest "+"\n");
	cmd_help.append(""+"java -cp /jar/jf.jar "+classname+" copyl src dest  //make line num for lines"+"\n");
	cmd_help.append(""+"java -cp /jar/jf.jar "+classname+" copyDir src dest  //cp src into dest/src"+"\n");
	cmd_help.append(""+"java -cp /jar/jf.jar "+classname+" cmd arg1 arg2 //mount of arg must <=3  >=0 "+"\n");
	return cmd_help;
}/*args 里面不含本次调用的classname methodname; 构建函数的时候不能把缺省参数考虑进来,缺省会使结构很复杂；*/

public static void reflectcmd(String[] args) throws Exception{
	if(null==args || args.length<1) reflectcmd();
	else if(args.length==1) reflectcmd(args[0]);
	else if(args.length==2) reflectcmd(args[0],args[1]);
	else if(args.length >= 3) {
		String[] args2=new String[args.length-2];
		System.arraycopy(args,2,args2,0,args.length-2);
		reflectcmd(args[0],args[1],args2);
	}
}

public static void reflectcmd(String classname,String methodname,String[] args) throws Exception{
	StringBuilder cmd_help=cmd_help(classname);
	if(null==classname || ""==classname || " "==classname) classname="jf.Util";
	Class c=Class.forName(classname);
	try{
		if(methodname.equals("") || methodname.equals(" ") || methodname.equals(null)) {
			printhr();
			prints("no cmd \n"+cmd_help);
			printhr();
		}else if(args==null || args.length<1) {
			java.lang.reflect.Method f1=c.getMethod(methodname);
			f1.invoke(c);
		}else if(args.length >= 3) {
			java.lang.reflect.Method f1=c.getMethod(methodname,String.class,String.class,String[].class);
			String classname2=args[0];
			String methodname2=args[1];
			String[] args2=new String[args.length-2];
			System.arraycopy(args,2,args2,0,args.length-2);
			f1.invoke(c,classname2,methodname2,args2);
		}else if(args.length==2) {
			java.lang.reflect.Method f1=c.getMethod(methodname,String.class,String.class);
			String classname2=args[0];
			String methodname2=args[1];
			f1.invoke(c,classname2,methodname2);
		}else if(args.length==1) {
			java.lang.reflect.Method f1=c.getMethod(methodname,String.class);
			String classname2=args[0];
			f1.invoke(c,classname2);
		}
	}catch(Exception e){
		e.printStackTrace();
		printsln("reflectcmd err");
	}
}

public static void reflectcmd(String classname,String methodname) throws Exception{
	reflectcmd(classname,methodname,new String[0]);
}

public static void reflectcmd(String classname) throws Exception{
	reflectcmd(classname,"main",new String[0]);
}

public static void reflectcmd() throws Exception{

}
}