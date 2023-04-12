//模板
#include <iostream>
#include <string>

using namespace std;

template <typename T> inline T const& Max(T const& a, T const& b){
    return a < b ? b : a;
}

int main(){
    int a = 50;
    int b = 20;
    cout << "int result=" << Max(a, b) << endl;

    double c = 23.5;
    double d = 35.8;
    cout << "int result=" << Max(c, d) << endl;

    string e = "hello";
    string f = "world";
    cout << "int result=" << Max(e, f) << endl;

    return 0;
}
