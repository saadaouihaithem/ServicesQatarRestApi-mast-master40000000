package com.smartTech.RestApi.dto;

import com.smartTech.RestApi.Model.Region;
import com.smartTech.RestApi.Model.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T>{


        public int status;
     T Services;
    }


