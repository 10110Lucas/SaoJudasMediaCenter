package br.usjt.MediaCenter.test.exemplos;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.MediaCenter.model.JPAUtil;
public class TestUploadArquivoTexto {
	private static String conteudo;
	private static BufferedReader leitor;
	private static File file;
	

	//como o arquivo ainda não existe, irei criar para testar com os seguintes dados ...
	private static String diretorio =   "C:"
				        +File.separator+"Users"
						+File.separator+"lucas"
				        +File.separator+"Desktop"
						+File.separator;
	private static String nomeArquivo = "Testando.criptos";
	private static String texto = "Estou testando o teste que podera ser implementado se funcionar!\n   \nLinha 3: se chegou até aqui, voce conseguiu terminar!";
	
	public void salvar() {
		
		//----------- metodo para criar arquivo para teste ----------- 
		criarArquivo(diretorio, nomeArquivo, texto);
		
		//----------- metodo para ler qualquer arquivo e retornar o conteudo ----------- 
		lerArquivo(nomeArquivo);
		
		//----------- parte da insersao no banco de dados -----------
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
//		Arquivos arquivo = new Arquivos();
//		arquivo.setNome_arquivo(file.getName());
//		arquivo.setTexto(conteudo);
		
//		manager.persist(arquivo);
		transaction.commit();
		
		manager.close();
		JPAUtil.close();
	}
	
	
	//----------- Metodo para ler o arquivo -----------
	public String lerArquivo(String nome) {
		file = new File(nome);
		try {
			Stream<String> stream = Files.lines(Paths.get(nome));
			String s = stream.collect(Collectors.joining());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {			
			//leitura de arquivo
			FileInputStream inFileStream = new FileInputStream(file);
			InputStreamReader abreArquivo = new InputStreamReader(inFileStream);
			leitor = new BufferedReader(abreArquivo);

			conteudo = new String();
			
			do {
				conteudo += leitor.readLine();
 			}while(leitor.readLine() != null);
			
			return conteudo;
			
		}catch(IOException e) {
			System.out.println("Nada funcionou! " + e.getMessage());
			System.out.println("Leitura --> Local -->" + file.getPath() + "--> Directory? -->" + file.isDirectory() + "--> Path? -->" + file.exists());
		}
		return "falhou";
	}
	
	//----------- Metodo para criar um arquivo para testar
	public void criarArquivo(String diretorio, String nome, String texto){
		try {	
			// set up the streams
			file = new File(diretorio + nome);
			
			if(file.exists() == true) {
				file.delete();
				file.createNewFile();
			}
			else {
				file.createNewFile();
			}
			
			FileOutputStream outFileStream = new FileOutputStream(file);
			DataOutputStream outDataStream = new DataOutputStream(outFileStream);
			// Escreve no tipo UTF
			outDataStream.writeUTF(texto);
			outDataStream.close();
			outFileStream.close();
			
		}catch(IOException e) {
			System.out.println("Nada funcionou! " + e.getMessage());
			System.out.println("Escrito --> Local -->" + file.getPath() + "--> Directory? -->" + file.isDirectory() + "--> Path? -->" + file.exists());
		}
	}
	
//	private Material salvarNoBanco(Path rootLocation, String nome, Estagiario estagiario) {
//		if(rootLocation.toString().contains("image")) {
//			Figura figura = new Figura();
//			figura.setNome(nome);
//			figura.setEstagiarios(Arrays.asList(estagiario));
//			return figuraRepository.save(figura);
//		} else if(rootLocation.toString().contains("video")){
//			Video video = new Video();
//			video.setNome(nome);
//			video.setEstagiarios(Arrays.asList(estagiario));
//			return videoRepository.save(video);
//		} else if(rootLocation.toString().contains("audio")) {
//			Audio audio = new Audio();
//			audio.setNome(nome);
//			audio.setEstagiarios(Arrays.asList(estagiario));
//			return audioRepository.save(audio);
//		} else if(rootLocation.toString().contains("text")) {
//			Texto texto = new Texto();
//			texto.setNome(nome);
//			texto.setEstagiarios(Arrays.asList(estagiario));
//			return textoRepository.save(texto);
//		}
//		throw new StorageException("Tipo de arquivo não suportado");
//	}
}