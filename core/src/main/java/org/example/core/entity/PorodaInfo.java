package org.example.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ref_10200003")
public class PorodaInfo extends AbstractEntity {
    @Id
    @Column(name = "`RefValue_ID`")
    private Long id;
    @Column(name = "`RefValue_txt`")
    private String name;
    @Column(name = "`RefValue_short`")
    private String shortName;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
