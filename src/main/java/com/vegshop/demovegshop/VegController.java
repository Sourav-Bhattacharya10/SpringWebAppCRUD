package com.vegshop.demovegshop;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VegController
{
    @Autowired
	private VegRepository vegRepository;

    @RequestMapping("/welcome")
    public String welcomeMessage(Model model)
    {
        List<Vegetable> vegList = vegRepository.findAll();

        model.addAttribute("vegList", vegList);

        return "welcome";
    }
}