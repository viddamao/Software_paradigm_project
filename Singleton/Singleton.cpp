/*
 * Singleton.cpp
 *
 *  Created on: Oct 26, 2016
 *      Author: fey01
 */
#include <iostream>
#include "Singleton.h"

using namespace std;

Singleton* Singleton::instance = NULL;
//Static variables have to be defined outside the main() in a global scope
//Static variables in a class have to be defined in a separate file other than the class file
//where the static variables are declared

int main(){

	cout<<"Single Thread Testing: "<<endl;
	Singleton *myFirstObject;
	myFirstObject=myFirstObject->getInstance();
	cout<<"My First Object is at location: "<<myFirstObject<<endl;

	Singleton *mySecondObject;
	mySecondObject=mySecondObject->getInstance();
	cout<<"My Second Object is at location: "<<mySecondObject<<endl;

	return 0;
}



