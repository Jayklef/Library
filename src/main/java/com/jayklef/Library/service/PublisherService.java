package com.jayklef.Library.service;

import com.jayklef.Library.entity.Publisher;
import com.jayklef.Library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher createPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher getPublisher(Long id){
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Publisher not found"));
        return publisher;
    }

    public void deletePublisher(Long id){
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Publisher not found"));
        publisherRepository.deleteById(publisher.getId());
    }
}
