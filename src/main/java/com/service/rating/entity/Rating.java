package com.service.rating.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("user_ratings")
public class Rating {
	
	@Id
	private String id;
	private String userId;
	private String hotelId;
	private int ratings;
	private String feedback;

}
