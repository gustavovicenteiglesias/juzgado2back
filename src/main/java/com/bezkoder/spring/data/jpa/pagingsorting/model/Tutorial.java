package com.bezkoder.spring.data.jpa.pagingsorting.model;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutorials")
public class Tutorial {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "published")
  private boolean published;


    public Tutorial(String title, String description, boolean b) {
    }
}
