package org.danduk.oauth2.integration.persistence.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "acl", schema = "settings", catalog = "oauth")
public class AclEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "fk_layer_id")
    private Long fkLayerId;
    @Basic
    @Column(name = "fk_role_id")
    private Long fkRoleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getFkLayerId() {
        return fkLayerId;
    }

    public void setFkLayerId(Long fkLayerId) {
        this.fkLayerId = fkLayerId;
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
        AclEntity aclEntity = (AclEntity) o;
        return id == aclEntity.id && Objects.equals(fkLayerId, aclEntity.fkLayerId) && Objects.equals(fkRoleId, aclEntity.fkRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkLayerId, fkRoleId);
    }
}
