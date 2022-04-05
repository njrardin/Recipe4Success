package it326.r4s;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;

public class ReviewTest {

    static Rating testRating;
    static User testUser;
    static int testRatingValue;
    static Review testReview;

    @BeforeClass
    public static void before(){
        testUser = new User();
        testRating = Rating.Five;
        testReview = new Review(testRating, testUser);
        }

    @Test
    public void testSetRating() {
        testReview.setRating(Rating.Two);
        assertEquals(Rating.Two, testReview.getRating());
    }

    @Test
    public void testGetRating() {
        assertEquals(Rating.Two, testReview.getRating());
        assertEquals(2, testReview.getRating().getValue());
    }

}
