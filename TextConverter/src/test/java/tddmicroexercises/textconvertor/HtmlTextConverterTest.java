package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class HtmlTextConverterTest {
	@Test
	public void getFileName() {
		String filename = "fileName";
		HtmlTextConverter converter = new HtmlTextConverter(filename);

		assertEquals(filename, converter.getFilename());
	}

	@Test
	public void convertToHtml() {
		ITextReader textReader = mock(ITextReader.class);
		when(textReader.readLine()).thenReturn("text to trasform in HTML").thenReturn(null);
		HtmlTextConverter converter = new HtmlTextConverter("fileName");
		converter.setTextReader(textReader);

		assertEquals("text to trasform in HTML<br />", converter.convertToHtml());
	}
}
