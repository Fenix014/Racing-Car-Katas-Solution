package tddmicroexercises.textconvertor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HtmlPagesConverterTest {

	@Test
	public void getFileName() {
		ITextPageReader textPageReader = mock(ITextPageReader.class);
		ITextPageBreaker textPageBreak = mock(ITextPageBreaker.class);

		String filename = "fileName";
		HtmlPagesConverter converter = new HtmlPagesConverter(textPageReader, textPageBreak, filename);
		assertEquals(filename, converter.getFilename());
	}

	@Test
	public void getHtmlPage() {
		ITextPageReader textPageReader = mock(ITextPageReader.class);
		when(textPageReader.readLine()).thenReturn("text to trasform in HTML").thenReturn(null);

		List<Integer> breaks = new ArrayList<Integer>();
		breaks.add(1);
		ITextPageBreaker textPageBreak = mock(ITextPageBreaker.class);
		when(textPageBreak.getBreaks()).thenReturn(breaks).thenReturn(null);

		HtmlPagesConverter converter = new HtmlPagesConverter(textPageReader, textPageBreak, "fileName");

		assertEquals("text to trasform in HTML<br />", converter.getHtmlPage(0));
	}
}
