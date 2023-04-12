//命名空间
#include <iostream>

using namespace std;

namespace first_space{
    void func(){
        cout << "first_space" << endl;
    }
}

namespace second_space{
    void func(){
        cout << "second_space" << endl;
    }
}

//使用自定义命名空间
using namespace first_space;

int main(){

//    first_space::func();
//    second_space::func();
    func();

    return 0;
}
