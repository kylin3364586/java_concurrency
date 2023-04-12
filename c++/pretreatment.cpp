//预处理
#include <iostream>
using namespace std;

//#define预处理指令用于创建符号常量（通常称为宏）
#define PI 3.1415926

#define MKSTR(x) #x

#define concat(a, b) a ## b

int main(){
    cout << "pretreatment pi= " << PI << endl;

    cout << MKSTR( hello c++) << endl;

    int xy = 120;
    cout << concat(x,y);

    //c++预定义的宏

    cout << "line = " << __LINE__ << endl;
    cout << "file = " << __FILE__ << endl;
    cout << "date = " << __DATE__ << endl;
    cout << "time = " << __TIME__ << endl;
    return 0;

}

