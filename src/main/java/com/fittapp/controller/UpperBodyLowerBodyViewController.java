package com.fittapp.controller;

import com.fittapp.model.PushPullLegView;
import com.fittapp.model.UpperBodyLowerBodyView;
import com.fittapp.repository.PushPullLegViewRepository;
import com.fittapp.repository.UpperBodyLowerBodyViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ublbview")
public class UpperBodyLowerBodyViewController {

    @Autowired
    UpperBodyLowerBodyViewRepository upperBodyLowerBodyViewRepository;

    @GetMapping("/list")
    //@Transactional
    public List<UpperBodyLowerBodyView> list(){
        List<UpperBodyLowerBodyView> list = upperBodyLowerBodyViewRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }
}
