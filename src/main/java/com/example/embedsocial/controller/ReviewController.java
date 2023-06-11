package com.example.embedsocial.controller;

import com.example.embedsocial.model.Review;
import com.example.embedsocial.service.JsonFileReader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ReviewController {

    @GetMapping("/filters")
    public String showFilterReviewsPage() {
        return "filters-reviews";
    }

    @GetMapping("/filter-reviews")
    public String filterReviews(
            @RequestParam("orderByRating") String orderByRating,
            @RequestParam("minRating") int minRating,
            @RequestParam("orderByDate") String orderByDate,
            @RequestParam("prioritizeText") String prioritizeText,
            Model model
    ) {
        model.addAttribute("orderByRating", orderByRating);
        model.addAttribute("minRating", minRating);
        model.addAttribute("orderByDate", orderByDate);
        model.addAttribute("prioritizeText", prioritizeText);

        JsonFileReader jsonFileReader = new JsonFileReader();
        String filePath = "C:\\Users\\popos\\OneDrive\\Documents\\Internships\\embedsocial\\src\\main\\resources\\reviews.json";
        try {
            List<Review> reviews = jsonFileReader.readReviewsFromFile(filePath);

            List<Review> filteredReviews = reviews.stream()
                    .filter(review -> review.getRating() >= minRating)
                    .collect(Collectors.toList());


            // Sorting based on date
            if (orderByDate.equals("oldest")) {
                filteredReviews.sort(Comparator.comparing(Review::getReviewCreatedOnDate));
            } else {
                filteredReviews.sort(Comparator.comparing(Review::getReviewCreatedOnDate).reversed());
            }

            // Sorting based on rating
            if (orderByRating.equals("highest")) {
                filteredReviews.sort(Comparator.comparingInt(Review::getRating).reversed());
            } else {
                filteredReviews.sort(Comparator.comparingInt(Review::getRating));
            }

            // Filter reviews with text
            if (prioritizeText.equals("yes")) {

                List<Review> reviewsWithText = filteredReviews.stream()
                        .filter(review -> review.getReviewText() != null && !review.getReviewText().isEmpty())
                        .collect(Collectors.toList());

                List<Review> reviewsWithoutText = filteredReviews.stream()
                        .filter(review -> review.getReviewText() == null || review.getReviewText().isEmpty())
                        .collect(Collectors.toList());

                List<Review> prioritizedReviews = new ArrayList<>();
                prioritizedReviews.addAll(reviewsWithText);
                prioritizedReviews.addAll(reviewsWithoutText);

                filteredReviews = prioritizedReviews;
            }

            model.addAttribute("reviews", filteredReviews);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "reviews";
    }
}
