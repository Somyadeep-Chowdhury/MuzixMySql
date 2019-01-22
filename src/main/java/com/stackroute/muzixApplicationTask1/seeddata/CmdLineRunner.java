package com.stackroute.muzixApplicationTask1.seeddata;

import com.stackroute.muzixApplicationTask1.domain.Track;
import com.stackroute.muzixApplicationTask1.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdLineRunner implements CommandLineRunner {
    private TrackService trackService;

    @Autowired
    public CmdLineRunner(TrackService trackService){
        this.trackService=trackService;
    }

    @Override
    public void run(String... args) throws Exception {
       /* trackService.saveTrack(new Track("free fallin","john mayer"));
        trackService.saveTrack(new Track("gravity","john mayer"));
        trackService.saveTrack(new Track("new light","john mayer"));
        trackService.saveTrack(new Track("hello","adele"));
        trackService.saveTrack(new Track("hello","adele"));*/

    }
}
