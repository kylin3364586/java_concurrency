#include <iostream>
#include <vector>
#include <cstdlib>
#include <string>
#include <stdexcept>

using namespace std;

template <class T> class Stack{

    private:
        vector<T> elems;

    public:
        void push(T const&); //入栈
        void pop();     //出栈
        T top() const;  //返回栈顶元素
        bool empty() const{ //如果为空放回true
            return elems.empty();
        }
};

//入栈方法
template <class T> void Stack<T>::push(T const& elem){
    elems.push_back(elem);
}

//出栈方法
template <class T> void Stack<T>::pop(){
    if(elems.empty()){
        throw out_of_range("[pop] elems size = 0 !!");
    }
    elems.pop_back();
}
//获取最后一个元素
template <class T> T Stack<T>::top() const{
    if(elems.empty()){
        throw out_of_range("[top] elems size = 0 !!");
    }
    return elems.back();
}

int main(){
    try{
        Stack<int> is; //定义int类型的栈
        Stack<string> ss; //定义string类型的栈

        is.push(7);
        cout << "intStack=" << is.top() << endl;

        ss.push("kylin");
        cout << "stringStack=" << ss.top() << endl;
        ss.pop();
        ss.pop();

    }catch(exception const& ex){
        cout << "Exception" <<ex.what() << endl;
    }
}
