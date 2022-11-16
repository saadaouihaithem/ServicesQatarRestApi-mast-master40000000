package com.smartTech.RestApi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Category")
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String name;
    public String name_ar;
    public String image;
    public int  category_id ;
    public int properties_count;
    public int services_count;
}