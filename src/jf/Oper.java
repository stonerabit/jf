package jf;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.ReverseListIterator;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.function.Function;

import static jf.Print.*;

public class Oper{


public static Method getMethod(String absMethodName,Class classtype){
	try{
		if(absMethodName==null) return null;
		else {
			int lastdot=absMethodName.lastIndexOf(".");

			String className="";
			String methodName="";
			className=absMethodName.substring(0,lastdot);
//			printsln(className);
			methodName=absMethodName.substring(lastdot+1);
			Class c=Class.forName(className);
			return c.getMethod(methodName,classtype);
		}
	}catch(Exception e){
		e.printStackTrace();
		printsln("getMethod err");

	}


	return null;
}


public static Method strMethod(String absMethodName){
	return getMethod(absMethodName,String.class);

}

public static Method getMethod(Class clazz,String methodName,Class argType){

	try{
		return clazz.getMethod(methodName,argType);
	}catch(NoSuchMethodException e){
		e.printStackTrace();
	}

	return null;
}

public static Method getMethod(String className,String methodName,Class argType){

	try{
		Class clazz=Class.forName(className);
		return clazz.getMethod(methodName,argType);
	}catch(Exception e){
		e.printStackTrace();
	}

	return null;
}

public static Function method2fun(Method method){
	Function function=(Object object)->{
		try{
			return method.invoke(null,object);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	};
	return function;
}


public static Method fun2method(Function function){
	class TempClass{
		public Object fun(Object o){
			return function.apply(o);
		}
	}
	Method method=null;
	try{
		method=new TempClass().getClass().getMethod("fun",Object.class);
	}catch(NoSuchMethodException e){
		e.printStackTrace();
	}
	return method;
}


public static void oper(Object oper,Object argo){
	try{
		if(oper instanceof java.util.function.Function) oper((Function) oper,argo);
		else if(oper instanceof java.lang.reflect.Method) oper((Method) oper,argo);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("oper err");
	}
}


public static void oper(Function oper,Object o){
	try{
		oper.apply(o);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("oper err");
	}
}

public static void oper(Method oper,Object o){
	try{
		oper.invoke(null,o);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("oper err");
	}
}

public static <T> void iterOper(Iterator it,Object oper){
	try{
		while(it.hasNext()){
			oper(oper,it.next());
		}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("arrOper err");
	}

}

public static void iterOper(Iterator iterator,Predicate pre,Method oper){
	Iterator it=new FilterIterator(iterator,pre);
	iterOper(it,oper);
}

//自定义条件判断
public static Predicate reverse=(Object o)->new StringBuilder(o+"").reverse().toString().equals(o+"");

public static void main(String[] args){
	java.util.List list=new java.util.ArrayList();
	{
		list.add("2");
		list.add("1");
		ReverseListIterator reverseListIterator=new ReverseListIterator(list);
		java.util.Comparator cmp;
		prints(list);
		printiter(reverseListIterator);
		printsln(reverse.evaluate("21"));
		printsln(Mfile.fileTailFilter("java"));
		printsln(getMethod("jf.KB.showDesktopTray",String.class));
	}
}
}