package com.jonah.vttp5_paf_day01l.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Setup implements CommandLineRunner{
    //Autowire service and repo, to load files


    @Override
    public void run(String... args){
        System.out.println("number of elements " + args.length);
        for (int i = 0; i<args.length; i++){
            System.out.println(args[i]);
        }

    }
}
