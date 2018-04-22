package tddmicroexercises.textconvertor;

import java.util.List;

public class HtmlPagesConverter {

	private String filename;
	private ITextPageReader textPageReader;
	private ITextPageBreaker textPageBreaker;

	public HtmlPagesConverter(ITextPageReader textPageReader, ITextPageBreaker textPageBreaker, String filename) {
		this.filename = filename;
		this.textPageReader = textPageReader;
		this.textPageBreaker = textPageBreaker;
	}

	public String getHtmlPage(int page) {
		List<Integer> breaks = textPageBreaker.getBreaks();
		textPageReader.skip(breaks.get(page));
		StringBuffer htmlPage = new StringBuffer();
		String line = textPageReader.readLine();
		while (line != null) {
			if (line.contains("PAGE_BREAK")) {
				break;
			}
			htmlPage.append(StringEscapeUtils.escapeHtml(line));
			htmlPage.append("<br />");

			line = textPageReader.readLine();
		}
		textPageReader.close();
		return htmlPage.toString();
	}

	public String getFilename() {
		return this.filename;
	}

}
