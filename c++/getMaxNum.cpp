#include <iostream>
using namespace std;

//主函数
int main(){
    int a = 100;
    int b = 200;
    int res;
    res = max(a, b);
    cout << "max value:" << res << endl;
    return 0;
}

//函数声明
int max(int num1, int num2);
//函数实现
int max(int num1, int num2){
    int result;
    if(num1 > num2){
        result = num1;
    }else{
        result = num2;
    }
    return result;
}
