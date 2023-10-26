package br.com.zeroglosa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "zero-glosa")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class ZeroGlosa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

}
