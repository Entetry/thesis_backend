package org.example.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`Admin_Leshos`")
public class Leshos extends AbstractEntity{
    @Id
    @Column(name = "`LeshosKod`")
    private Long id;
//    @JoinColumn(name = "`PlhoKod`")
//    private Plho plho;
    @Column(name = "`Leshos'")
    private String name;
 //   @OneToMany(mappedBy = "leshos",cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Lesnichestvo> lesnichestvoList = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//
//    public Plho getPlho() {
//        return plho;
//    }
//
//    public void setPlho(Plho plho) {
//        this.plho = plho;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Lesnichestvo> getLesnichestvoList() {
//        return lesnichestvoList;
//    }
//
//    public void setLesnichestvoList(List<Lesnichestvo> lesnichestvoList) {
//        this.lesnichestvoList = lesnichestvoList;
//    }
}
