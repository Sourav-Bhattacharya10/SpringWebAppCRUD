package com.vegshop.demovegshop;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VegController
{
    @Autowired
    private VegRepository vegRepository;
    
    //private int _AddVegStatus = -1;
    //private String _VegName = "Blah Blah";
    //private int _VegCost = 0;

    @RequestMapping("/welcome")
    public String ViewAllVegs(Model model)
    {
        List<Vegetable> vegList = vegRepository.findAll();

        model.addAttribute("vegList", vegList);

        return "welcome";
    }

    @GetMapping("/add")
    public String AddVeg()
    {
        // if(_AddVegStatus == -1)
        // {
        //     model.addAttribute("vegName", _VegName);
        //     model.addAttribute("vegCost", _VegCost);
        //     model.addAttribute("addVegStatus", "");
        // }
        // else if(_AddVegStatus == 0)
        // {
        //     model.addAttribute("vegName", _VegName);
        //     model.addAttribute("vegCost", _VegCost);
        //     model.addAttribute("addVegStatus", "Failed");
        // }
        // else
        // {
        //     model.addAttribute("vegName", _VegName);
        //     model.addAttribute("vegCost", _VegCost);
        //     model.addAttribute("addVegStatus", "Succeeded");
        // }

        return "add";
    }

    @PostMapping("/add")
    public String AddVeg(@RequestParam(name="vegname") String vegName, @RequestParam(name="vegcost") int vegCost)
    {
        String addStr = "null";
        int addVegStatus = -1;

        Vegetable sentVeg = new Vegetable();
        sentVeg.VegName = vegName;
        //_VegName = vegName;
        sentVeg.VegCost = vegCost;
        addVegStatus = vegRepository.insertItem(sentVeg);
        //_VegCost = vegCost;
        //_AddVegStatus = addVegStatus;

        if(addVegStatus == 1)
            addStr = "redirect:/welcome";
        else
            addStr = "redirect:/add";

        return addStr;
    }

    // @PostMapping("/add")
    // public int AddVeg(@RequestParam("vegname") String vegName, @RequestParam("vegcost") int vegCost)
    // {
    //     Vegetable sentVeg = new Vegetable();
    //     sentVeg.VegName = vegName;
    //     _VegName = vegName;
    //     sentVeg.VegCost = vegCost;
    //     int addVegStatus = vegRepository.insertItem(sentVeg);
    //     _VegCost = vegCost;
    //     _AddVegStatus = addVegStatus;

    //     return addVegStatus;
    // }
}