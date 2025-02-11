package com.jonah.vttp5_paf_day06l.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day06l.repos.SeriesRepo;

@Service
public class SongService {
    @Autowired
    SeriesRepo seriesRepo;

    public List<Document> getTopSongsInYear(int year){
        return seriesRepo.findTopSongsYear(year);
    }

    public List<Integer> getTopYears(){
        return seriesRepo.findYearsTopSongs();
    }

    
}
