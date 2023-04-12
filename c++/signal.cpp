//信号处理
#include <iostream>
#include <csignal>
#include <unistd.h>

using namespace std;

void signalHandler(int signum){
    cout << "interrupt signal" << signum << endl;

    //清理并关闭程序、终止程序
    exit(signum);
}

int main(){

    //SIGINT:接收到交互信号
    //signal:捕获突发事件
    //注册信号 SIGINT 和信号处理程序
    signal(SIGINT, signalHandler);

    int i = 0;
    while(++i){
        cout << "Going sleep..." << endl;
        if(i == 3){
            //raise:生成信号
            raise(SIGINT);
        }
        sleep(1);
    }

    return 0;
}
