#include <iostream>
using namespace std;

int main(){
    typedef int aaaa;//为类型定义另一个名称
    cout << "hello world" << endl;
    cout << "size of char:" << sizeof(char) << endl;
    cout << "size of short:" << sizeof(short) << endl;
    cout << "size of wchar_t:" << sizeof(wchar_t) << endl;
    cout << "size of int:" << sizeof(int) << endl;
    cout << "size of int:" << sizeof(aaaa) << endl;
    cout << "size of float:" << sizeof(float) << endl;
    cout << "size of long:" << sizeof(long) << endl;
    cout << "size of double:" << sizeof(double) << endl;

    return 0;

}
