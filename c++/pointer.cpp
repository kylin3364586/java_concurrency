#include <iostream>
using namespace std;

int main(){
    int var1;
    char var2[10];

    cout << "variable address:" << &var1 << endl;
    cout << "variable address:" << &var2 << endl;


//    int    *ip;    /* 一个整型的指针 */
//    double *dp;    /* 一个 double 型的指针 */
//    float  *fp;    /* 一个浮点型的指针 */
//    char   *ch;     /* 一个字符型的指针 */
    int var = 30;//声明实际变量
    int *ip;//声明实际指针

    //在指针变量中存储值
    ip = &var;

    cout << var << endl;//实际值
    cout << *ip << endl;//指针对应的值

    return 0;
}
