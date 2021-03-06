package com.wrh.heapsort;

import java.util.Random;

/*
 * 说明：使用最大堆来完成堆排序
 * */
public class MaxHeapSort {

	public static void main(String[] args) {
		Random r = new Random(47);
		for(int j=0;j<20;j++){
			int len = r.nextInt(20);
			int [] arr = new int[len];
			
			for(int i=0;i<len;i++){
				arr[i] = r.nextInt(2*len);
			}
//			int len = 10;
//			int[] arr = {9,12,17,30,50,20,60,65,4,49};
			 
			heapSort(arr,len);
			System.out.println("数组排序后的结果为：");
			println(arr,len);
			
		}

	}
	
	public static void heapSort(int[] arr, int len) {
		//第一步先调整arr为最小堆
		if(arr==null||len<1){
			return ;
		}
		for(int i=(len/2)-1;i>=0;i--){//对于每个非叶子节点开始向下调整,对于最小堆，是大的往下沉，而对于最大堆，则是小的往下沉。
			siftDown(arr,i,len);
		}
//		System.out.println("数组调整之后为：");
//		print(arr,len);
		//第二步，开始排序
		int begin = 0;
		int end = len-1;
		while(begin<end){
			//先交换
			swap(arr,begin,end);
			//然后调数组arr从下标为0~end-1位置为一个最小堆。
			siftDown(arr,0,end);//这里的end为剩余的长度
			
			//调整之后进行下一轮
			end--;	
		}

	}
	//函数功能：完成数组位置begin/end的元素的交换
	private static void swap(int[] arr, int begin, int end) {
		if(arr==null||begin<0||begin>=arr.length||end<0||end>=arr.length){
			return;
		}
		int temp = arr[begin];
		arr[begin] = arr[end];
		arr[end] = temp;
	}
	//函数功能：打印输出
	private static void println(int[] arr,int len) {
		if(arr==null||len<1){
			return;
		}
		
		for(int i=0;i<len;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	//函数功能：将arr[index]元素向后沉。
	private static void siftDown(int[] arr, int index, int len) {
		if(arr==null||len<1||index<0||index>len){
			return;
		}
		
		int half = len/2;
		int val = arr[index];
		while(index<half){
			int leftChild = (index<<1) + 1;
			int rightChild = leftChild + 1;
			//现在是以最大堆为例，则是小的往下沉
			int maxIndex = leftChild;
			if(rightChild<len&&arr[rightChild]>arr[leftChild]){
				maxIndex = rightChild;
			}
			//将arr[maxIndex]与 val进行比较
			if(arr[maxIndex]<=val){
				break;
			}
			//交换
			arr[index] = arr[maxIndex];
			index = maxIndex;
		}
		arr[index] = val;
	}

}
