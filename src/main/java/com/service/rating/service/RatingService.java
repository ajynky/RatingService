package com.service.rating.service;

import java.util.List;

import com.service.rating.entity.Rating;

public interface RatingService {

	Rating createRatingRecord(Rating rating);

	List<Rating> getAllRatingRecords();

	List<Rating> getRatingRecordsByUserId(String userId);

	List<Rating> getRatingRecordsByHotelId(String hotelId);
}
