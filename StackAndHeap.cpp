/*
 * StackAndHeap.cpp
 *
 *  Created on: Sep 23, 2016
 *      Author: fey01
 */
#include <iostream>
#include <ctime>

using namespace std;

int StackFunc(){
	//Create array from stack
	int stackArray[1000];
	for (int i=0;i<1000;i++){
		stackArray[i]=1;
		cout << "The value in stackArray[" << i << " ] is: "<< stackArray[i] << endl;
	}
	return 0;
}

int HeapFunc(){
	//Create array from heap
	int *heapArray=new int[1000];
	for (int i=0;i<1000;i++){
			*(heapArray+i)=1;
			cout << "The value in heapArray[" << i << "] is: " << *(heapArray+i) << endl;
	}

	delete[] heapArray;

	return 0;
}

int main(){

	cout<<"Now calling the Stack function"<<endl;
	const clock_t begin_time_stack = clock();
	for (int i=1;i<=100000;i++){
		StackFunc();
	}
	const clock_t end_time_stack=clock();

	cout<<"Now calling the Heap function"<<endl;
	const clock_t begin_time_heap = clock();
	for (int i=1;i<=100000;i++){
		HeapFunc();
	}
	const clock_t end_time_heap=clock();

	cout<<"The time elapsed for Stack function is: "<<float( end_time_stack - begin_time_stack ) /  CLOCKS_PER_SEC <<"seconds" << endl;
	cout<<"The time elapsed for Heap function is: "<<float( end_time_heap - begin_time_heap ) /  CLOCKS_PER_SEC << "seconds" <<endl;


	return 0;
}


