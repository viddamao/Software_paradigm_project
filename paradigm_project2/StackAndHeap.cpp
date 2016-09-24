//
// Created by YiChen Zhou on 9/24/16.
//
#include <iostream>

int StackArray() {
    std::string stackArray[1000];
    for (int i = 0; i < 1000; i++) {
        stackArray[i] = "Mr. Robot";
        std::cout << "StackArray[" << i << "]: " << stackArray[i] << std::endl;
    }
    return 0;
}

int HeapArray() {
    std::string *heapArray = new std::string[1000];
    for (int i = 0; i < 1000; i++) {
        *(heapArray + i) = "Hello, Friend.";
        std::cout << "HeapArray[" << i << "]: " << *(heapArray + i) << std::endl;
    }

    delete[] heapArray;

    return 0;
}


int main(int argc, const char * argv[]) {
    const clock_t stackBeginTime = clock();
    for (int i = 0; i < 100000; i++) {
        StackArray();
    }
    const clock_t stackEndTime = clock();

    const clock_t heapBeginTime = clock();
    for (int i = 0; i < 100000; i++) {
        HeapArray();
    }
    const clock_t heapEndTime = clock();

    std::cout << "StackArray's Running Time: " << float(stackEndTime - stackBeginTime)/ CLOCKS_PER_SEC << std::endl;
    std::cout << "HeapArray's Running Time: " << float(heapEndTime - heapBeginTime)/ CLOCKS_PER_SEC << std::endl;

    return 0;
}