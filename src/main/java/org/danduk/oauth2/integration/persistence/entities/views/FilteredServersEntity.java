package org.danduk.oauth2.integration.persistence.entities.views;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
@Table(name = "filtered_servers", schema = "settings", catalog = "oauth")
public class FilteredServersEntity {
    @Basic
    @Column(name = "user_email")
    private String userEmail;
    @Basic
    @Column(name = "id")
    private Long id;
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

    public String getUserEmail() {
        return userEmail;
    }

    public Long getId() {
        return id;
    }

    public String getOgcprotocol() {
        return ogcprotocol;
    }

    public String getTitle() {
        return title;
    }

    public String getVersion() {
        return version;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getQueryable() {
        return queryable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilteredServersEntity that = (FilteredServersEntity) o;
        return Objects.equals(userEmail, that.userEmail) && Objects.equals(id, that.id) && Objects.equals(ogcprotocol, that.ogcprotocol) && Objects.equals(title, that.title) && Objects.equals(version, that.version) && Objects.equals(url, that.url) && Objects.equals(queryable, that.queryable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, id, ogcprotocol, title, version, url, queryable);
    }
}
