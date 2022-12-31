#include <iostream>
#include <vector>
#include <typeinfo>
using namespace std;


int main(){

    vector<int> a = {1, 2, 3};

    for(auto i=a.begin(); i != a.end(); i++){
        cout << typeid(a).name() << endl;
        cout << *i << endl;

    }

    return 0;
}