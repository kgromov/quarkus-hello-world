package org.kgromov;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/cities")
public class CityResource {
    @Inject
    CityRepository cityRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Transactional
    public List<City> getPersons() {
        List<CityActiveRecord> cities = CityActiveRecord.listAll();
        return cityRepository.listAll(Sort.by("name"));
    }
}

