//内存

#include <iostream>
using namespace std;

int main(){
    double* num = NULL; //初始化num的值为NULL的指针
    num = new double; //为变量分配内存

    *num = 22.35; //给配分的内存地址存值

    cout << "num = " << *num << endl;

    delete num; //释放内存

    return 0;

}
