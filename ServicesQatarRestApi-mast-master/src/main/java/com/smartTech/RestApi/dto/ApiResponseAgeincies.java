package com.smartTech.RestApi.dto;

import com.smartTech.RestApi.Model.Agency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseAgeincies {

    public int status;
    public ArrayList<Agency> agencies;
    public int page;
    public String message;
}
