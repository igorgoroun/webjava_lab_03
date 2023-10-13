package com.lab.web.lab_031.beans;
import com.lab.web.lab_031.lib.Calculator;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Named
@SessionScoped
@Data
public class CalculatorBean implements Serializable {
    Calculator calculator = new Calculator();

    public String compute() {
        calculator.compute();
        System.out.println("Run compute");
        return "computation_result";
    }
}
