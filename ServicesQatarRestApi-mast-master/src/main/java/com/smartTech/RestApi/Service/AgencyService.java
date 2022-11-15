package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.Agency;


import java.util.List;

public interface AgencyService {


    Agency getSingleAgency(Long id );
    List<Agency> getAgencies();
    Agency saveAgency(Agency agency);
}
