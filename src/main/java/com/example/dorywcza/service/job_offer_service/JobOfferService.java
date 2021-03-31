package com.example.dorywcza.service.job_offer_service;


import com.example.dorywcza.model.offer.DTO.OfferPostDTO;
import com.example.dorywcza.model.job_offer.JobOffer;
import com.example.dorywcza.repository.job_offer_repository.JobOfferRepository;
import com.example.dorywcza.service.OfferDTOExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOfferService {

    private final JobOfferRepository repository;
    private final OfferDTOExtractor offerDTOExtractor;

    @Autowired
    public JobOfferService(JobOfferRepository repository, OfferDTOExtractor offerDTOExtractor) {
        this.repository = repository;
        this.offerDTOExtractor = offerDTOExtractor;
    }

    public List<JobOffer> findAll(){
        return repository.findAll();
    }

    public JobOffer save(OfferPostDTO offerPostDTO){
        JobOffer jobOffer = offerDTOExtractor.getOffer(offerPostDTO);
        return repository.save(jobOffer);
    }


}