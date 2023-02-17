package org.danduk.oauth2.integration.persistence.entities.views;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "merged_layer_acl", schema = "settings", catalog = "oauth")
public class MergedLayerAclEntity {
    @Basic
    @Column(name = "user_email")
    private String userEmail;
    @Basic
    @Column(name = "user_id")
    private Long userId;
    @Basic
    @Column(name = "id")
    private Long id;
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
    @Basic
    @Column(name = "queriable")
    private Boolean queriable;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getQueriable() {
        return queriable;
    }

    public void setQueriable(Boolean queriable) {
        this.queriable = queriable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MergedLayerAclEntity that = (MergedLayerAclEntity) o;
        return Objects.equals(userEmail, that.userEmail) && Objects.equals(userId, that.userId) && Objects.equals(id, that.id) && Objects.equals(fkServerId, that.fkServerId) && Objects.equals(name, that.name) && Objects.equals(title, that.title) && Objects.equals(matrixset, that.matrixset) && Objects.equals(queriable, that.queriable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, userId, id, fkServerId, name, title, matrixset, queriable);
    }
}
