package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.Services;
import com.smartTech.RestApi.Repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesServiceImpl implements ServicesServices {


    @Autowired
    private ServicesRepository servicesRepository;


    @Override
    public List<Services> getServices() {
        return servicesRepository.findAll();
    }

    @Override
    public Services saveServices(Services services) {
        return servicesRepository.save(services);
    }


// find user by id from the database

@Override
public Services getSingleService(Long id) {
    Optional<Services> services = servicesRepository.findById(id);
    if (services.isPresent()) {

        return services.get();
    }
    throw new RuntimeException("Service not available" + id);
}

    @Override
    public void deleteService(Long id) {

        servicesRepository.deleteById(id);

    }

    @Override
    public Services updateService(Services services) {
        return servicesRepository.save(services);
    }

    @Override
    public List<Services> getServicesTitle(String title) {
        return servicesRepository.findBytitle(title);
    }

    @Override
    public List<Services> getServicesByTitleAndLocation(String Address) {
        return servicesRepository.findByaddress(Address);
    }

    @Override
    public List<Services> getServicesByPrice(int price) {
        return servicesRepository.findByPrice(price);
    }

    @Override
    public List<Services> getServicesBySlug(String slug) {
        return servicesRepository.findBySlug(slug);
    }

    @Override
    public List<Services> getServicesByDescription(String description) {
        return servicesRepository.findByDescription(description);
    }

    @Override
    public List<Services> getServicesByCategory(int category_id) {

        return servicesRepository.findByCategory_id(category_id);
    }

    @Override
    public List<Services> getServicesByRegion_id(String region_id) {
        return servicesRepository.findByRegion_id(region_id);
    }

    @Override
    public void deleteService(String description) {
        servicesRepository.DeleteByDescription(description);
    }



    @Override
    public List<Services> findViewsWithSortingAsc() {

        return servicesRepository.findAllOrderByPopulationAsc();

    }

    public List<Services>findServicesWithPaginationAndSorting(String field) {
        return servicesRepository.findAll(Sort.by(Sort.Direction.ASC, field));

    }
        public Page<Services> findServicesWithPagination(int offset,int pageSize){
            Page<Services>service=servicesRepository.findAll(PageRequest.of(offset,pageSize));

            return service;
        }

        public Page<Services>findServicesWithPaginationSorting(int offset,int pageSize,String field){

            Page<Services>service=servicesRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
            return service;
        }


}


