package jf;


/**
 * A class that contains several sorting routines,
 * implemented as static methods.
 * Arrays are rearranged with smallest item first,
 * using compareTo.
 *
 * @author JinFeng
 */
public final class Sort{
public static final <T> void ex(T[] a,int n1,int n2){
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

public static <AnyType> void swapReferences(AnyType[] a,int index1,int index2){
	AnyType tmp=a[index1];
	a[index1]=a[index2];
	a[index2]=tmp;
}


public static <T extends Comparable<? super T>> void bubbleSort(T[] a){
	if(a==null) return;
	int i, len=a.length;
	for(i=len-1;i>0;i--) max2submax(a,0,i);
}

public static <T extends Comparable<? super T>> void proBubbleSort(T[] a){
	if(a==null) return;
	int i, len=a.length;
	boolean ordered=false;
	for(i=len-1;i>0;i--)
		if(!ordered) ordered=max2submax(a,0,i);
}

//handle a[lo-hi] in compOrder(default isup) result in resultOrder(default isdown)
//max2submax(a,lo,hi) max2submin
public static <T extends Comparable<? super T>> void mm(T[] a,int lo,int hi,boolean resultOrder,boolean compOrder){
	if(compOrder && resultOrder) max2submax(a,lo,hi);
	else if(compOrder && !resultOrder) min2submax(a,lo,hi);
	else if(!compOrder && resultOrder) min2submin(a,lo,hi);
	else if(!compOrder && !resultOrder) max2submin(a,lo,hi);
}

public static final <T extends Comparable<? super T>> boolean min2submin(T[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=hi;i>lo;i--)
		if(a[i].compareTo(a[i-1])<0) {
			ex(a,i,i-1);
			ordered=false;
		}
	return ordered;
}

public static final <T extends Comparable<? super T>> boolean max2submin(T[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=hi;i>lo;i--)
		if(a[i].compareTo(a[i-1])>0) {
			ex(a,i,i-1);
			ordered=false;
		}
	return ordered;
}

public static final <T extends Comparable<? super T>> boolean min2submax(T[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=lo;i<hi;i++)
		if(a[i].compareTo(a[i+1])<0) {
			ex(a,i,i+1);
			ordered=false;
		}
	return ordered;
}

public static final <T extends Comparable<? super T>> boolean max2submax(T[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=lo;i<hi;i++)
		if(a[i].compareTo(a[i+1])>0) {
			ex(a,i,i+1);
			ordered=false;
		}
	return ordered;
}


public static final boolean min2submin(int[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=hi;i>lo;i--)
		if(a[i]<a[i-1]) {
			ex(a,i,i-1);
			ordered=false;
		}
	return ordered;
}

public static final boolean max2submin(int[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=hi;i>lo;i--)
		if(a[i]>a[i-1]) {
			ex(a,i,i-1);
			ordered=false;
		}
	return ordered;
}

public static final boolean min2submax(int[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=lo;i<hi;i++)
		if(a[i]<a[i+1]) {
			ex(a,i,i+1);
			ordered=false;
		}
	return ordered;
}

public static final boolean max2submax(int[] a,int lo,int hi){
	boolean ordered=true;
	for(int i=lo;i<hi;i++)
		if(a[i]>a[i+1]) {
			ex(a,i,i+1);
			ordered=false;
		}
	return ordered;
}

public static final void min2smin(int[] a,int lo,int hi){
	for(int i=hi;i>lo;i--)
		if(a[i]<a[i-1]) ex(a,i,i-1);
}

//    public static void selectSort(int[] a, boolean asc) {
//        int m, len = a.length;
//        for (int i = 0; i < len; i++) {
//            //min2subminbym(a,lo,hi)  get min by msub;
//            //max2submaxbym(a,lo,hi)  get max by msub;
//            m = i;
//            for (int j = i + 1; j < len; j++)
//                if (a[j] < a[m]) m = j;
//            if (i != m) ex(a, i, m);
//        }
//    }

public static final void m2sminbys(int[] a,int lo,int hi){
	int i, j, m;
	for(i=hi,m=i;i>lo;i--){//2smax
		for(j=lo,m=i;j<i;j++)// m cmp j(lo,i)
			if(a[m]<a[j]) m=j+1;//get msub max
		if(m!=i) ex(a,m,j);
	}
}

public static final void max2smin(int[] a,int lo,int hi){
	for(int i=hi;i>lo;i--)
		if(a[i]>a[i-1]) ex(a,i,i-1);
}

public static final void min2smax(int[] a,int lo,int hi){
	for(int i=lo;i<hi;i++)
		if(a[i]<a[i+1]) ex(a,i,i+1);
}

public static final void max2smax(int[] a,int lo,int hi){
	for(int i=lo;i<hi;i++)
		if(a[i]>a[i+1]) ex(a,i,i+1);
}

public static void proBubbleSort(int[] a){
	proBubbleSort(a,0,a.length-1);
}

public static final void proBubbleSort(int[] a,int lo,int hi){
	if(a==null) return;
	int i, len=a.length;
	boolean ordered=false;
	for(i=hi;i>lo;i--)
		if(!ordered) ordered=max2submax(a,lo,i);
}

public static <T extends Comparable<? super T>>
void insertionSort(T[] a){
	int j, i, len=a.length;
	for(i=0;i<len;i++)
		min2submin(a,0,i);

//            for (j = i; j > 0; j--)
//                if (!(a[j].compareTo(a[j - 1]) > 0)) ex(a, j, j - 1);
	//begin with sorted; insert external to zhe right position;expand range;
	//min2submin()

//        for (j = 0; j < i; j++)
//            if (!(a[j].compareTo(a[j + 1]) < 0)) ex(a, j, j + 1);
	//begin with sorted; insert external to zhe right position;expand range;
	//max2submax()
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

//    public static <AnyType extends Comparable<? super AnyType>>
//    void shellsort(AnyType[] a) {
//        int j;
//
//        for (int gap = a.length / 2; gap > 0; gap /= 2)
//            for (int i = gap; i < a.length; i++) {
//                AnyType tmp = a[i];
//                for (j = i; j >= gap &&
//                        tmp.compareTo(a[j - gap]) < 0; j -= gap)
//                    a[j] = a[j - gap];
//                a[j] = tmp;
//            }
//    }

//    /**
//     * shellSortReduce()
//     * inline fun replace exchange codes
//     *
//     * */
//    public static <AnyType extends Comparable<? super AnyType>>
//    void shellsortr(AnyType[] a) {
//        int gap,i,j;
//        for (gap = a.length / 2; gap > 0; gap /= 2)
//            //gap 2/2=1 1/2=0 3/2=1;end at 0;last gap ==1;i=1;at the end finally insertSort(a);
//            for ( i = gap; i < a.length; i++) {
//                for (j = i; j >= gap; j =j-gap)
//                    if (a[j].compareTo(a[j - gap]) < 0) ex(a, j, j - gap);
//            }
//    }


/**
 * Internal method for heapsort.*******************************************************************************
 */
private static final int lChild(int i){
	return 2*i+1;
}

// n为度，lChild为子节点数组头，i初始为当前节点指针，i树数据结构第归指针；child为节点迭代指针，从左节点开始；
private static <T extends Comparable<? super T>>
void percDown(T[] a,int i,int n_arg){
	int child;
	T key;
	for(key=a[i];lChild(i)<n_arg;i=child){ //头节点复制为热模；有范围内的子节点；第归子节点逻辑；
		child=lChild(i);
		if(child!=n_arg-1 && a[child].compareTo(a[child+1])<0) child++;
		if(key.compareTo(a[child])<0) a[i]=a[child];
		else break;
	}
	a[i]=key;
}

//完全二叉树m2p极值进当前节点max2p min2p
private static <T extends Comparable<? super T>>
void m2p(T[] a,int p_arg,int hi){
	max2p(a,p_arg,hi);
}

private static final <T extends Comparable<? super T>>
void max2p(T[] a,int p_arg,int hi){
	T key;
	int p=p_arg;
	for(key=a[p_arg];lChild(p)<hi;){ //当前处理指针先后顺序问题
		p=lChild(p);
		if(p<hi && a[p].compareTo(a[p+1])<0) p++;
		if(key.compareTo(a[p])<0) a[p_arg]=a[p];
		else break;
	}
	a[p]=key;
}

//min2p
private static <T extends Comparable<? super T>>
void m2p(T[] a,int p_arg,int hi,boolean desc){
	T key;
	int p=p_arg;
	for(key=a[p_arg];lChild(p)<hi;){ //当前处理指针先后顺序问题
		p=lChild(p);
		if(p<hi && a[p].compareTo(a[p+1])>0) p++;
		if(key.compareTo(a[p])<0) a[p_arg]=a[p];
		else break;
	}
	a[p]=key;
}


public static <T extends Comparable<? super T>>
void heapSort(T[] a){
	for(int i=a.length/2-1;i >= 0;i--) max2p(a,i,a.length);
	for(int i=a.length-1;i>0;i--){
		ex(a,0,i);
		max2p(a,0,i);
	}
}

//校验 hi/2初始数据微调；调整整个数据结构；
public static <T extends Comparable<? super T>>
void heapSort(T[] a,int lo,int hi){
	for(int i=(hi+1)/2;i >= 0;i--) max2p(a,i,hi);
	for(int i=(hi+1)/2;i>0;i--){
		ex(a,0,i);
		max2p(a,0,i);
	}
}


public static void heapSort(int[] arr){
	for(int i=arr.length/2-1;i >= 0;i--) m2p(arr,i,arr.length);//二分，三元，max2submin；大顶堆；
	//缩减范围，第归 执行make p m ： min2p; max2p
	for(int i=arr.length-1;i>0;i--){
		ex(arr,0,i);
		m2p(arr,0,i);
	}
}


//二分，三元，max2submin；大顶堆； make p m ： min2p; max2p
//在数组中获取tree节点，并实施序：顶序；
public static void m2p(int[] a,int lo,int length){
	int buket=a[lo];
	for(int k=lo*2+1;k<length;k=k*2+1,lo=k){
		if(k+1<length && a[k]<a[k+1]) k++;//k 指向大哥 选择大哥或者小弟；
		if(a[k]>buket) a[lo]=a[k];
		else break;// 不迭代到底，只有建立大堆顶部的时候，另写一段迭代到底的代码；
	}
	a[lo]=buket;//缓存数据进入上级；
}

/********************up is heap sort************************************************************/

/***************down is Mergesort algorithm.***************************************************/
public static <T extends Comparable<? super T>>
void mergeSort(T[] a){
	int hi=a.length-1, lo=0, len=a.length;
	T[] tmpArray=(T[]) new Comparable[len];
	mergeSort(a,tmpArray,lo,hi);
}

private static <T extends Comparable<? super T>>
void mergeSort(T[] a,T[] tmpArray,int lo,int hi){
	if(lo<hi) {
		int center=(lo+hi)/2;
		mergeSort(a,tmpArray,lo,center);
		mergeSort(a,tmpArray,center+1,hi);
		merge(a,tmpArray,lo,center+1,hi);
	}
}

public static <T extends Comparable<? super T>> void merge(T[] a,T[] r,int lo,int mid,int hi){
	int pl=mid, pr=mid+1, p=lo;
	/*p:r的读写指针*/
	while(pl<=mid && pl<=hi) r[p++]=(a[pl].compareTo(a[pr])<0) ? a[pl++] : a[pr++];
	while(pl<=mid) r[p++]=a[pl++];
	while(pr<=hi) r[p++]=a[pr++];

	for(p=lo;p<=hi;p++) a[p]=r[p];
}

//cp a1[lo1,hi1] to a2[lo2,hi2] head
//cparr default len2>len1 Notnull arr;
public static final void cparr(int[] a1,int lo1,int hi1,int[] a2,int lo2,int hi2,boolean head){
	int len1=hi1-lo1, len2=hi2-lo2;
	if(len1>len2 || a1==null || a2==null) return;
	if(head) for(int i=0;i<hi1-lo1;i++) a2[lo2+i]=a1[lo1+i];
	else if(!head) for(int i=0;i<hi1-lo1+1;i++) a2[hi2-i]=a1[hi1-i];
}

public static final void cparr(int[] a1,int lo1,int hi1,int[] a2,int lo2,int hi2){
	cparr(a1,lo1,hi1,a2,lo1,hi2,true);
}

public static final void cparr(int[] a1,int[] a2){
	int lo1=0, hi1=a1.length-1, lo2=0, hi2=a2.length-1;
	cparr(a1,lo1,hi1,a2,lo1,hi2,true);
}

public static final void cparr(int[] a1,int[] a2,boolean head){
	int lo1=0, hi1=a1.length-1, lo2=0, hi2=a2.length-1;
	cparr(a1,lo1,hi1,a2,lo1,hi2,head);
}

//a2[pa2,a2.length-1] && a2.length-pa2-1>a1.length-1 a2最后一位存数组的读写上限指针

public static void mergea(int[] a1,int mid){
	cparr(a1,0,mid,a1,mid+1,a1.length-1);

}

public static void merge2a(int[] a1,int[] a2,int pa2){
	cparr(a1,0,a1.length-1,a2,a2[pa2],a2.length-2);
	a2[a2.length-1]=pa2+a1.length;
}

public static void merge2a(int[] a1,int[] a2,int[] r){
	merge2a(a1,0,a1.length-1,a2,0,a2.length-1,r,0,r.length-1);
}

// merge a1[lo1,hi1] a2[lo2,hi2] to a3[lo3,hi3] from head
public static void merge2a(int[] a1,int lo1,int hi1,int[] a2,int lo2,int hi2,int[] a3,int lo3,int hi3){
	int len1=a1.length, len2=a2.length, len3=a3.length;
	int pa1=0, pa2=0, pa3=0;
	proBubbleSort(a1,lo1,hi1);
	proBubbleSort(a2,lo2,hi2);
	//a12min2rsubmin
	if(lo1<=pa1 && lo2<=pa2) {
		while(pa1<=hi1 && pa2<=hi2) a3[pa3++]=(a1[pa1]<a2[pa2]) ? a1[pa1++] : a2[pa2++];
		while(pa1<=hi1) a3[pa3++]=a1[pa1++];
		while(pa2<=hi2) a3[pa3++]=a2[pa1++];
	}
}

/***************up is Mergesort algorithm.***************************************************/


//插入排序不能优化跳过已经有序的序列，对于没有那么混乱的数据来说，proBububleSort更优
public static <AnyType extends Comparable<? super AnyType>>
void insertionSort(AnyType[] a,int lo,int hi){
	int i, j;
	for(i=lo;i<hi;i++){
		min2submin(a,lo,hi);
//           for (j = i; j > left ; j--)
//             if (a[j].compareTo(a[j - 1]) < 0) ex(a,j,j-1);
//           max2submax(a,left,right);
	}
}

/*************************down is selectSort****************************************/
//get m from a[lo,hi];asc?getmax():getmin()
public static final int slmaxs(int[] a){
	return slmaxs(a,0,a.length-1);
}

public static final int slmins(int[] a){
	return slmins(a,0,a.length-1);
}

public static final int slmaxs(int[] a,int lo,int hi){
	int i, m=lo;
	for(i=lo;i<hi;i++) if(a[m]<a[i+1]) m=i+1;
	return m;
}

public static final int slmins(int[] a,int lo,int hi){
	int i, m=lo;
	for(i=lo;i<hi;i++) if(a[m]>a[i+1]) m=i+1;
	return m;
}


public static final void slmax2smax(int[] a,int lo,int hi){
	int m=slmaxs(a,lo,hi);
	if(m!=hi) ex(a,m,hi);
}

public static final void slmin2smin(int[] a,int lo,int hi){
	int m=slmins(a,lo,hi);
	if(m!=lo) ex(a,m,lo);
}

//head
public static void selectSort(int[] a,int lo,int hi){
	for(int i=lo;i<hi;i++) slmin2smin(a,i,hi);
}

//tail
public static void selectSort(int[] a,int lo,int hi,boolean tail){
	if(tail) for(int i=hi;i>lo;i--) slmax2smax(a,lo,i);
}
/***************************up is selectSort****************************************/

/*****************************down is qsort************/
/**
 * 如果数量小于10，直接调用常规排序
 * 否则，三元切分为块级有序的两个块，并对两个块进行第归调用快速排序
 * <p>
 * 数据分布比较偏的时候会退化为调用的常规排序：proBubbleSort;
 * 快速排序有非第归的写法吗？
 */
public static void qsort(int[] a,int lo,int hi){
	if(a.length<10) proBubbleSort(a,lo,hi);
	else {
		int p;
		p=part2(a,lo,hi);    //  切分为块级有序的两个块，返回切分点索引号；一般是在差不多中间的位置。
		qsort(a,lo,p-1);  //  对子块进行第归快速排序；第归实际内容包括切分或者调用排序；
		qsort(a,p+1,hi);
	}
}


public static int part2(int[] a,int lo,int hi){
	int mid=sort3(a,lo,hi), key=a[mid], nlo, nhi;
	while(lo<hi){
		//获取高低两端的数值；成功的话更新当前高低指针，并执秩序，交换数据；
		nlo=getnlo(a,lo,hi,key);
		if(nlo>0) lo=nlo;
		nhi=getnhi(a,lo,hi,key);

		if(nhi>0) hi=nhi;
		if(nlo>0 && nhi>0) proBubbleSort(a,lo,hi);
		//如果有一端获取失败就表明数据不多了，进行非第归排序并返回最新的中值数据；存在极其稀罕的头尾巴无序，中间有序的时候出现排序退化。
		if(nlo<0 || nhi<0) proBubbleSort(a,lo,hi);
		return (lo+hi)/2;
	}
	return -1; //这句其实永远都不会走到，如果走到了，就是机器运行出了异常问题。
}


public static final int getnhi(int[] a,int lo,int hi,int key){
	for(int i=hi;i>lo;i--) if(a[i]<key) return i;
	return -1;
}

public static final int getnlo(int[] a,int lo,int hi,int key){
	for(int i=lo;i<lo;i++) if(a[i]>key) return i;
	return -1;
}

public static final int getnhi(int[] a,int lo,int hi){
	int key=sort3(a,lo,hi);
	for(int i=hi;i>lo;i--) if(a[i]<key) return i;
	return -1;
}

public static final int getnlo(int[] a,int lo,int hi){
	int key=sort3(a,lo,hi);
	for(int i=lo;i<lo;i++) if(a[i]>key) return i;
	return -1;
}


//make a[lo]<=a[mid]<=a[hi] sort head,mid,tail
public static final int sort3(int[] a,int lo,int hi){
	int mid=(hi+lo)/2;
	if(a[lo]>a[hi]) ex(a,lo,hi);
	if(a[mid]>a[hi]) ex(a,mid,hi);
	if(a[mid]<a[lo]) ex(a,mid,lo);
	return mid;
}


/*****************************up is qsort************/


/***************************down is quickSelect****************************************/

public static <AnyType extends Comparable<? super AnyType>>
void quickSelect(AnyType[] a,int k){
	quickSelect(a,0,a.length-1,k);
}

private static final int CUTOFF=3;

public static <T extends Comparable<? super T>>
T median3(T[] a,int lo,int hi){
	int center=(lo+hi)/2;
	//make center the center
	if(a[center].compareTo(a[lo])<0) ex(a,lo,center);
	if(a[hi].compareTo(a[lo])<0) ex(a,lo,hi);
	if(a[hi].compareTo(a[center])<0) ex(a,center,hi);

	// Place pivot at position hi - 1
	ex(a,center,hi-1);
	return a[hi-1];
}


public static <T extends Comparable<? super T>>
void quickSelect(T[] a,int left,int right,int k){
	if(left+CUTOFF<=right) {
		T pivot=median3(a,left,right);

		// Begin partitioning
		int i=left, j=right-1;
		for(;;){
			while(a[++i].compareTo(pivot)<0) ;
			while(a[--j].compareTo(pivot)>0) ;
			if(i<j)
				ex(a,i,j);
			else
				break;
		}

		ex(a,i,right-1);   // Restore pivot

		if(k<=i)
			quickSelect(a,left,i-1,k);
		else if(k>i+1)
			quickSelect(a,i+1,right,k);
	}else  // Do an insertion sort on the subarray
		insertionSort(a,left,right);
}


private static final int NUM_ITEMS=1000;
private static int theSeed=1;

private static void checkSort(Integer[] a){
	for(int i=0;i<a.length;i++)
		if(a[i]!=i)
			System.out.println("Error at "+i);
	System.out.println("Finished checksort");
}


public static void main(String[] args){
	Integer[] a=new Integer[NUM_ITEMS];
	for(int i=0;i<a.length;i++)
		a[i]=i;

	for(theSeed=0;theSeed<20;theSeed++){
		Random.permute(a);
		jf.Sort.insertionSort(a);
		checkSort(a);

//            Random.permute(a);
////            Sort.heapsort(a);
//            checkSort(a);

//            Random.permute(a);
//            Sort.shellsort(a);
//            checkSort(a);

		Random.permute(a);
		jf.Sort.mergeSort(a);
		checkSort(a);

		Random.permute(a);
//            Sort.quicksort(a);
		checkSort(a);

		Random.permute(a);
		jf.Sort.quickSelect(a,NUM_ITEMS/2);
		System.out.println(a[NUM_ITEMS/2-1]+" "+NUM_ITEMS/2);
	}


	Integer[] b=new Integer[10_000_000];
	for(int i=0;i<b.length;i++)
		b[i]=i;

	Random.permute(b);
	long start=System.currentTimeMillis();
	jf.Sort.quickSelect(b,b.length/2);
	long end=System.currentTimeMillis();
	System.out.println("Timing for Section 1.1 example: ");
	System.out.println("Selection for N = "+b.length+" takes "+
			(end-start)+"ms.");
	System.out.println(b[b.length/2-1]+" "+b.length/2);
}
}