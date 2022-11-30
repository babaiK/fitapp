package com.fittapp.controller;

import com.fittapp.model.PushPullLeg;
import com.fittapp.model.PushPullLegView;
import com.fittapp.repository.PushPullLegViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pplview")
public class PushPullLegViewController {

    @Autowired
    PushPullLegViewRepository pushPullLegViewRepository;

    @GetMapping("/list")
    //@Transactional
    public List<PushPullLegView> list(){
        List<PushPullLegView> list = pushPullLegViewRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }
}
