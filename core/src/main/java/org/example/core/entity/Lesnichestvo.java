package org.example.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "`Admin_Lesnich`")
public class Lesnichestvo extends AbstractEntity {
    @Id
    @Column(name = "`MAPINFO_ID`")
    private Long id;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "`LeshosKod`")
//    private Leshos leshos;
    @Column(name = "`LesnichName`")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Leshos getLeshos() {
//        return leshos;
//    }
//
//    public void setLeshos(Leshos leshos) {
//        this.leshos = leshos;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
