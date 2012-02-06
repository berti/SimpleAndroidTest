/*
 * Copyright 2012 Alberto Salmerón Moreno
 * 
 * This file is part of SimpleAndroidTest - https://github.com/berti/SimpleAndroidTest
 * 
 * SimpleAndroidTest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SimpleAndroidTest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SimpleAndroidTest.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.primoberti.simpleandroidtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Data associated with a question, including question phrase and options.
 * 
 * @author berti
 */
public class Question {

	/* Private fields ************************** */

	private String phrase;

	private String[] options;

	/* Private static fields ******************* */

	private final static Pattern QUESTION_PATTERN = Pattern
			.compile("^(.*)\\{(.+)\\}(.*)$");

	/* Constructors **************************** */

	/**
	 * Create a new question with the given phrase and options. The first option
	 * is the correct one. Thus, when presenting the options to a user, they
	 * should be randomized.
	 * 
	 * @param phrase the phrase that poses the question
	 * @param options the options of to answer the question; the first one is
	 *            the correct one
	 */
	public Question(String phrase, String[] options) {
		this.phrase = phrase;
		this.options = options;
	}

	/* Static factory methods ****************** */

	public static Question parseQuestion(String text) {
		Question question = null;

		Matcher matcher = QUESTION_PATTERN.matcher(text);
		if (matcher.matches()) {
			String phrase = matcher.group(1);
			if (matcher.group(3) != null && !matcher.group(3).isEmpty()) {
				phrase += "____" + matcher.group(3);
			}

			String[] options = matcher.group(2).split(",");
			for (int i = 0; i < options.length; i++) {
				options[i] = options[i].trim();
			}
			question = new Question(phrase, options);
		}

		return question;
	}

	/* Public methods ************************** */

	public String getPhrase() {
		return phrase;
	}

	public String[] getOptions() {
		return options;
	}
	
	public String getCorrectOption() {
		return options[0];
	}

	public boolean isCorrect(CharSequence option) {
		return options[0].equals(option);
	}

}
