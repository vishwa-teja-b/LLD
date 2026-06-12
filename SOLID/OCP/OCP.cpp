#include <bits/stdc++.h>

using namespace std;

class Product{
    private:
        string name;
        int price;

    public:
        Product(string name, int price){
            this->name = name;
            this->price = price;
        }

        string getName(){return name;}
        int getPrice(){return price;}
};

class ShoppingCart{
    private:
        vector<Product*> cartItems;

    public:
        void addToCart(Product* p){
            cartItems.push_back(p);
        }

        vector<Product*> getCartItems(){
            return cartItems;
        }

        void calculateTotalPrice(){

        };
};

class InvoiceProvider{
    private:
        ShoppingCart* sc;
    
    public:
        InvoiceProvider(ShoppingCart* sc){
            this->sc = sc;
        }

        void printInvoice() {
            for(Product* p : sc->getCartItems()){
                cout<<p->getName()<<" "<<p->getPrice()<<endl;
            }
        };
};

//  violating OCP  -- CONSEQUENCES : EXISTING CODE MODIFIED , LEADING TO BUGS 
// in simple words, add new business logic without touching the existing code.
// how ?  ABSTRACTION --> INHERITANCE --> POLYMORPHISM


// class CartDB{
//     private:
//         ShoppingCart* sc;
    
//     public:
//         void saveToDB(){
//             cout<<"SAVING TO SQL DB"<<endl;
//         };
//         void saveToMongoDB(){
//             cout<<"SAVING TO Mongo DB"<<endl;
//         };
//         void saveToFile(){
//             cout<<"SAVING TO FILE"<<endl;
//         };
// };


// FOLLOWING OCP

class CartDB{
    private:
        ShoppingCart* sc;
    
    public:
        virtual void save()=0;
};

class SQLStorage : public CartDB{
    public:
        void save(){
            cout<<"SAVING TO SQL DB"<<endl;
        }
};

class MongoStorage : public CartDB{
    public:
        void save(){
            cout<<"SAVING TO MONGO DB"<<endl;
        }
};
class FileStorage : public CartDB{
    public:
        void save(){
            cout<<"SAVING TO FILE"<<endl;
        }
};

int main(){
    Product* product = new Product("iphone-17-pro",170000);

    ShoppingCart* cart = new ShoppingCart();
    cart->addToCart(product);
    // cart->printInvoice();

    InvoiceProvider* invc = new InvoiceProvider(cart);

    invc->printInvoice();

    CartDB* mongodb = new MongoStorage();
    mongodb->save();

    CartDB* sqldb = new SQLStorage();
    sqldb->save();
}