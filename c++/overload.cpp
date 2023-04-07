#include <iostream>

using namespace std;

/*重载*/

class printData{

    public:
        void print(int i){
            cout << "printInt= " << i << endl;
        }

        void print(double d){
            cout << "printDouble= " << d << endl;
        }

        void print(string s){
            cout << "printString= " << s << endl;
        }

};

int main(){

    printData pd;

    pd.print(1);
    pd.print(2.2);
    pd.print("kylin");

    return 0;
};
