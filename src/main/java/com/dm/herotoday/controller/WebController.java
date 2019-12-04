package com.dm.herotoday.controller;

import com.dm.herotoday.dao.impl.DBMaintenance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
@CrossOrigin
public class WebController {

    @Inject
    private DBMaintenance mdao;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Object indexPage(Model model) {

        model.addAttribute("ctx", "");
        return "index.html";
    }

    @ResponseBody
    @RequestMapping(value = {"/status"}, method = RequestMethod.GET)
    public String status() {
        return "true";
    }

    @ResponseBody
    @RequestMapping(value = {"/dbrefresh"}, method = RequestMethod.GET)
    public String dbrefresh() {

        this.mdao.refresh();
        return "Successfully refreshed";
    }
}
