package com.JYSHS.AfterSchool.user.service;

import com.JYSHS.AfterSchool.aggregate.club.TravelClub;
import com.JYSHS.AfterSchool.user.service.sdo.TravelClubCdo;
import com.JYSHS.AfterSchool.shared.NameValueList;

import java.util.List;

public interface ClubService {
	//
	String registerClub(TravelClubCdo club);
	TravelClub findClubById(String id);
	List<TravelClub> findClubsByName(String name);
	List<TravelClub> findAll();
	void modify(String clubId, NameValueList nameValues);
	void remove(String clubId);
}
