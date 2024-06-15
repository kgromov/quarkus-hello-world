package org.kgromov;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "country")
public class CountryEntity /*extends PanacheEntityBase*/{
    @Id
    @Column(name = "Code")
    public String code;
    @Column(name = "Name")
    public String name;
    @Column(name = "SurfaceArea")
    public BigDecimal area;
    @Column(name = "Population")
    public Integer population;
    @Column(name = "Capital")
    public String capital;
    @Column(name = "GovernmentForm")
    public String governmentForm;
    @Column(name = "Continent")
    public String continent;
    @Column(name = "Region")
    public String region;
    @Column(name = "IndepYear")
    public Short independenceYear;
    @Column(name = "LifeExpectancy")
    public BigDecimal lifespan;
    @Column(name = "GNP")
    public BigDecimal gnp;
    @Column(name = "GNPOld")
    public BigDecimal gnpOld;
    @Column(name = "LocalName")
    public String localName;
    @Column(name = "HeadOfState")
    public String head;
    @Column(name = "Code2")
    public String code2;


}
