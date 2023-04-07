#include <iostream>

using namespace std;

class A{
    protected:
        int w;
        int h;

    public:
        void setW(int ww){
            w = ww;
        }
        void setH(int hh){
            h = hh;
        }
};

class B: public A{
    public:
        int getSum(){
            return w * h;
        }
};


int main(){
    B b;
    b.setW(5);
    b.setH(4);

    cout << "result=" << b.getSum() << endl;
    return 0;
};
