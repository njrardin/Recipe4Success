package it326.r4s;

enum Rating {
    One(1), Two(2), Three(3), Four(4), Five(5);

	private int value;
	int getValue() { return value; }
	private Rating (int value) { this.value= value; }
}

public class Review extends Entity{

    private User reviewer;
    private Rating rating;

    public Review (Rating rating, User reviewer) { // when creating Review, first argument would be Rating.Three, for example
        this.reviewer = reviewer;
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }
}
