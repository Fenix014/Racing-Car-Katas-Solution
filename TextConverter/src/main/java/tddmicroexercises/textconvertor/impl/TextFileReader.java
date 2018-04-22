package tddmicroexercises.textconvertor.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import tddmicroexercises.textconvertor.ITextReader;

public class TextFileReader implements ITextReader {

	protected BufferedReader reader;

	public TextFileReader(String fullFilenameWithPath) {
		try {
			reader = new BufferedReader(new FileReader(fullFilenameWithPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String readLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean hasMoreLines() {
		return false;// HARDCODED to example
	}

}
