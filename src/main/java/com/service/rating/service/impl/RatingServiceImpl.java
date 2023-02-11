package com.service.rating.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.rating.entity.Rating;
import com.service.rating.repository.RatingRepository;
import com.service.rating.service.RatingService;
import com.service.rating.utility.IdGenerator;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	@Override
	public Rating createRatingRecord(Rating rating) {
		rating.setId(IdGenerator.generateUniqueId());
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatingRecords() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingRecordsByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingRecordsByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
