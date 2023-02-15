package org.danduk.oauth2.integration.persistence.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "bindings", schema = "settings", catalog = "oauth")
public class BindingsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "fk_users_id")
    private Long fkUsersId;
    @Basic
    @Column(name = "fk_role_id")
    private Long fkRoleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getFkUsersId() {
        return fkUsersId;
    }

    public void setFkUsersId(Long fkUsersId) {
        this.fkUsersId = fkUsersId;
    }

    public Long getFkRoleId() {
        return fkRoleId;
    }

    public void setFkRoleId(Long fkRoleId) {
        this.fkRoleId = fkRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BindingsEntity that = (BindingsEntity) o;
        return id == that.id && Objects.equals(fkUsersId, that.fkUsersId) && Objects.equals(fkRoleId, that.fkRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkUsersId, fkRoleId);
    }
}
