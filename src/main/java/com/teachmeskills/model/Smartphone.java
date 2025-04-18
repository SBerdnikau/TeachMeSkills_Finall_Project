package com.teachmeskills.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Scope("prototype")
@Component
@Entity(name = "smartphones")
public class Smartphone {
    @Id
    @SequenceGenerator(name = "smartphones_id_seq", sequenceName = "smartphones_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "smartphones_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 2, max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 2, max = 255)
    @NotNull
    @Column(name = "screen", nullable = false)
    private String screen;

    @Size(max = 255)
    @NotNull
    @Column(name = "cpu", nullable = false)
    private String cpu;

    @NotNull
    @ColumnDefault("false")
    @Column(name = "e_sim_support", nullable = false)
    private Boolean eSimSupport = false;

    @NotNull
    @Column(name = "camera_resolution", nullable = false)
    private Long cameraResolution;

    @Column(name = "discount")
    private Long discount;

    @Size(max = 255)
    @Column(name = "image")
    private String image;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created", nullable = false, updatable = false)
    private Timestamp created;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated")
    private Timestamp updated;

    @PrePersist
    protected void onCreate() {
        created = new Timestamp(System.currentTimeMillis());
        updated = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(screen, that.screen) && Objects.equals(cpu, that.cpu) && Objects.equals(eSimSupport, that.eSimSupport) && Objects.equals(cameraResolution, that.cameraResolution) && Objects.equals(discount, that.discount) && Objects.equals(image, that.image) && Objects.equals(created, that.created) && Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, screen, cpu, eSimSupport, cameraResolution, discount, image, created, updated);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", screen='" + screen + '\'' +
                ", cpu='" + cpu + '\'' +
                ", eSimSupport=" + eSimSupport +
                ", cameraResolution=" + cameraResolution +
                ", discount=" + discount +
                ", image='" + image + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}