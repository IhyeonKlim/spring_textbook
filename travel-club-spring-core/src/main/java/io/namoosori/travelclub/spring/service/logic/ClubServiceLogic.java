package io.namoosori.travelclub.spring.service.logic;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;
import io.namoosori.travelclub.spring.store.ClubStore;
import io.namoosori.travelclub.spring.store.mapstore.ClubMapStore;
import io.namoosori.travelclub.spring.util.exception.NoSuchClubException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("clubService")
public class ClubServiceLogic implements ClubService {

    private ClubStore clubStore;

    //객체에 대한 생성을 이렇게 해주면 ClubStore인지 ClubDBStore인지 뭔지 알거 없고 일단 생성해주는걸 받아서 쓴다는 것.
    //이렇게 해야 유지보수가 되지. new 때리면 답없다.
    public ClubServiceLogic(ClubStore clubStore){
        this.clubStore = clubStore;
    }
    @Override
    public String registerClub(TravelClubCdo club) {
        TravelClub newClub = new TravelClub(club.getName(), club.getIntro());
        newClub.checkValidation();
        return clubStore.create(newClub);
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
    public void modify(String clubId, NameValueList nameValues) {
        TravelClub foundedClub = clubStore.retrieve(clubId);
        if(foundedClub == null){
            throw new NoSuchClubException("No such club with id : " + clubId);
        }
        foundedClub.modifyValues(nameValues);
        clubStore.update(foundedClub);
    }

    @Override
    public void remove(String clubId) {
        if(!clubStore.exists(clubId)){
            throw new NoSuchClubException("No such club with id : " + clubId);
        }
        clubStore.delete(clubId);
    }
}
