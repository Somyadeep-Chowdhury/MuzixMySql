package com.stackroute.muzixApplicationTask1.domain;

import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.springframework.data.mongodb.core.mapping.Document;



//@Document(collection = "Tracks")
@Entity
@Data
@NoArgsConstructor//without @setter & @getter, @Data can be applied due to lombok(this takes setter, getter as default
public class Track {

    @Id
   //@GeneratedValue(strategy = GenerationType.AUTO)//table primary key annotation
    private int trackId;                                               //@ApiModelProperty(notes = "unique ID")          //swagger documentation


    @ApiModelProperty(notes = "trackname")      //swagger documentation
    private String trackName;
    @ApiModelProperty(notes = "comment")        //swagger documentation
    private String comment;

    /* public Track(String trackName, String comment) {
        this.trackName = trackName;
        this.comment = comment;
    }*/

   /* public Track(String trackName) {
        this.trackName = trackName;
    }*/
}
