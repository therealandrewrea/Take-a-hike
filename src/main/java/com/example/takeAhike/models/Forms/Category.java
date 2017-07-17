package com.example.takeAhike.models.Forms;

import com.example.takeAhike.models.Forms.Hike;
import com.example.takeAhike.models.Forms.Category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Created by area on 6/19/17.
 */

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Hike> hikes = new ArrayList<>();

    public Category(){
    }

    public Category (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
