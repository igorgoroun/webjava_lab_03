package com.lab.web.lab_031.lib;
import lombok.Data;

@Data
public class Calculator {
    public final static double TOLERANCE = 1.0e-6;
    private double a = 1.5;
    private double min_x = 0.8;
    private double max_x = 2.0;
    private double step = 0.005;
    private double break_line = 1.7;

    public CalculationResult result;

    public Calculator() {}

    public Calculator(double a, double min_x, double max_x, double step, double break_line) {
        this.a = a;
        this.min_x = min_x;
        this.max_x = max_x;
        this.step = step;
        this.break_line = break_line;
    }

    public void compute() {
        CalculationResult result = new CalculationResult(this.steps());
        int i = 0;
        for (double x = this.min_x; x <= this.max_x; x += this.step) {
            result.set_x_i(x, i);
            result.set_y_i(this.apply_fun(x), i);
            i++;
        }
        this.result = result;
    }

    public int steps() {
        return (int) ((this.max_x - this.min_x) / step) + 1;
    }

    private double apply_fun(double x) {
        if (x < this.break_line - TOLERANCE) {
            return this.fun_lt(x);
        } else if (Math.abs(x - this.break_line) < TOLERANCE) {
            return this.fun_eq(x);
        } else {
            return this.fun_gt(x);
        }
    }

    private double fun_lt(double x) {
        return Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2);
    }
    private double fun_eq(double x) {
        return this.a * Math.pow(x, 3) + 7 * Math.sqrt(x);
    }
    private double fun_gt(double x) {
        return Math.log10(x + 7 * Math.sqrt(x));
    }
}
