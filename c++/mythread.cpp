#include <iostream>
#include <pthread.h>

using namespace std;

//预处理信号，创建常量
#define NUM_THREADS 5

//定义一个函数
void* say_hello(void* args){
    cout << "hello c++" << endl;
}


int main(){

    //定义线程个数
    pthread_t tids[NUM_THREADS];
    for(int i = 0; i < NUM_THREADS; ++i){
        //创建线程，创建线程的id，线程参数，调用函数，传入函数参数
        pthread_create(&tids[i], NULL, say_hello, NULL);

        if(ret != 0){
            cout << "pthread_create error: error_code=" << ret << endl;
        }
    }

    //终止线程
    pthread_exit(NULL);
    return 0;
}

