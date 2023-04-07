#include <iostream>
using namespace std;
/*继承*/

//基类
class Shape{
    //定义有访问权限的局部变量
    protected:
        int width;
        int height;

    //set方法
    public:
        void setWidth(int w){
            width = w;
        }
        void setHeight(int h){
            height = h;
        }

};

//基类
class PaintCost{
    public:
        int getCost(int area){
            return area * 30;
        }
};

//派生类
class Rectangle: public Shape,public PaintCost{
    public:
        int getArea(){
            return width * height;
        }

};


int main(void){

    Rectangle rect;
    int area;
    int cost;

    rect.setWidth(30);
    rect.setHeight(60);

    area = rect.getArea();
    cost = rect.getCost(area);

    cout << "total area= " << area << endl;
    cout << "total paint cost= $" << cost << endl;

    return 0;
}

