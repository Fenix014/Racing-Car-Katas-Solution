package tddmicroexercises.textconvertor.impl;

import java.io.IOException;

import tddmicroexercises.textconvertor.ITextPageReader;

public class TextPageFileReader extends TextFileReader implements ITextPageReader {

	public TextPageFileReader(String fullFilenameWithPath) {
		super(fullFilenameWithPath);
	}

	public void close() {
		try {
			this.reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void skip(Integer n) {
		try {
			this.reader.skip(n);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
