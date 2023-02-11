package com.service.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.rating.entity.Rating;
import com.service.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> createUser(@RequestBody Rating rating) {
		Rating savedRating = ratingService.createRatingRecord(rating);
		return new ResponseEntity<Rating>(savedRating, HttpStatus.CREATED);
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> findByHotelId(@PathVariable String hotelId) {
		List<Rating> rating = ratingService.getRatingRecordsByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.FOUND).body(rating);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> findByUserId(@PathVariable String userId) {
		List<Rating> rating = ratingService.getRatingRecordsByUserId(userId);
		return ResponseEntity.status(HttpStatus.FOUND).body(rating);
	}

	@GetMapping
	public ResponseEntity<List<Rating>> findAllRating() {
		List<Rating> allRatingRecords = ratingService.getAllRatingRecords();
		return ResponseEntity.ok(allRatingRecords);
	}

}
