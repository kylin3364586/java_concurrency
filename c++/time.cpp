#include <iostream>
#include <ctime>

using namespace std;

int main(){

    //获取系统当前时间
    time_t now = time(0);
    // 把 now 转换为字符串形式
    char* dt = ctime(&now);
    cout << dt << endl;

    // 把 now 转换为 tm 结构
    tm *gmtm = gmtime(&now);
    dt = asctime(gmtm);
    cout << dt << endl;

    return 0;
}
