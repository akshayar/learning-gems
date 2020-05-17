/**
 * 
 */
package com.aksh.problem.ften;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author aksha
 *
 *         You have an array of logs. Each log is a space-delimited string of
 *         words. For each log the first word in each log is an alphanumeric
 *         identifier. Then either each word after the identifier will consist
 *         only of lowercase letters or each word after the identifier will
 *         consist only of digits. We will call these two varieties of logs
 *         letter-logs and digit-logs. It is guaranteed that each log has at
 *         least one word after its identifier. Record the logs so that all of
 *         the letter-logs come before any digit log. The letter-logs are
 *         ordered lexicographically ignoring identifiers with the identifier
 *         used in case of ties. The digit-logs should be put in their original
 *         order. Return the final order of the logs.
 * 
 *         Input - String[] of logs.
 */
public class Problem8ReorderLogFiles {
	String[] logs;
	public static final String DIGIT_REGEX = "[0-9]*";
	


	public Problem8ReorderLogFiles(String[] arr) {
		super();
		this.logs = arr;
	}

	public static class Tuple {
		String id;
		String log;
		String origString;
		boolean isDigit;

		public Tuple(String logS) {
			super();
			this.origString = logS;
			String[] logArr = logS.split(" ");
			this.id = logArr[0];
			this.log = logArr[1];
			this.isDigit = Optional.ofNullable(log).orElse("").matches(DIGIT_REGEX);
		}

		public boolean isDigit() {
			return isDigit;
		}

		public String getOrigString() {
			return origString;
		}

		public String getId() {
			return id;
		}

		public String getLog() {
			return log;
		}
	}

	public List<String> sort() {
		List<String> digitList = getStreamOfTuples().filter(Tuple::isDigit).map(Tuple::getOrigString)
				.collect(Collectors.toList());
		Stream<Tuple> letterLogs = getStreamOfTuples().filter(t -> {
			return !t.isDigit();
		}).sorted(Comparator.comparing(Tuple::getLog).thenComparing(Tuple::getId));
		List<String> letterList =letterLogs.map(Tuple::getOrigString).collect(Collectors.toList());
		letterList.addAll(digitList);
		return letterList;
	}

	private Stream<Tuple> getStreamOfTuples() {
		return Arrays.asList(logs).stream().map(Tuple::new);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("123".matches(DIGIT_REGEX));

	}

}
