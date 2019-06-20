package br.usjt.MediaCenter.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Local {
	
	public Local() {}
	
	public static File setLocal(String nome, byte[] arquivo) {
		File file;
		FileOutputStream arq = null;
		String local = "C:\\Users\\lucas\\Documents\\Universidade_Sao_Judas_Tadeu\\Eclipse-workspace\\MediaCenter\\src\\main\\resources\\static\\Downloads\\";
		
		file = new File(local + nome);
		try {
			arq = new FileOutputStream(file);
			arq.write(arquivo);
			arq.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}

}
