package com.example.dorywcza.model.service_offer;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@Entity
public class ServiceOffer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private int userId;
    private String industry;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private ServiceDateRange serviceDateRange;
    private boolean hasExperience;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private ServiceJobSalary serviceJobSalary;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private ServiceLocation serviceLocation;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private ServiceSchedule serviceSchedule;

    public ServiceOffer(int userId, String industry, String title, ServiceDateRange serviceDateRange,
                        boolean hasExperience, ServiceJobSalary serviceJobSalary, ServiceLocation serviceLocation,
                        ServiceSchedule serviceSchedule) {
        this.userId = userId;
        this.industry = industry;
        this.title = title;
        this.serviceDateRange = serviceDateRange;
        this.hasExperience = hasExperience;
        this.serviceJobSalary = serviceJobSalary;
        this.serviceLocation = serviceLocation;
        this.serviceSchedule = serviceSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOffer that = (ServiceOffer) o;
        return userId == that.userId && hasExperience == that.hasExperience && Objects.equals(industry, that.industry) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, industry, title, hasExperience);
    }
}
