package com.jonah.vttp5_paf_day06l;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jonah.vttp5_paf_day06l.repos.SeriesRepo;

@SpringBootApplication
public class Vttp5PafDay06lApplication implements CommandLineRunner{

	@Autowired
	private SeriesRepo seriesRepo;
	public static void main(String[] args) {
		SpringApplication.run(Vttp5PafDay06lApplication.class, args);
	}

	@Override
	public void run(String... args){
		//use the query
		List<Document> result = seriesRepo.findSeriesByName("the");
		List<Document> seriesResults = seriesRepo.findSeriesByRating(7.3f);

		result.stream()
		.limit(3)
		.forEach(d -> {
			System.out.println(d.toJson());
			System.out.printf("NAME: %s\n",d.getString("name"));
			List<String> genres = d.getList("genres", String.class);
			for(String g :genres){
				System.out.printf("%s",g);

			}
			Document schedule = (Document)d.get("schedule"); //this is to get a jsonObject from inside the document
			System.out.println("time is" + schedule.getString("time")); //this gets an attribute in the jsonObject
		});

		for(int i =0; i <3; i++){
			Document d = result.get(i);
			System.out.println(d.toJson());
		}

		System.out.println("TYPES OF SERIES" + seriesRepo.findTypeOfSeries());
	}

}
