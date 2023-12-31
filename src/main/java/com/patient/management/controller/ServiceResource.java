/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.patient.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patient.management.DTO.PatientInformationDTO;
import com.patient.management.DTO.ServiceResponse;
import com.patient.management.DTO.VisitHistoryDTO;
import com.patient.management.services.PatientInformationServices;
import com.patient.management.services.VisitHistoryService;
import com.patient.management.util.ApplicationUtil;

/**
 *
 * @author user
 */

@CrossOrigin
@RestController
@RequestMapping(ApplicationUtil.API_VERSION)
@Service
public class ServiceResource {
    @Autowired
    private PatientInformationServices patientService;
    @Autowired
    private VisitHistoryService historyService;

    @PostMapping("/addpatient")
    public ResponseEntity<ServiceResponse> createPatientInformation(@Valid @RequestBody PatientInformationDTO dto)
	    throws Exception {
	ServiceResponse response = patientService.createPatientInformation(dto);
	return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("/listpatient")
    public ResponseEntity<ServiceResponse> findAllPatients() throws Exception {
	ServiceResponse response = patientService.findAll();
	return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("patient/{id}")
    public ResponseEntity<ServiceResponse> findById(@PathVariable("id") int patientId) throws Exception {
	ServiceResponse response = patientService.findById(patientId);
	return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("patient_id/{patientid}")
    public ResponseEntity<ServiceResponse> findByPatientId(@PathVariable("patientid") long patientId) throws Exception {
	ServiceResponse response = patientService.findByPatientId(patientId);
	return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("patient/age_between")
    public ResponseEntity<ServiceResponse> findByAgeBetween(
	    @RequestParam(value = "startage", defaultValue = "1", required = true) int startage,
	    @RequestParam(value = "endage", defaultValue = "10", required = true) int endAge) throws Exception {
	ServiceResponse response = patientService.findByAgeBetween(startage, endAge);
	return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping("history/addvisit")
    public ResponseEntity<ServiceResponse> addPatientVisit(@Valid @RequestBody VisitHistoryDTO dto) throws Exception {
	ServiceResponse response = historyService.createVisit(dto);
	return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("history/listvisits")
    public ResponseEntity<ServiceResponse> listVisitHistory() throws Exception {
	ServiceResponse response = historyService.findAll();
	return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("visithistory/{patientid}")
    public ResponseEntity<ServiceResponse> listVisitHistoryByPatientId(@PathVariable(value = "patientid") int patientId)
	    throws Exception {
	ServiceResponse response = historyService.findHistoryByPatientId(patientId);
	return new ResponseEntity<>(response, response.getStatus());
    }
}
