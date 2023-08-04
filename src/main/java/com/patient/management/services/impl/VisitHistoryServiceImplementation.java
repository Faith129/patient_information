/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.patient.management.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.patient.management.DTO.ServiceResponse;
import com.patient.management.DTO.VisitHistoryDTO;
import com.patient.management.entities.PatientInformation;
import com.patient.management.entities.VisitHistory;
import com.patient.management.exception.ResourceNotFoundException;
import com.patient.management.repository.PatientInformationRepository;
import com.patient.management.repository.VisitHistoryRepository;
import com.patient.management.services.VisitHistoryService;

/**
 *
 * @author user
 */
@Service
public class VisitHistoryServiceImplementation implements VisitHistoryService {
    @Autowired
    private VisitHistoryRepository visitHistoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PatientInformationRepository patientInformationRepository;

    @Override
    public ServiceResponse findAll() throws Exception {
	List<VisitHistory> history = visitHistoryRepository.findAll();
	String message = !history.isEmpty() ? "History found successfully" : "No records found";
	return ServiceResponse.builder().message(message).status(HttpStatus.OK).data(history).build();
    }

    @Override
    public ServiceResponse createVisit(VisitHistoryDTO dto) throws Exception {
	PatientInformation patientInfo = patientInformationRepository.findById(dto.getPatientId()).orElseThrow(
		() -> new ResourceNotFoundException("The patient with id " + dto.getPatientId() + " does not exist"));
	VisitHistory history = modelMapper.map(dto, VisitHistory.class);
	history.setPatientInfo(patientInfo);
	return ServiceResponse.builder().message("History saved successfully").status(HttpStatus.OK)
		.data(visitHistoryRepository.save(history)).build();
    }

    @Override
    public ServiceResponse findHistoryByPatientId(int patientId) throws Exception {
	PatientInformation patientInfo = patientInformationRepository.findById(patientId).orElseThrow(
		() -> new ResourceNotFoundException("The patient with id " + patientId + " does not exist"));
	List<VisitHistory> history = visitHistoryRepository.findByPatientInfo(patientInfo);
	String message = !history.isEmpty() ? "History found successfully" : "No records found";
	return ServiceResponse.builder().message(message).status(HttpStatus.OK).data(history).build();
    }

}
