//运算符重载
#include <iostream>

using namespace std;

class Box{

    public:
        double length; //长
        double breadth; //宽
        double height; //高

     public:
        void setLength(double l){
            length = l;
        }
        void setBreadth(double b){
            breadth = b;
        }
        void setHeight(double h){
            height = h;
        }
        //计算体积
        double getVolume(){
            return length * breadth * height;
        }

        //运算符重载 +  把两个Box对象相加
        Box operator+(const Box& ob){
            Box box;
            box.length = this->length + ob.length;
            box.breadth = this->breadth + ob.breadth;
            box.height = this->height + ob.height;
            return box;
        }

};

int main(void){
    Box b1;
    Box b2;
    Box b3;

    b1.setLength(6.0);
    b1.setBreadth(7.0);
    b1.setHeight(5.0);
    cout << "b1 volume = " << b1.getVolume() << endl;

    b2.setLength(12.0);
    b2.setBreadth(13.0);
    b2.setHeight(10.0);
    cout << "b2 volume = " << b2.getVolume() << endl;


    b3 = b1 + b2;
    cout << "b3 volume = " << b3.getVolume() << endl;


};
