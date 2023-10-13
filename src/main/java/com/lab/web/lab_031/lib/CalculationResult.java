package com.lab.web.lab_031.lib;

import lombok.Data;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


@Data
public class CalculationResult {
    private final double[] xArray;
    private final double[] yArray;
    private final int steps;

    public CalculationResult(int res_len) {
        this.steps = res_len;
        this.xArray = new double[res_len];
        this.yArray = new double[res_len];
    }

    public int get_steps() {
        return this.steps;
    }

    private double rnd(double n) {
        return Math.round(n * 100000) / 100000d;
    }

    public int get_max() {
        int req_index = 0;
        for (int i = 0; i < this.yArray.length; i++) {
            if (this.yArray[i] > this.yArray[req_index]) {
                req_index = i;
            }
        }
        return req_index;
    }

    public List<ResultingPoint> get_points() {
        List<ResultingPoint> points = new ArrayList<>();
        for (int i = 0; i < this.yArray.length; i++) {
            points.add(new ResultingPoint(rnd(this.xArray[i]), rnd(this.yArray[i])));
        }
        return points;
    }

    public int get_min() {
        int req_index = 0;
        for (int i = 0; i < this.yArray.length; i++) {
            if (this.yArray[i] < this.yArray[req_index]) {
                req_index = i;
            }
        }
        return req_index;
    }

    public double get_sum() {
        return rnd(Arrays.stream(this.yArray).sum());
    }
    public double get_avg() {
        return rnd(Arrays.stream(this.yArray).average().orElse(0));
    }

    public void set_x_i(double x, int i) {
        this.xArray[i] = x;
    }
    public double get_x(int i) {
        if (i >= this.steps) return 0;
        return rnd(this.xArray[i]);
    }

    public void set_y_i(double y, int i) {
        this.yArray[i] = y;
    }
    public double get_y(int i) {
        if (i >= this.steps) return 0;
        return rnd(this.yArray[i]);
    }

}
