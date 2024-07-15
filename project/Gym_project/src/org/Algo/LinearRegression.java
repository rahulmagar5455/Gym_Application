package org.Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.gym.service.AlgoService;

import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.durationModel;

public class LinearRegression {

	private double[] x;
	private double[] y;
	private double slope;
	private double intercept;

	public LinearRegression(double[] x, double[] y) {
		this.x = x;
		this.y = y;
	}

	public void calculate() {
		double sumX = Arrays.stream(x).sum();
		double sumY = Arrays.stream(y).sum();
		double sumXY = 0;
		double sumXX = 0;
		int n = x.length;

		for (int i = 0; i < n; i++) {
			sumXY += x[i] * y[i];
			sumXX += x[i] * x[i];
		}

		double xMean = sumX / n;
		double yMean = sumY / n;

		slope = (sumXY - n * xMean * yMean) / (sumXX - n * xMean * xMean);
		intercept = yMean - slope * xMean;
	}

	public double predict(double input) {
		return slope * input + intercept;
	}

	public void getResult(int v) {
		int input = v;
		AlgoService alservice = new AlgoService();
		List<durationModel> list = new ArrayList<durationModel>();

		durationModel dm = new durationModel();

		list = alservice.getDurationId();
		int size = list.size();
		double x[] = new double[size];
		double y[] = new double[size];

		int i = 0;

		for (durationModel c : list) {

			x[i] = c.getDurid();
			y[i] = c.getDurcharge();
			i++;

		}

		LinearRegression lr = new LinearRegression(x, y);
		lr.calculate();

		double prediction = lr.predict(input);
		System.out.println("Total Fee for " + input + "Month is: " + prediction);
	}

	public LinearRegression(int v) {

		int input = v;
		this.getResult(v);

	}

	public double getSlope() {
		return slope;
	}

	public double getIntercept() {
		return intercept;
	}

}
