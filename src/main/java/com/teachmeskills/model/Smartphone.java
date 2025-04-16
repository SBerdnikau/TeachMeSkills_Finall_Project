package com.teachmeskills.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.Scope;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
@Entity
@Table(name = "smartphones")
public class Smartphone {
    @Id
    @ColumnDefault("nextval('smartphones_id_seq')")
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
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
    @Column(name = "created", nullable = false)
    private Instant created;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated")
    private Instant updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Boolean getESimSupport() {
        return eSimSupport;
    }

    public void setESimSupport(Boolean eSimSupport) {
        this.eSimSupport = eSimSupport;
    }

    public Long getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(Long cameraResolution) {
        this.cameraResolution = cameraResolution;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

}