/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.patient.management.services;

import com.patient.management.DTO.ServiceResponse;
import com.patient.management.DTO.VisitHistoryDTO;

/**
 *
 * @author user
 */
public interface VisitHistoryService {
    ServiceResponse findHistoryByPatientId(int patientId) throws Exception;

    ServiceResponse findAll() throws Exception;

    ServiceResponse createVisit(VisitHistoryDTO dto) throws Exception;
}
