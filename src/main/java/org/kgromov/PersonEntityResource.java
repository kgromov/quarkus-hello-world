package org.kgromov;

import com.github.javafaker.Faker;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/persons/entity")
public class PersonEntityResource {
    @Inject PersonEntityRepository personEntityRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Transactional
    public List<PersonEntity> getPersons(){
        return personEntityRepository.listAll(Sort.by("firstName"));
    }

    @Path("/test-create")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String createRandomPerson() {
        var faker = new Faker();
        var name = faker.name();
        var person = new PersonEntity();
        person.setFirstName(name.firstName());
        person.setLastName(name.lastName());
        personEntityRepository.persistAndFlush(person);
        long count = personEntityRepository.count();
        return count > 2 ? "OK" : "Sucks";
    }
}
