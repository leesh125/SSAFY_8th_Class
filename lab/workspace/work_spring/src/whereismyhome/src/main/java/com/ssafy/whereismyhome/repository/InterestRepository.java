package com.ssafy.whereismyhome.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.whereismyhome.dto.InterestDto;

@Mapper
public interface InterestRepository {

	boolean insertInterest(InterestDto interest);

	InterestDto getInterest(int no);

	boolean deleteInterest(int no);

}
