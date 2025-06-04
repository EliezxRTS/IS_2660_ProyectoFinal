package mx.unam.aragon.ico.is.monhanapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "monsters")
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_monster", insertable = false, updatable = false)
    private Long idMonster;

    @Column(name = "name_monster", nullable = false, length = 50)
    @NotNull(message = "Nulls are not accepted in the name")
    @NotBlank(message = "Blanks are not accepted in the name")
    private String name;

    @Column(name = "alias_monster", nullable = true, length = 150)
    private String alias;

    @Column(name = "classification_monster", nullable = false, length = 50)
    @NotNull(message = "Nulls are not accepted in the classification")
    @NotBlank(message = "Blanks are not accepted in the classification")
    private String classification;

    @Column(name = "pic_url_monster", nullable = true, insertable = false, columnDefinition = "VARCHAR(250) DEFAULT 'https://tiermaker.com/images/chart/chart/final-bosses-tier-list-monster-hunter-171616/1stgen-questionmarkiconpng.png'")
    private String picture;

    @Column(name = "element_monster", nullable = true, length = 150)
    private String elements;

    public Monster() {
    }

    public Monster(Long idMonster, String name, String alias, String classification, String picture, String elements) {
        this.idMonster = idMonster;
        this.name = name;
        this.alias = alias;
        this.classification = classification;
        this.picture = picture;
        this.elements = elements;
    }

    public Long getIdMonster() {
        return idMonster;
    }

    public void setIdMonster(Long idMonster) {
        this.idMonster = idMonster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "idMonster=" + idMonster +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", classification='" + classification + '\'' +
                ", picture='" + picture + '\'' +
                ", elements='" + elements + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return idMonster == monster.idMonster && Objects.equals(name, monster.name) && Objects.equals(alias, monster.alias) && Objects.equals(classification, monster.classification) && Objects.equals(picture, monster.picture) && Objects.equals(elements, monster.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMonster, name, alias, classification, picture, elements);
    }
}
