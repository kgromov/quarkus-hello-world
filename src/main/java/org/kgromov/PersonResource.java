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
@Path("/persons/active-record")
public class PersonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Transactional
    public List<Person> getPersons(){
        // does not work - holly crap! - overrides of base entity is required :)
        return Person.listAll(Sort.by("firstName", "lastName"));
//        return Person.listAll();
    }

    @Path("/test-create")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String createRandomPerson() {
        var faker = new Faker();
        var name = faker.name();
        var person = new Person();
        person.firstName = name.firstName();
        person.lastName = name.lastName();
        person.persistAndFlush();
        long count = Person.count();
        return count > 2 ? "OK" : "Sucks";
    }
}
