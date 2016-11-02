package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader implements Parser {

	private BufferedReader bf;
	
	public FileReader(String path) throws FileNotFoundException {
		super();
		this.bf = new BufferedReader(new java.io.FileReader(path));
	}

	@Override
	public int read() throws IOException {
		return this.bf.read();
	}

	@Override
	public String readLine() throws IOException {
		return this.bf.readLine();
	}

	@Override
	public void close() throws IOException {
		this.bf.close();
	}

}
