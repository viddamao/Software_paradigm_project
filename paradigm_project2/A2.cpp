#include <stdio.h>
#include <cstdlib>
#include <iostream>
using namespace std;

struct Student{
	std::string name;
    int age;
};
static const char ALPHABET[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
static const int NAME_LENGTH=6;

char genRandom(){
    return ALPHABET[rand() % 26];
}

int main(){
	Student stu[10];
	for(unsigned int i = 0; i < 10; i++){
	    stu[i].age = rand()%30;
	    std::string Str;
	    for(unsigned int i = 0; i < NAME_LENGTH; i++){
	    	Str += genRandom();
	    }
	    stu[i].name = Str;
	    cout << Str <<" "<<stu[i].age<<endl ;
	}
}
