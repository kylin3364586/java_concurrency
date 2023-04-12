//文件流
/*
fstream 文件流，包含ifstream、ofstream两种功能
ifstream 文件输入流
ofstream 文件输出流
*/

#include <iostream>
#include <fstream>

using namespace std;

int main(){

    char data[100];

    //以写模式打开一个文件
    ofstream outfile;
    outfile.open("afile.dat");

    cout << "enter your name: ";
    cin.getline(data, 100);//getline()函数从外部读取一行
    //向文件写入用户输入的数据（ << ）向文件写入信息
    outfile << data << endl;

    cout << "enter your age: ";
    cin >> data;
//    cin.ignore();ignore() 函数会忽略掉之前读语句留下的多余字符
    //再次向文件写入用户数据
    outfile << data << endl;

    //关闭打开的文件
    outfile.close();



    //以阅读模式打开文件
    ifstream infile;
    infile.open("afile.dat");

    //读取文件数据（ >> ）从文件读取信息
    infile >> data;
    cout << "name= " << data << endl;

    //再次读取文件数据
    infile >> data;
    cout << "age= " << data << endl;

    //关闭打开的文件
    infile.close();

    return 0;
}
