#include <iostream>
#include <cstring>
using namespace std;

int main(){
    //char数组
    char s1[10] = {'h','e','l','l','o'};
    cout << "value=" << s1 << endl;

    char s2[11] = "hello";
    char s3[11] = "world";
    char s4[11];

    //复制s2的值到s4
    strcpy(s4, s2);
    cout << "copy s2 to s4:" << s4 << endl;

    //连接字符串
    strcat(s2 ,s3);
    cout << "append s2 s3:" << s2 << endl;

    //字符串长度
    int len = strlen(s2);
    cout << "s2 length:" << len << endl;


    return 0;
}
