//不连续命名空间
#include <iostream>

using namespace std;

//第一个命名空间
namespace first_space{
    void func(){
        cout << "first_space" << endl;
    }
    //第二个命名空间
    namespace second_space{
        void func(){
            cout << "second_space" << endl;
        }
    }
}


using namespace first_space::second_space;

int main(){
    func();
    return 0;
}
