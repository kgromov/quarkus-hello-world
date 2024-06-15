package org.kgromov;

import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/countries")
@Produces(MediaType.APPLICATION_JSON)
public class CountryResource {
    @Inject CountryRepository countryRepository;

    @GET
    public List<CountryEntity> getCountries() {
//        return CountryEntity.listAll(Sort.by("name"));
        return countryRepository.listAll(Sort.by("name"));
    }

    @GET
    @Path("{code}")
    public CountryEntity getCountry(String code) {
//        return CountryEntity.findById(id);
        return countryRepository.findById(code);
    }
}

