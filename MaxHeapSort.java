package com.wrh.heapsort;

import java.util.Random;

/*
 * ˵����ʹ����������ɶ�����
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
			System.out.println("���������Ľ��Ϊ��");
			println(arr,len);
			
		}

	}
	
	public static void heapSort(int[] arr, int len) {
		//��һ���ȵ���arrΪ��С��
		if(arr==null||len<1){
			return ;
		}
		for(int i=(len/2)-1;i>=0;i--){//����ÿ����Ҷ�ӽڵ㿪ʼ���µ���,������С�ѣ��Ǵ�����³������������ѣ�����С�����³���
			siftDown(arr,i,len);
		}
//		System.out.println("�������֮��Ϊ��");
//		print(arr,len);
		//�ڶ�������ʼ����
		int begin = 0;
		int end = len-1;
		while(begin<end){
			//�Ƚ���
			swap(arr,begin,end);
			//Ȼ�������arr���±�Ϊ0~end-1λ��Ϊһ����С�ѡ�
			siftDown(arr,0,end);//�����endΪʣ��ĳ���
			
			//����֮�������һ��
			end--;	
		}

	}
	//�������ܣ��������λ��begin/end��Ԫ�صĽ���
	private static void swap(int[] arr, int begin, int end) {
		if(arr==null||begin<0||begin>=arr.length||end<0||end>=arr.length){
			return;
		}
		int temp = arr[begin];
		arr[begin] = arr[end];
		arr[end] = temp;
	}
	//�������ܣ���ӡ���
	private static void println(int[] arr,int len) {
		if(arr==null||len<1){
			return;
		}
		
		for(int i=0;i<len;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	//�������ܣ���arr[index]Ԫ��������
	private static void siftDown(int[] arr, int index, int len) {
		if(arr==null||len<1||index<0||index>len){
			return;
		}
		
		int half = len/2;
		int val = arr[index];
		while(index<half){
			int leftChild = (index<<1) + 1;
			int rightChild = leftChild + 1;
			//������������Ϊ��������С�����³�
			int maxIndex = leftChild;
			if(rightChild<len&&arr[rightChild]>arr[leftChild]){
				maxIndex = rightChild;
			}
			//��arr[maxIndex]�� val���бȽ�
			if(arr[maxIndex]<=val){
				break;
			}
			//����
			arr[index] = arr[maxIndex];
			index = maxIndex;
		}
		arr[index] = val;
	}

}