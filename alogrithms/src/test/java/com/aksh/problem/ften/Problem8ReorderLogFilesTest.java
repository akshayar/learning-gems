/**
 * 
 */
package com.aksh.problem.ften;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author aksha
 *
 */
class Problem8ReorderLogFilesTest {

	@Test
	void testDigitMatcher() {
		Assertions.assertTrue("123".matches(Problem8ReorderLogFiles.DIGIT_REGEX));
		Assertions.assertFalse("1e23".matches(Problem8ReorderLogFiles.DIGIT_REGEX));
	}
	
	@Test
	void testLogic() {
		String[] arr=new String[] {"digi1 8151","let1 art can","dig2 36","let2 own kit dig","let3 art zero"};
		Problem8ReorderLogFiles problem=new Problem8ReorderLogFiles(arr);
		System.out.println(problem.sort());
		
	}

}
