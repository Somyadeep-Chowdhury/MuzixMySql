package com.stackroute.muzixApplicationTask1.controller;

import com.stackroute.muzixApplicationTask1.domain.Track;
import com.stackroute.muzixApplicationTask1.exceptions.EmptyListException;
import com.stackroute.muzixApplicationTask1.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApplicationTask1.exceptions.TrackDoNotExistsException;
import com.stackroute.muzixApplicationTask1.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "track-controller" , description = "this is track controller")     //swagger
public class TrackController {
    private TrackService trackService;
    private ResponseEntity responseEntity;
    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }

    @GetMapping("allTrack")
    @ApiOperation(value = "get all track")          //swagger
    public ResponseEntity<?> getAllTrack() throws EmptyListException {
        return new ResponseEntity<List<Track>>(trackService.getAllTrack(), HttpStatus.OK);
    }

    @PostMapping("saveTrack")
    @ApiOperation(value = "save tracks")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
//        try{
//           trackService.saveTrack(track);
//            responseEntity=new ResponseEntity<Track>(track, HttpStatus.CREATED);
//        }catch (Exception ex){
//            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//        }
        return new ResponseEntity<Track>(trackService.saveTrack(track),HttpStatus.CREATED);
    }
    @DeleteMapping("deleteTrack/{trackId}")
    @ApiOperation(value = "delete tracks")
    public ResponseEntity<?> deleteTrack(@PathVariable("trackId") int trackId) throws TrackDoNotExistsException
    {
//        trackService.removeTrack(id);
//        responseEntity= new ResponseEntity<String>("deleted",HttpStatus.OK);
//        return responseEntity;
        return new ResponseEntity<>(trackService.removeTrack(trackId),HttpStatus.OK);
    }

//    @DeleteMapping("deleteTrack")
//    public ResponseEntity<?> deleteTrack(@RequestBody Track track){
//        ResponseEntity responseEntity;
//        try{
//            trackService.removeTrack(track);
//            responseEntity=new ResponseEntity<String>("deleted",HttpStatus.CREATED);
//        }catch (Exception e){
//            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
//        }
//        return responseEntity;
//    }

    @PutMapping("updateTrack")
    @ApiOperation(value = "update tracks")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackDoNotExistsException
    {

//        try{
//            trackService.updateTrack(track);
//            responseEntity=new ResponseEntity<String>("updated",HttpStatus.CREATED);
//        }catch (Exception ex){
////            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//        }
        return new ResponseEntity<>(trackService.updateTrack(track),HttpStatus.OK);
    }

    @GetMapping("track")
    public ResponseEntity<?> getTrackByName(@RequestBody @RequestParam(value = "name") String name)
    {
        responseEntity=new ResponseEntity<Track>((Track) trackService.findByTrackName(name),HttpStatus.FOUND);
        return responseEntity;
    }

}
