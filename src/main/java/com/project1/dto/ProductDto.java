package com.project1.dto;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Entity 변수와 동일하고, 서비스 레이어에서 특정값을 게산 후 
 * front-end에 전달하기 위해 discountPrice 변수를 추가 
 * */


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Setter
@Getter
public class ProductDto {

	private String name;
	private Long price;
	private String description;
	private String imageUrl;
	private String color;
	private String size;
	private Long discount;
	private Long categoryId;
	private LocalDateTime createTimestamp;
	private LocalDateTime updateTimestamp;
	private Long discountPrice;
}
