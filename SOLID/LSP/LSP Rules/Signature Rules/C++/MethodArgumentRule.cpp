#include<bits/stdc++.h>

using namespace std;


class Parent{
    public:
        virtual void method(string s){
            cout<<"METHOD EXECUTING USING PARENT OBJECT"<<endl;
    }
};

class Child : public Parent{
    public:
        void method(string s) override{
            cout<<"METHOD EXECUTING USING CHILD OBJECT"<<endl;
    }
};

class Client{
    private:
        Parent* object;

    public:
        Client(Parent* object){
            this->object = object;
        }

        void print(string msg){
            object->method(msg);
        }
};

int main(){
    Parent* parent = new Parent();
    Child* child = new Child();

    Client* client = new Client(child);
    client->print("hello");
}