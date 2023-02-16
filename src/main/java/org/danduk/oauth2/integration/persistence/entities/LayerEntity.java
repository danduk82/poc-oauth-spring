package org.danduk.oauth2.integration.persistence.entities;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "layer", schema = "settings", catalog = "oauth")
public class LayerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "fk_server_id")
    private Long fkServerId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "matrixset")
    private String matrixset;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getFkServerId() {
        return fkServerId;
    }

    public void setFkServerId(Long fkServerId) {
        this.fkServerId = fkServerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMatrixset() {
        return matrixset;
    }

    public void setMatrixset(String matrixset) {
        this.matrixset = matrixset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LayerEntity that = (LayerEntity) o;
        return id == that.id && Objects.equals(fkServerId, that.fkServerId) && Objects.equals(name, that.name) && Objects.equals(title, that.title) && Objects.equals(matrixset, that.matrixset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkServerId, name, title, matrixset);
    }
}
