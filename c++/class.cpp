#include <iostream>
using namespace std;

//定义一个对象
class Box{
    //定义作用域，可以是private、protected
    public:
        double length;
        double breadth;
        double height;
};

int main(){
    //声明box类型
    Box box1;
    Box box2;
    double volume = 0.0;

    //设置box1值
    box1.length = 2.0;
    box1.breadth = 3.0;
    box1.height = 5.0;
    //设置box2值
    box2.length = 5.0;
    box2.breadth = 8.0;
    box2.height = 10.0;

    //计算值
    volume = box1.length * box1.breadth * box1.height;
    cout << "box1:" << volume << endl;

    volume = box2.length * box2.breadth * box2.height;
    cout << "box1:" << volume << endl;

    return 0;
}
