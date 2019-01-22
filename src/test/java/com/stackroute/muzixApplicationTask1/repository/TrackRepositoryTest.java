package com.stackroute.muzixApplicationTask1.repository;

import com.stackroute.muzixApplicationTask1.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TrackRepositoryTest {

    @Autowired
    TrackRepository trackRepository;
    Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackId(9);
        track.setTrackName("Wish you were here");
        track.setComment("Pink Floyd");
    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }

    @Test
    public void saveTest()
    {
//        System.out.println("in saveTest");
        trackRepository.save(track);
//        System.out.println("dsvoihoivds"+trackRepository.save(track));
        Track fetchUser = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(9,fetchUser.getTrackId());
    }

    @Test
    public void testSaveUserFailure(){
        Track testTrack= new Track();
        testTrack.setTrackId(9);
        testTrack.setTrackName("Coming back to life");
        testTrack.setComment("Pink Floyd");
        trackRepository.save(track);
//        Track fetchUser = trackRepository.findById(track.getTrackId()).get();
        Assert.assertNotSame(testTrack,track);
    }

    @Test
    public void testGetAllUser(){
//        Track u = new Track("Johny","Jenny",10,"Johny12",102);
//        Track u1 = new Track("Harry","Jenny",11,"Harry12",103);
//        trackRepository.save(u);
//        trackRepository.save(u1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("dshk",list.get(0).getTrackName());

    }
}