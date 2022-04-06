package it326.r4s;

public class Review extends Entity{

    private User reviewer;
    private Rating rating;

    public static enum Rating{  

        ONE (1), TWO (2), THREE (3), FOUR (4), FIVE (5);

        private int value;
        Rating(int value){
            this.value = value;
        }
    }

    public Review(User reviewer, Rating rating){
        this.reviewer = reviewer;
        this.rating = rating;
    }

    public int getRatingValue(){
        return this.rating.value;
    }

    public User getReviewer() {
        return this.reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Rating getRating() {
        return this.rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

}
