package sn.esmt.CV.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appcv")
public class CvEntity {
    @Id //JPA est clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id devient autoIncrement et dans l'ordre
    private int id;
    @Column(length = 150, nullable = false)
    private String nom;
    @Column(length = 150, nullable = false)
    private String prenom;
    @Column(length = 150, nullable = false)
    private int age;
    @Column(length = 150, nullable = false, unique = true)
    private String adresse;
    @Column(length = 150, nullable = false, unique = true)
    private String email;
    @Column(length = 150, nullable = false)
    private String telephone;
    @Column(length = 150, nullable = false)
    private String specialite;
    @Column(length = 150, nullable = false)
    private String niveauEtude;
    @Column(length = 150, nullable = false)
    private String experienceProfessionnelle;

}