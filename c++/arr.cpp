#include <iostream>
using namespace std;
//头文件
#include <iomanip>
using std::setw;

int main(){
    //定义一个长度为10的数组
    int n[10];
    //赋值
    for(int i = 0; i<10; i++){
        n[i] = i + 100;
    }
    //打印列名
    cout << "element" << setw(13) << "value" << endl;
    //打印值
    for(int j = 0; j<10; j++){
        cout << setw(7) << j << setw(13) << n[j] << endl;
    }
    return 0;
}

