package com.ssafy.whereismyhome.service;

import com.ssafy.whereismyhome.dto.InterestDto;

public interface InterestService {

	boolean registerInterest(InterestDto interest);

	InterestDto getInterest(int no);

	boolean deleteInterest(int no);

}
