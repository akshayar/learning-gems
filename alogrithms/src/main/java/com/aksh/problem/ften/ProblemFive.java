package com.aksh.problem.ften;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author aksha
 * 
 *         Say you have an array for which the ith element is the price of a
 *         given stock on day i. If you were only permitted to complete at most
 *         one transaction ( buy one and sell one share of the stock) , design
 *         an algorithm to find the maximum profit.
 *
 * 
 */
public class ProblemFive {

	public static class PriceTuple {
		int buyDay;
		float buyPrice;
		int sellDay;
		float sellPrice;

		public PriceTuple(int day, float price) {
			super();
			this.buyDay = day;
			this.buyPrice = price;
		}

		public PriceTuple(int buyDay, float buyPrice, int sellDay, float sellPrice) {
			super();
			this.buyDay = buyDay;
			this.buyPrice = buyPrice;
			this.sellDay = sellDay;
			this.sellPrice = sellPrice;
		}
		
		double getProfit(){
			return sellPrice-buyPrice;
		}
		
		@Override
			public String toString() {
				return ToStringBuilder.reflectionToString(this);
			}

	}

	private Stream<PriceTuple> joinWithArray(PriceTuple pt, float[] prices) {
		return IntStream.range(0, prices.length).filter(i -> pt.buyDay < i && pt.buyPrice < prices[i])
				.mapToObj(i -> new PriceTuple(pt.buyDay, pt.buyPrice, i, prices[i]));

	}

	private PriceTuple printMaxProfit(float[] prices) {
		System.out.println("Checking the max profit");
		Stream<PriceTuple> cartesianProd = IntStream.range(0, prices.length).mapToObj(i -> new PriceTuple(i, prices[i]))
				.flatMap(pt -> joinWithArray(pt, prices));
		return cartesianProd.max(Comparator.comparing(PriceTuple::getProfit)).orElse(null);
	}

	public static void main(String[] args) {
		System.out.println(new ProblemFive().printMaxProfit(new float[] {7,1,5,3,6,4}));
	}
}
