package org.example.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`Admin_Plho`")
public class Plho {
    @Id
    @Column(name = "`PlhoKod`")
    private Long id;
    @Column(name = "`Plho`")
    private String name;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "`PlhoKod`")
//    private List<Leshos> leshosList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlho() {
        return name;
    }

    public void setPlho(String plho) {
        this.name = plho;
    }


}
