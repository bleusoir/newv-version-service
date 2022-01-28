package dev.newv.version.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "spec")
public class Spec {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idx", nullable = false)
    private Long id;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "site_url")
    private String siteUrl;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Spec spec = (Spec) o;
        return id != null && Objects.equals(id, spec.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}