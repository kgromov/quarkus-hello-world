package org.kgromov;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class CityEntity extends PanacheEntity {
    @Column(name = "Name")
    public String name;

    @Column(name = "District")
    public String district;
    @Column(name = "Population")
    public Long population;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CountryCode",
            referencedColumnName = "Code",
            foreignKey = @ForeignKey(name = "city_ibfk_1"),
            nullable = false
    )
    // aka @JsonView hardcoded - so all columns from CountryEntity are loaded and then filtered
    @JsonIgnoreProperties({"name", "code", "capital", "population", "area"})
    public CountryEntity country;
}
