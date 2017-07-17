package com.example.takeAhike.controllers;

import com.example.takeAhike.models.Data.CategoryDao;
import com.example.takeAhike.models.Data.HikeDao;
import com.example.takeAhike.models.Forms.Hike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by area on 7/17/17.
 */
@Controller
public class HikeController {

    @Autowired
    private HikeDao hikeDao;

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        // attributes to pass to homepage/index

        return "/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String DisplayAddHikeForm(Model model) {
        // attributes to pass when going to add input screen

        return "/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ProcessAddHikeForm(@ModelAttribute @Valid Hike newHike, Errors errors, Model model) {
        // attributes to pass from view to controller/model - saving a new hike

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add A Hike");
            return "/add";
        }
            hikeDao.save(newHike);
        // how to pass in the values of the new hike to display at top of page //
            model.addAttribute("title", "Add Categories to Your Hike");
            return "/category/add";
        }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveHikeForm(Model model) {
        model.addAttribute("cheeses", hikeDao.findAll());
        model.addAttribute("title", "Remove Hike");
        return "/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveHikeForm(@RequestParam int[] hikeIds) {

        for (int hikeId : hikeIds) {
            hikeDao.delete(hikeId);
        }

        return "redirect:";
    }

}


/*
@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    @Autowired
    private CategoryDao categoryDao;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheeses");
        model.addAttribute("category", cheeseDao);

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("categories", categoryDao.findAll());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, @RequestParam int categoryId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }
        Category cat = categoryDao.findOne(categoryId);
        newCheese.setCategory(cat);
        cheeseDao.save(newCheese);
        return "redirect:";
    }


}
*/
