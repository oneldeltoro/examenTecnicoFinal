package com.prueba.tecnica.microservicio.domain.models.base;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseIdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Basic(fetch = FetchType.EAGER)
    public Long id;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date", insertable = false, updatable = false)
    private Date createdDate;
    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "last_modified_date", insertable = false, updatable = false)
    private Date lastModifiedDate;
}