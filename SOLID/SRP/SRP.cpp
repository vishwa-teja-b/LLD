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

// THIS CLASS VIOLATES SRP - 
/**
 * SRP fundamentally means A class must be responsible for one thing. ex in our case, product class must handle everything related to products , but not including
 * adding to cart, calculating total parts, that is unnecessary for Product, as it introduces challenges in maintaining the code, finding bugs.
 */
// class ShoppingCart{
//     private:
//         vector<Product*> cartItems;

//     public:
//         void addToCart(Product* p){
//             cartItems.push_back(p);
//         }

//         void calculateTotalPrice(){

//         };
//         void printInvoice() {
//             for(Product* p : cartItems){
//                 cout<<p->getName()<<" "<<p->getPrice()<<endl;
//             }
//         };
//         void saveToDB(){};

// };


// SRP FOLLOWED

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

class CartDB{
    private:
        ShoppingCart* sc;
    
    public:
        void saveToDB(){};
};

int main(){
    Product* product = new Product("iphone-17-pro",170000);

    ShoppingCart* cart = new ShoppingCart();
    cart->addToCart(product);
    // cart->printInvoice();

    InvoiceProvider* invc = new InvoiceProvider(cart);

    invc->printInvoice();
}