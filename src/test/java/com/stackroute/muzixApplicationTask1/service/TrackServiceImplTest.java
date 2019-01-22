package com.stackroute.muzixApplicationTask1.service;

import com.stackroute.muzixApplicationTask1.domain.Track;
import com.stackroute.muzixApplicationTask1.exceptions.EmptyListException;
import com.stackroute.muzixApplicationTask1.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApplicationTask1.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceImplTest {

    private Track track;

    @Mock
    private TrackRepository trackRepository;

    @InjectMocks
    private TrackServiceImpl trackService;
    List<Track> list=null;

    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackName("Lazarus");
        track.setTrackId(11);
        track.setComment("Porcupine Tree");
        list = new ArrayList<>();
        list.add(track);

    }

    @Test
    public void saveUserTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }

    @Test
    public void saveUserTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedtrack = trackService.saveTrack(track);
        System.out.println("savedUser" + savedtrack);
        Assert.assertNotEquals(track,savedtrack);

    }

    @Test
    public void getAllUser() throws EmptyListException {

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTrack();
        Assert.assertEquals(list,tracklist);
    }
}