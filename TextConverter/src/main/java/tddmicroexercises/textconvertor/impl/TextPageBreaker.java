package tddmicroexercises.textconvertor.impl;

import java.util.ArrayList;
import java.util.List;

import tddmicroexercises.textconvertor.ITextPageBreaker;
import tddmicroexercises.textconvertor.ITextPageReader;

public class TextPageBreaker implements ITextPageBreaker {
	
	private ITextPageReader textPageReader;
    private List<Integer> breaks = new ArrayList<Integer>();

	public List<Integer> getBreaks() {
		this.breaks.add(0);
        int cumulativeCharCount = 0;
        String line = textPageReader.readLine();
        while (line != null)
        {
            cumulativeCharCount += line.length() + 1; // add one for the newline
            if (line.contains("PAGE_BREAK")) {
                int page_break_position = cumulativeCharCount;
                breaks.add(page_break_position);
            }
            line = textPageReader.readLine();
        }
        textPageReader.close();
        return this.breaks;
	}
	
	public void setTextPageReader(ITextPageReader textPageReader) {
		this.textPageReader = textPageReader;
	}
}
