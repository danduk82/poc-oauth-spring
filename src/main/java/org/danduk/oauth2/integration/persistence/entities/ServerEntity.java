package org.danduk.oauth2.integration.persistence.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "server", schema = "settings", catalog = "oauth")
public class ServerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "ogcprotocol")
    private String ogcprotocol;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "version")
    private String version;
    @Basic
    @Column(name = "url")
    private String url;
    @Basic
    @Column(name = "queryable")
    private Boolean queryable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOgcprotocol() {
        return ogcprotocol;
    }

    public void setOgcprotocol(String ogcprotocol) {
        this.ogcprotocol = ogcprotocol;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getQueryable() {
        return queryable;
    }

    public void setQueryable(Boolean queryable) {
        this.queryable = queryable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerEntity that = (ServerEntity) o;
        return id == that.id && Objects.equals(ogcprotocol, that.ogcprotocol) && Objects.equals(title, that.title) && Objects.equals(version, that.version) && Objects.equals(url, that.url) && Objects.equals(queryable, that.queryable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ogcprotocol, title, version, url, queryable);
    }
}
