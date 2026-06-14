#include<bits/stdc++.h>

using namespace std;

class User{
    private:
        string username;
        string name;
    
    public:
        User(string username, string name){
            this->name = name;
            this->username = username;
        }

        string getUsername(){
            return username;
        }

        string getName(){
            return name;
        }
};

class Content{
    private:
        int likes;
        int comments;
        int shares;
        string username;

    public:
        Content(){
            this->likes = 0;
            this->comments = 0;
            this->shares = 0;
        }

        int getLikes(){return likes;}
        int getComments() {return comments;}
        int getShares() {return shares;}

        void like(){
            likes++;
        }

        void dislike(){ likes--;}

        void comment(){ comments++;}
        void uncomment() {comments--;}

        void share(){shares++;}
        void unshare(){
            shares--;
        }

        string getUsername(){
            return username;
        }
};

class PostContent : public Content{
    private:
        string caption;
    
    public:
        PostContent(string caption){ this->caption = caption;}

        string getCaption(){return caption;}

};

class ReelContent : public Content{
    private:
        int duration;
    
    public:
        ReelContent(int duration){
            this->duration = duration;
        }
};

class FeedEngine{
    protected:
        vector<Content*> feedPosts;

    public:
        FeedEngine(){}
        FeedEngine(vector<Content*> feedPosts){
            this->feedPosts = feedPosts;
        }

        virtual void renderFeed(){
            for(auto &post : feedPosts){
                cout<<"ITEM DISPLAYED with likes : "<<post->getLikes()<<endl;
            }
        }
};

class FollowingFeed : public FeedEngine{
    private:
        vector<User*> following;

    public:
        FollowingFeed(vector<User*> following, vector<Content*> posts) : FeedEngine(posts){
            this->following = following;
        }

        void renderFeed() override{
            for(auto &post: feedPosts){
                cout<<"POSTS DISPLAYED FROM YOUR FOLLOWING LIST"<<endl;
            }
        }
};

class FavoritesFeed : public FeedEngine{
    private:
        vector<User*> favorites;

    public:
        FavoritesFeed(vector<User*> favorites, vector<Content*> posts) : FeedEngine(posts){
            this->favorites = favorites;
        }

        void renderFeed() override{
            for(auto &post: feedPosts){

                // if(feedposts contains posts from my favorites list) then
                cout<<"POSTS DISPLAYED FROM YOUR FAVORITES LIST"<<endl;
            }
        }
};

class InstagramUIClient{
    private:
        FeedEngine* feedEngine;

    public:
        InstagramUIClient(FeedEngine* feedEngine){
            this->feedEngine = feedEngine;
        }

        void render(){
            feedEngine->renderFeed();
        }   
};

int main(){
    User* user = new User("thisizvishwa","VISHWA VARMA");
    User* user2 = new User("viratkohli","VIRAT KOHLI");
    User* user3 = new User("rohitsharma45","ROHIT SHARMA");
    User* user4 = new User("alluarjunonline","ALLU ARJUN");
    User* user5 = new User("urstrulymahesh","MAHESH BABU");

    vector<User*> favorites;
    favorites.push_back(user);
    favorites.push_back(user2);
    favorites.push_back(user3);
    favorites.push_back(user4);
    favorites.push_back(user5);

    Content* post1 = new ReelContent(50);
    Content* post2 = new PostContent("caption");
    Content* post3 = new PostContent("demo");

    vector<Content*> posts;

    posts.push_back(post1);
    posts.push_back(post2);
    posts.push_back(post3);

    FeedEngine* fe = new FollowingFeed(favorites,posts);
    // fe->renderFeed();

    InstagramUIClient* client = new InstagramUIClient(fe);

    client->render();
}