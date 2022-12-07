package com.fittapp.controller;

import com.fittapp.model.AllPlanView;
import com.fittapp.model.Exercise;
import com.fittapp.repository.AllPlanViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/allplan")
public class AllPlanViewController {

    @Autowired
    AllPlanViewRepository allPlanViewRepository;

    @GetMapping("")
    public List<AllPlanView> list(){
        List<AllPlanView> list = allPlanViewRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }

}
