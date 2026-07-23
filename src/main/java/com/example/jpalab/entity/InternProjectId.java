package com.example.jpalab.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InternProjectId implements Serializable {
    private Integer internId;
    private Integer projectId;


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if ( !(object instanceof InternProjectId)) {
            return false;
        }

        InternProjectId other = (InternProjectId) object;
        return (Objects.equals(internId, other.internId)) && (Objects.equals(projectId, other.projectId));
    }

    @Override
    public int hashCode() {
        return Objects.hash(internId, projectId);
    }


}
