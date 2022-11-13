package com.smartTech.RestApi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Region")
public class Region{

    @Id

    @GeneratedValue(strategy= GenerationType.AUTO)
    public int region_id;
    public String name;
    public String name_ar;
    public int properties_count;
    public int services_count;
}