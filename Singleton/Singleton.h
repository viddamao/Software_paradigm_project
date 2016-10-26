#define SINGLETON_H_

# include <iostream>
using namespace std;

class Singleton{

	private:
		//Static variables in a class have to be defined in a separate file other than the class file
		//where the static variables are declared
		static Singleton* instance;


	    //Private Constructor
		Singleton(){
			cout<<"Singleton Constructor called"<<endl;
		}


	public:
	       static Singleton* getInstance( ){
	    	   if(!instance)
	    		   instance = new Singleton();
	    	   return instance;
	       }
	       ~Singleton( );
};

#endif /* SINGLETON_H_ */
