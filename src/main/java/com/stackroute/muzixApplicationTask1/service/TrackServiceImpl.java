package com.stackroute.muzixApplicationTask1.service;

import com.stackroute.muzixApplicationTask1.domain.Track;
import com.stackroute.muzixApplicationTask1.exceptions.EmptyListException;
import com.stackroute.muzixApplicationTask1.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApplicationTask1.exceptions.TrackDoNotExistsException;
import com.stackroute.muzixApplicationTask1.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }


    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already present");
        }else {
            Track saveTrack = trackRepository.save(track);
            return saveTrack;
        }
    }

    @Override
    public List<Track> getAllTrack() throws EmptyListException {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track) {
        if(trackRepository.existsById(track.getTrackId())) {
            track.setTrackName(track.getTrackName());
            track.setComment(track.getComment());
        }
        return trackRepository.save(track);

    }

    @Override
    public boolean removeTrack(int trackId) throws TrackDoNotExistsException {

        if(trackRepository.existsById(trackId)) {
            trackRepository.deleteById(trackId);
            return true;
        }
        else {
            throw new TrackDoNotExistsException("Track is not present");
        }
    }

    @Override
    public List<Track> findByTrackName(String name) {
        //return null;
        System.out.println("Find by name Track+++++++++++"+trackRepository.findBytrackName(name));
//        List<Track> track=new ArrayList<>();
//        track.add(trackRepository.findBytrackName(name));
        return trackRepository.findBytrackName(name);
    }


//    @Override
//    public boolean removeTrack(Track track) {
//        if (trackRepository.existsById(track.getTrackId())) {
//            trackRepository.delete(track);
//            return true;
//        }
//        return false;
//    }
}
