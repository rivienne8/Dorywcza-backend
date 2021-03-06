package com.example.dorywcza.model.offer;

import com.example.dorywcza.model.job_offer.JobOffer;
import com.example.dorywcza.model.service_offer.ServiceOffer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "INDUSTRY")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Industry {

    @Id
    @Column(name = "INDUSTRY_ID")
    @GeneratedValue
    private Long id;
    private String name;
    private Long parentId;

    @OneToMany(mappedBy = "industry")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<JobOffer> jobOffers;

    @OneToMany(mappedBy = "industry")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private List<ServiceOffer> serviceOffers;

    public Industry(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}


