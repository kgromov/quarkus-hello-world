package org.kgromov;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
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
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {
    @Inject
    CityRepository cityRepository;

    @GET
    public List<City> getCities() {
        List<CityEntity> cities = CityEntity.listAll();
        return cityRepository.listAll(Sort.by("name"));
    }

    @GET
    @Path("/projection")
    public List<CityProjection> getCitiesProjection() {
        // really confusing - why not query()?!
        PanacheQuery<PanacheEntityBase> query = CityEntity.findAll(Sort.by("name"));
        return query.project(CityProjection.class).list();
    }

    @GET
    @Path("{id}")
    public CityEntity getCity(Long id) {
        return CityEntity.findById(id);
    }

    @GET
    @Path("{id}/projection")
    public CityProjection getCityProjection(Long id) {
        return CityEntity.find("id", id)
                .project(CityProjection.class)
                .firstResult();
    }
}

