package com.hashedin.moviesearch;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Importer {
	private List<String> movielist;
    private String filename;
	public void parseFile() 
	{
		/**
		 * Parsing Text File into New Array List
		 */
		movielist=new ArrayList<String>();
		try
		{
			@SuppressWarnings("resource")
			BufferedReader buffer = new BufferedReader(new FileReader(filename));
			String line = "";
			while ((line = buffer.readLine()) != null) {
				String[] tokens = line.split("\\|");
				for(int i=0;i<tokens.length;i++)
				{
					movielist.add(tokens[i]);
				}

			}

		} catch (Exception e) {
			System.err.println("Parse Error: " + e.getMessage());
		}

	}

	public List<String> getList() {
		return movielist;
	}

	public void setfilename(String filename)
	{
		this.filename=filename;
	}


}
