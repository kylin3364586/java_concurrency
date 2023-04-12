#include <iostream>
#include <exception>

using namespace std;

//struct结构体，由相同类型或不同类型组成的数据集合
struct MyException: public exception{
    const char * what() const throw(){
        return "c++ exception";
    }
};

int main(){
    try{
        throw MyException();
    }catch(MyException mye){
        std::cout << "myException " << std::endl;
        std::cout << mye.what() << std::endl;
    }catch(std::exception& e){
        cout << "other exception!!" <<endl;
    }

    return 0;
}
