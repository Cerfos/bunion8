package com.example.bunion8_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RatingController {
    
    @Autowired
    RatingRepository ratingRepository;
    
    @Autowired
    MovieInfoRepository movieInfoRepository;
    
    @PostMapping("/rating")
    public void addRating(@RequestBody RatingTransfer transfer) {
        MovieInfo foundMovie = movieInfoRepository.findById(transfer.getMovieId()).orElse(null);
        if(foundMovie!= null) {
        	Rating rating = new Rating();
        	rating.setStars(transfer.getStars());
        	rating.setMovieInfo(foundMovie);
        	foundMovie.getRatings().add(rating);
        	movieInfoRepository.save(foundMovie);
        }
    }

}