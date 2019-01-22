package com.stackroute.muzixApplicationTask1.service;

import com.stackroute.muzixApplicationTask1.domain.Track;
import com.stackroute.muzixApplicationTask1.exceptions.EmptyListException;
import com.stackroute.muzixApplicationTask1.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApplicationTask1.exceptions.TrackDoNotExistsException;

import java.util.List;

public interface TrackService  {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTrack() throws EmptyListException;

    public Track updateTrack(Track track );

    //public boolean removeTrack(Track track);
    public boolean removeTrack(int trackId) throws TrackDoNotExistsException;

    public  List<Track> findByTrackName(String name);

}
