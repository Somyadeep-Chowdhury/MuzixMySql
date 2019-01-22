package com.stackroute.muzixApplicationTask1.repository;

import com.stackroute.muzixApplicationTask1.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface TrackRepository extends MongoRepository<Track,Integer> {
public interface TrackRepository extends JpaRepository<Track,Integer> {
   //@Query("SELECT t FROM Track t WHERE t.trackName = ?2")
    public List<Track> findBytrackName(String name);
}
