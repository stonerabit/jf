package jf;

/**
 */
public class HeapSort{
//希尔排序类似的过程；
public static void heapSort(int[] arr){
	for(int i=arr.length/2-1;i >= 0;i--) m2p(arr,i,arr.length);
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

// i ,2i+1,


public static final void ex(int[] arr,int a,int b){
	int temp=arr[a];
	arr[a]=arr[b];
	arr[b]=temp;
}


public static void main(String[] args){
	int[] arr={9,8,7,6,5,4,3,2,1};
//        sort(arr);
	System.out.println(java.util.Arrays.toString(arr));
}
}