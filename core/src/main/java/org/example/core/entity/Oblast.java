package org.example.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`Admin_Obl`")
public class Oblast extends AbstractEntity {
    @Id
    @Column(name = "`Kod_Obl`")
    private Long id;
    @Column(name = "`Name_Obl`")
    private String name;
    @Column(name = "`Name_OblRP`")
    private String name_oblRP;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "`Kod_Obl`")
    private List<Plho> plhoList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "`Kod_Obl`")
    private List<Rayon> rayonList = new ArrayList<>();
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName_oblRP() {
        return name_oblRP;
    }

    public void setName_oblRP(String name_oblRP) {
        this.name_oblRP = name_oblRP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plho> getPlhoList() {
        return plhoList;
    }

    public void setPlhoList(List<Plho> plhoList) {
        this.plhoList = plhoList;
    }

    public List<Rayon> getRayonList() {
        return rayonList;
    }

    public void setRayonList(List<Rayon> rayonList) {
        this.rayonList = rayonList;
    }
}
