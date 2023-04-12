//异常
#include <iostream>
#include <exception>
using namespace std;

double division(int a, int b){

    if(b == 0){
        throw "division by zero condition!";
    }
    return (a / b);
}

int main(){

    int x = 50;
    int y = 0;
    double z = 0.0;
    try{
        z = division(x, y);
        cout << "invoke division method result= " << z << endl;
    }catch(const char* msg){
        cerr << msg << endl;
    }
    return 0;
}
