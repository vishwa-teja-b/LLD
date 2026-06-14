#include <bits/stdc++.h>

using namespace std;

/**
 * REMEMBER : if the parent accepted an input, then the child must accept it too.
 */

class ZomatoDeliveryPartnerAssignment{
    protected:
        int distance;
    public:
        ZomatoDeliveryPartnerAssignment(int distance){
            this->distance = distance;
        }

        virtual void assignPartner(){
            // PRE-CONDITON : delivery partner can be assigned till <= 10kmn
            if(distance > 10) cout<<"EXCEPTION IS THROWN HERE IN PARENT"<<endl;
            else cout<<"PARTNER ASSIGNED FOR DELIVERY IN THE RANGE (0-10KM)"<<endl;
        }
};

class BlinkitPartnerAssignment : public ZomatoDeliveryPartnerAssignment{
    public:
        BlinkitPartnerAssignment(int distance) : ZomatoDeliveryPartnerAssignment(distance) {}

        // LSP violation

        void assignPartner() override{
            if(distance > 3) cout<<"EXCEPTION THROWN HERE IN CHILD"<<endl;
            else cout<<"PARTNER ASSIGNED FOR DELIVERY IN THE RANGE (0-3KM)"<<endl;
        }
};

class CheckoutClient{
    private:
        ZomatoDeliveryPartnerAssignment* partnerAssignment;

    public:
        CheckoutClient(ZomatoDeliveryPartnerAssignment* partnerAssignment){
            this->partnerAssignment = partnerAssignment;
        }

        void finalizeOrder(){
            partnerAssignment->assignPartner();
        }
};

int main(){
    ZomatoDeliveryPartnerAssignment* partnerAssignment = new BlinkitPartnerAssignment(7);

    CheckoutClient* client = new CheckoutClient(partnerAssignment);
    client->finalizeOrder();
}