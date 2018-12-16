package jf;

import static jf.Util.*;

public class StructM{


//aim m-valure; reduce range by i;
public static void bubbleSort(int[] a){
	int len=a.length, hi=len-1, lo=0;
	for(int i=hi;i>lo;i--) max2submax(a,lo,i);
	//for(int i=lo;i<hi;i++)min2submin(a,i,hi);
}

//aim order ;expand range by i
public static void insertSort(int[] a){
	int len=a.length, lo=0, hi=len-1;
	for(int i=lo+1;i<=hi;i++) min2submin(a,lo,i);
	//for (int i = hi-1; i >= lo; i--) max2submax(a, i, hi);
}


//search in asc arr for k
public static int biSearch(int[] a,int k){
	//if (a == null) return -1;
	int lo=0, hi=a.length-1, mid;
	if(k<a[lo] || k>a[hi]) return -1;
	for(;lo<=hi;){
		mid=(lo+hi)/2;
		if(k==a[mid]) return mid; //cmp center ;not found,change range
		else if(k<a[mid]) hi=mid-1; //顺序，k比找到的小，往下找；
		else lo=mid+1;
	}
	return -1;
}

//有第三个参数，就直接默认是数组逆序；
public static int biSearch(int[] a,int k,boolean desc){
	//if (a == null) return -1;
	int lo=0, hi=a.length-1, mid;
	if(k<a[lo] || k>a[hi]) return -1;
	for(mid=(lo+hi)/2;lo<=hi;mid=(lo+hi)/2)
		if(k==a[mid]) return mid;
		else if(k>a[mid]) hi=mid-1; //逆序，k比找到的大，往下找；
		else lo=mid+1;
	return -1;
}


//递归的方式实现:
public static int biSearchR(int[] a,int des,int lo,int hi){
	int mid=(lo+hi)/2;
	if(des<a[lo] || des>a[hi] || lo>hi) return -1;
	if(des==a[mid]) return mid;
	else if(des<a[mid]) {
		hi--;
		return biSearchR(a,des,lo,hi);
	}else {
		lo++;
		return biSearchR(a,des,lo,hi);
	}
}


public void revarr(int[] a){
	int i, hi=a.length-1;
	for(i=0;i<a.length/2;i++) ex(a,i,hi-i);
}

//3:单链表反转
public static class ListNode{
	int val;
	jf.StructM.ListNode next;

	public static jf.StructM.ListNode reverseList(jf.StructM.ListNode head){
		jf.StructM.ListNode prev=null;
		//ListNode pre; 给一个变量赋予空数值；
		//单纯的对象名代表对象的指针；
		//指向对象的指针就是对象名；
		//对象头，包括对象的类信息，锁信息；
		while(head!=null){
			jf.StructM.ListNode temp=head.next;
			head.next=prev;
			prev=head;
			head=temp;
		}
		return prev;
	}

	ListNode(int x){
		val=x;
	}
}


//递归的方式实现:
//单链表结构不能被一体创建，只能一个个节点地创建；
//
//ListNode head is point to
public jf.StructM.ListNode reverseList(jf.StructM.ListNode head){
	if(head==null || head.next==null)
		return head; //没有子节点和空节点的反转是自身；
	jf.StructM.ListNode prev=reverseList(head.next);//非空有子节点的，1.创建一个节点pre,存放反转后的子节点；
	head.next.next=head;                 //             2.
	head.next=null;
	return prev;
}


/**
 * 选择排序:把最小或者最大的选择出来对于给定的一组记录,经过第一轮比较后得到最小的记录,然后将该记录与第一个记录的
 * 位置进行交换;接着对不包括第一个记录以外的其他记录进行第二轮比较,得到最小的记
 * 录并与第二个记录进行位置交换;重复该过程,直到进行比较的记录只有一个时为止。
 */
public static void selectSort(int[] a){
	int min, len=a.length;

	if(a==null || len<=0) { //记住需要判断输入的数据
		return;
	}
	for(int i=0;i<len;i++){
		min=i;//known min sub
		for(int j=i+1;j<len;j++){
			if(a[j]<a[min]) {
				min=j;
			}
		}
		if(i!=min) ex(a,i,min);
	}
}
// selectSort: rec minSub at last ex;
// selectSort for i in (0,len,1);min=i, j in (i+1,len,1) a[j]<a[min]?min=j: ,min!=i?ex(a,i,min);


/**
 * 快速排序:先分区后排序，有序利于分区。无序分区的过程也可以排序；各区可以自己调用不同方法进行排序；\
 * 如果key选择不好。。。
 */


//懒汉模式:
public static class Singleton{
	private Singleton(){
	}

	private static jf.StructM.Singleton singleton=null;

	public static jf.StructM.Singleton getInstance(){
		if(singleton==null) {
			singleton=new jf.StructM.Singleton();
		}
		return singleton;
	}
}

//饿汉模式:
public static class Singletonh{
	private Singletonh(){
	}

	private static jf.StructM.Singletonh singletonh=new jf.StructM.Singletonh();

	public static jf.StructM.Singletonh getinstance(){
		return singletonh;
	}
}
//线程安全的单例模式:对 getinstance 方法加锁


//实现方式 2:双重检查锁定:对 getinstance 方法加锁+if 判断
public static class Singleton2s{
	private Singleton2s(){
	}

	private static jf.StructM.Singleton2s singleton2s=null;

	public static jf.StructM.Singleton2s getInstance(){
		if(singleton2s==null) {
			synchronized(jf.StructM.Singleton2s.class){
				if(singleton2s==null) {
					singleton2s=new jf.StructM.Singleton2s();
				}
				return singleton2s;
			}

		}
		return singleton2s;
	}
}


//实现方式 3:静态内部类:
public static class Singletonc{
	private static class getInstaceFac{
		private static jf.StructM.Singletonc INSTANCE=new jf.StructM.Singletonc();
	}

	private Singletonc(){
	}

	public static jf.StructM.Singletonc getinstance(){
		return jf.StructM.Singletonc.getInstaceFac.INSTANCE;
	}
}


}






