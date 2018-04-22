package tddmicroexercises.textconvertor;

public class HtmlTextConverter {
	private String filename;
	private ITextReader textReader;

	public HtmlTextConverter(String filename) {
		this.filename = filename;
	}

	public String convertToHtml() {
		String line = textReader.readLine();
		String html = "";
		while (line != null) {
			html += StringEscapeUtils.escapeHtml(line);
			html += "<br />";
			line = textReader.readLine();
		}
		return html;

	}

	public String getFilename() {
		return this.filename;
	}

	public void setTextReader(ITextReader textReader) {
		this.textReader = textReader;
	}
}
