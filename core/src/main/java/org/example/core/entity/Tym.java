package org.example.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ref_2")
public class Tym extends AbstractEntity {
    @Id
    @Column(name = "`RefValue_ID`")
    private Long id;
    @Column(name = "`RefValue_txt`")
    private String name;

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
}
