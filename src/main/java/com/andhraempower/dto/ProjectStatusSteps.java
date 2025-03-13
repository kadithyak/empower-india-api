package com.andhraempower.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectStatusSteps {

    private boolean committeeFormed;
    private boolean bankDetailsAdded;
    private boolean estimationAdded;
}
