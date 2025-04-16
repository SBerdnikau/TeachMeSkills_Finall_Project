package com.teachmeskills.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Scope("prototype")
@Component
@Entity(name = "catalog_products")
public class CatalogProduct {
    @Id
    @SequenceGenerator(name = "catalog_products_id_gen", sequenceName = "catalog_products_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalog_products_id_gen")
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "name_catalog", nullable = false, length = 100)
    private String nameCatalog;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created", nullable = false)
    private Instant created;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated")
    private Instant updated;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id", nullable = false)
    private Laptop product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogProduct that = (CatalogProduct) o;
        return Objects.equals(id, that.id) && Objects.equals(nameCatalog, that.nameCatalog) && Objects.equals(created, that.created) && Objects.equals(updated, that.updated) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCatalog, created, updated, product);
    }

    @Override
    public String toString() {
        return "CatalogProduct{" +
                "id=" + id +
                ", nameCatalog='" + nameCatalog + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", product=" + product +
                '}';
    }
}