package tddmicroexercises.textconvertor;

public interface ITextPageReader extends ITextReader {
	void close();
	void skip(Integer integer);
}
