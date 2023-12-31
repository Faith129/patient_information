/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.patient.management.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author user
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "visit_history")
public class VisitHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "visitHistoryId")
    private int visitHistoryId;
    @Column(name = "allergy")
    private String allergy;
    @Column(name = "health_condition")
    private String health_condition;
    @Column(name = "medication")
    private String medication;
    @Column(name = "date_visited")
    private Date dateVisited;
    @Column(name = "family_history")
    private String familyHistory;
    @ToString.Include
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
    private PatientInformation patientInfo;

}
