package it326.r4s;

import static org.junit.Assert.*;
import org.junit.Test;

import it326.r4s.Review.Rating;

public class ReviewTest {
    
    @Test
    public void testGetRatingValue(){
        Review newReview = new Review(new User(), Rating.ONE);

        int ratingValue = newReview.getRatingValue();        
        assertEquals(1, ratingValue);
    }
}
