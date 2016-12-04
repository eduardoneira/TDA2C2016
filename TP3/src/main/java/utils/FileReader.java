package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader implements Parser {

	private BufferedReader bf;
	
	public FileReader(String path) throws FileNotFoundException {
		super();
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(path).getFile());

		this.bf = new BufferedReader(new java.io.FileReader(file));
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
