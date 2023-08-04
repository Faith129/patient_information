/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.patient.management.services;

import com.patient.management.DTO.PatientInformationDTO;
import com.patient.management.DTO.ServiceResponse;

public interface PatientInformationServices {
    ServiceResponse createPatientInformation(PatientInformationDTO dto) throws Exception;

    ServiceResponse findByPatientId(long patientId) throws Exception;

    ServiceResponse findById(int id) throws Exception;

    ServiceResponse findAll() throws Exception;

    ServiceResponse findByAgeBetween(int startAge, int endAge) throws Exception;

}
