package com.truesize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePreloader implements CommandLineRunner {

    private final AllShoeRepository allShoeRepository;

    @Autowired
    public DatabasePreloader(AllShoeRepository allShoeRepository){
        this.allShoeRepository = allShoeRepository;
    }

    @Override
    public void run(String... strings) throws Exception{
        this.allShoeRepository.save(new UserShoe("NikeKD8", 17.0));
        this.allShoeRepository.save(new UserShoe("NikeKD9", 17.5));
    }


}
