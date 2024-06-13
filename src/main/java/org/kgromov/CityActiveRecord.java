package org.kgromov;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class CityActiveRecord extends PanacheEntity {
    @Column(name = "Name")
    public String name;
    @Column(name = "CountryCode")
    public String countryCode;
    @Column(name = "District")
    public String district;
    @Column(name = "Population")
    public Long population;
}
