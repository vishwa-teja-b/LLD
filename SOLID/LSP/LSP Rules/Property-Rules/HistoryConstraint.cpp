#include <bits/stdc++.h>

using namespace std;

class Account{
    public:
        void deposit(){ cout<<"DEPOSITING MONEY.........."<<endl; }
        virtual void withdraw(){ cout<<"WITHDRAWING MONEY.........."<<endl; }
};

class SavingsAccount : public Account{

};

class FixedDepositAccount : public Account{
    public:
        void withdraw() override{
            cout<<"EXCEPTION THROWN HERE SINCE FD ACCOUNT DOESN'T SUPPORT WITHDRAWALS"<<endl;
        }
};

class Client{
    private:
        Account* account;

    public:
       Client(Account* account){
        this->account = account;
       }

       void run(){
        account->withdraw();
       }
};

int main(){
    Account* account = new Account();
    Account* fd_account = new FixedDepositAccount();

    Client* client = new Client(fd_account);
    client->run();
}