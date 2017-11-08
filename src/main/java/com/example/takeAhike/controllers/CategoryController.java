package com.example.takeAhike.controllers;

import com.example.takeAhike.models.Data.CategoryDao;
import com.example.takeAhike.models.Forms.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by area on 7/17/17.
 */
@Controller
@RequestMapping("category")
public class CategoryController {

        @Autowired
        private CategoryDao categoryDao;

        @RequestMapping(value = "")
        public String index(Model model) {

            model.addAttribute("categories", categoryDao.findAll());
            model.addAttribute("title", "Categories");

            return "category/index";
        }
        @RequestMapping (value = "add", method = RequestMethod.GET)
        public String add (Model model) {

            model.addAttribute(new Category());
            model.addAttribute("title", "Add Category");

            return "category/add";
        }

        @RequestMapping (value = "add", method = RequestMethod.POST)
        public String add (Model model, @ModelAttribute @Valid Category newCategory, Errors errors) {

            if (errors.hasErrors()) {
                model.addAttribute("title", "Add Category");
                return "category/add";
            }
            categoryDao.save(newCategory);
            return "redirect:";

        }

        // TODO add remove function, link with remove category template //

    }
