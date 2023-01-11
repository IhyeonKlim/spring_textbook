package com.JYSHS.AfterSchool.user.service.logic;

import com.JYSHS.AfterSchool.aggregate.club.TravelClub;
import com.JYSHS.AfterSchool.user.service.ClubService;
import com.JYSHS.AfterSchool.user.service.sdo.TravelClubCdo;
import com.JYSHS.AfterSchool.shared.NameValueList;
import com.JYSHS.AfterSchool.user.store.ClubStore;
import com.JYSHS.AfterSchool.util.exception.NoSuchClubException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceLogic implements ClubService {
	//
	private ClubStore clubStore;

	public ClubServiceLogic(ClubStore clubStore) {
		//
		this.clubStore = clubStore;
	}

	@Override
	public String registerClub(TravelClubCdo clubCdo) {
		//
		TravelClub club = new TravelClub(clubCdo.getName(), clubCdo.getIntro());
		club.checkValidation();
		String clubId = clubStore.create(club);
		return clubId;
	}

	@Override
	public TravelClub findClubById(String id) {
		return clubStore.retrieve(id);
	}

	@Override
	public List<TravelClub> findClubsByName(String name) {
		return clubStore.retrieveByName(name);
	}

	@Override
	public List<TravelClub> findAll(){
		return clubStore.retrieveAll();
	}
	@Override
	public void modify(String clubId, NameValueList nameValueList) {
		TravelClub travelClub = clubStore.retrieve(clubId);
		if (travelClub == null) {
			throw new NoSuchClubException("No such club with id " + clubId);
		}
		travelClub.modifyValues(nameValueList);
		clubStore.update(travelClub);
	}

	@Override
	public void remove(String clubId) {
		if (!clubStore.exists(clubId)) {
			throw new NoSuchClubException("No such club with id " + clubId);
		}
		clubStore.delete(clubId);
	}
}
