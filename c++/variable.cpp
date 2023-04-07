#include <iostream>
using namespace std;

//声明变量
extern int a,b;
extern int c;
extern float f;

int main(){

    //变量定义
    int a,b;
    int c;
    float f;
    //变量赋值
    a = 10;
    b = 20;
    c = a + b;

    cout << c << endl;
    f = 70.0/3.0;
    cout << f << endl;
    return 0;
}
