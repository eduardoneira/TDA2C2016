package utils;

import java.io.IOException;

public interface Parser {	
	int read() throws IOException;
	String readLine() throws IOException;
	void close() throws IOException;
}
