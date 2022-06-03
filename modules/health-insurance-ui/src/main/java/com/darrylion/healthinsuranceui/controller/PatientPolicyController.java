package com.darrylion.healthinsuranceui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientPolicyController {

    @GetMapping("/index")
    public String all() {

        return "index";
    }

    @GetMapping("/add_patient_policy")
    public String addPatientPolicy() {

        return "add_patient_policy";
    }

    @GetMapping("/edit_patient_policy")
    public String editPatientPolicy() {

        return "edit_patient_policy";
    }
}
