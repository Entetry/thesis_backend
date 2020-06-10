package org.example.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "`Admin_Raion`")
public class Rayon extends AbstractEntity {
    @Id
    @Column(name = "`Kod_Rai`")
    private Long id;
    @Column(name = "`Name_Rai`")
    private String name;
    @Column(name = "`MAPINFO_ID`")
    private Long mapinfo;

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

    public Long getMapinfo() {
        return mapinfo;
    }

    public void setMapinfo(Long mapinfo) {
        this.mapinfo = mapinfo;
    }
}
