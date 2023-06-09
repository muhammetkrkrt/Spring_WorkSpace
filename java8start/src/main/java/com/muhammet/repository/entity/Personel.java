package com.muhammet.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblpersonel")
@Builder
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String adres;
    String telefon;
    String photo;
    Integer yas;
    String acildurumtelefonu;
    String acildurumkisisi;
    Long giristarihi;

    Integer type;
}
