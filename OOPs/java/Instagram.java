import java.util.ArrayList;
import java.util.List;

abstract class Content{
    private int likeCount = 0;
    private int shareCount = 0;
    private int commentCount = 0;

    public int getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
    public int getShareCount() {
        return shareCount;
    }
    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }
    public int getCommentCount() {
        return commentCount;
    }
    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void like(){
        setLikeCount(likeCount + 1);
    }

    public void dislike(){
        setLikeCount(likeCount-1);
    }

    public void share(){
        setShareCount(shareCount+1);
    }

    public void comment(){
        setCommentCount(commentCount+1);
    }

    abstract void display();
    abstract void track_engagement();
}

class Post extends Content{
    String imageURL;
    String caption;

    Post(String imageURL, String caption){
        this.imageURL = imageURL;
        this.caption = caption;
    }

    @Override
    void display() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'display'");
        System.out.println("POST CONTENT");
        System.out.println("CAPTION : " + caption);
        System.out.println("IMAGE URL : "+ imageURL);
    }
    @Override
    void track_engagement() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'track_engagement'");
        System.out.println(getLikeCount());
        System.out.println(getShareCount());
        System.out.println(getCommentCount());
    }
}

class Reel extends Content{
    String videoURL;
    double duration;

    Reel(String videoURL, double duration){
        this.videoURL = videoURL;
        this.duration = duration;
    }

    @Override
    void display() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'display'");
        System.out.println("REEL : ");
        System.out.println("VIDEO : "+ videoURL);
        System.out.println("DURATION : "+ duration);
    }

    @Override
    void track_engagement() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'track_engagement'");
        System.out.println(getLikeCount());
        System.out.println(getShareCount());
        System.out.println(getCommentCount());
        System.out.println("REEL ENGAGEMENT");
    }
}

// similarly, for story

// class Story extends Content{

    
    
// }

class FeedRenderingEngine{
    // List<Content> renderFeed()
    void renderFeed(List<Content> feedItems){
        for(Content item : feedItems){
            // System.out.println(item.display());
            item.display();
        }
    }
}

public class Instagram {
    public static void main(String[] args) {
        Content post = new Post("image-url-123", "image uploaded");
        Content reel = new Reel("video-url-001",24.5);

        List<Content> feedItems = new ArrayList<>();
        feedItems.add(post);
        feedItems.add(reel);

        FeedRenderingEngine feedEngine = new FeedRenderingEngine();
        feedEngine.renderFeed(feedItems);

    }
}

// ENCAPSULATION COVERED, INHERITANCE COVERED, POLYMORPHISM COVERED, ABSTRACTION COVERED .