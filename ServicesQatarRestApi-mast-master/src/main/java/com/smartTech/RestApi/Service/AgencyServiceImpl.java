package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.Agency;

import com.smartTech.RestApi.Repository.AgencyRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AgencyServiceImpl implements AgencyService{


    @Autowired
    private AgencyRepository agencyRepository;






    @Override
    public Agency getSingleAgency(Long id) {


        Optional<Agency> agency=agencyRepository.findById(id);

        if(agency.isPresent()){
            return agency.get();
        }
        throw new RuntimeException("Agency not available");
    }



    @Override
    public List<Agency> getAgencies() {
        return agencyRepository.findAll();
    }

    @Override
    public Agency saveAgency(Agency agency) {
        return agencyRepository.save(agency);
    }
}
