package com.codecool.web.service;

import com.codecool.web.dto.ApplicationDto;
import com.codecool.web.model.Application;
import com.codecool.web.repository.AdRepository;
import com.codecool.web.repository.ApplicationRepository;
import com.codecool.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository uRepo;

    @Autowired
    private AdRepository adRepo;


    public List<Application> getAll() {
        return applicationRepository.findAll();
    }

    public Application getById(int id) {
        return applicationRepository.findById(id);
    }

    public List<Application> getAllByApplicantIdOrderByTimestampDesc(int id) {
        return applicationRepository.findAllByApplicant_IdOrderByTimestampDesc(id);
    }

    public List<Application> getAllByAdIdOrderByTimestampAsc(int id) {
        return applicationRepository.findAllByAd_IdOrderByTimestampAsc(id);
    }

    public Application addNewApplication(ApplicationDto application) {
        application.setTimestamp(new Timestamp(new Date().getTime()).toLocalDateTime());
        return applicationRepository.save(new Application(application,adRepo.findById(application.getAdId()),uRepo.findById(application.getApplicantId())));

    }

    public void deleteApplication(int id) {
        applicationRepository.deleteById(id);
    }

    public Application updateApplicationData(Application application) {
        applicationRepository.save(application);
        return application;
    }

}
