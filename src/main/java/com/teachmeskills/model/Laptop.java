package com.teachmeskills.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Scope("prototype")
@Component
@Entity(name = "laptops")
public class Laptop {
    @Id
    @SequenceGenerator(name = "laptops_id_seq", sequenceName = "laptops_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "laptops_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @Column(name = "os")
    private String os;

    @Size(max = 255)
    @NotNull
    @Column(name = "screen", nullable = false)
    private String screen;

    @Size(max = 255)
    @NotNull
    @Column(name = "cpu", nullable = false)
    private String cpu;

    @Size(max = 255)
    @NotNull
    @Column(name = "video_card", nullable = false)
    private String videoCard;

    @Size(max = 255)
    @NotNull
    @Column(name = "memory", nullable = false)
    private String memory;

    @Column(name = "discount")
    private Long discount;

    @Size(max = 255)
    @Column(name = "image")
    private String image;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created", nullable = false)
    private Instant created;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated")
    private Instant updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(id, laptop.id) && Objects.equals(name, laptop.name) && Objects.equals(os, laptop.os) && Objects.equals(screen, laptop.screen) && Objects.equals(cpu, laptop.cpu) && Objects.equals(videoCard, laptop.videoCard) && Objects.equals(memory, laptop.memory) && Objects.equals(discount, laptop.discount) && Objects.equals(image, laptop.image) && Objects.equals(created, laptop.created) && Objects.equals(updated, laptop.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, os, screen, cpu, videoCard, memory, discount, image, created, updated);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", os='" + os + '\'' +
                ", screen='" + screen + '\'' +
                ", cpu='" + cpu + '\'' +
                ", videoCard='" + videoCard + '\'' +
                ", memory='" + memory + '\'' +
                ", discount=" + discount +
                ", image='" + image + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}