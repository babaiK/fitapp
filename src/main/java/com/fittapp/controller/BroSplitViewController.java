package com.fittapp.controller;

import com.fittapp.model.BroSplitView;
import com.fittapp.model.PushPullLegView;
import com.fittapp.repository.BroSplitViewRepository;
import com.fittapp.repository.PushPullLegViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bsview")
public class BroSplitViewController {
    @Autowired
    BroSplitViewRepository broSplitViewRepository;

    @GetMapping("/list")
    //@Transactional
    public List<BroSplitView> list(){
        List<BroSplitView> list = broSplitViewRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }
}
