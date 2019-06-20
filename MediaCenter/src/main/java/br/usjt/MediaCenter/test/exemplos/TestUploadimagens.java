package br.usjt.MediaCenter.test.exemplos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class TestUploadimagens {
//	private PrintWriter arquivo;
	
	public static void main(String args[]) throws IOException {
		String diretorio =      "C:"
		        +File.separator+"Users"
				+File.separator+"lucas"
		        +File.separator+"Desktop"
				+File.separator+"TestandoTestes.txt";		
//		String nomeDoArquivo =  "TestandoTestes.txt";
		String texto =          "Estou tesntado o teste que podera ser implementado se funcionar!\nLinha 2: se chegou até aqui, voce conseguiu terminar!";
		
//		byte[] vetor = getImagem(imagem(diretorio + "PinguimLinux.png"));
//		System.out.println(getImagem(imagem(diretorio + "PinguimLinux.png")));
		crirArquivo(diretorio, texto);
		lerArquivo(diretorio);
	}
	
	public static void lerArquivo(String nome) {
		try {
			// set up file and stream
			File file = new File(nome);
	//		inFile.mkdir();
	//		inFile.createNewFile();
			
			if(file.exists()) {
				System.out.println(file.getAbsolutePath());
				FileInputStream inFileStream = new FileInputStream(file);
				DataInputStream inDataStream = new DataInputStream(inFileStream);
				
				// read values back from the stream and display them
				System.out.println(inDataStream.readUTF());
				System.out.println(inDataStream.readInt());
				System.out.println(inDataStream.readLong());
				System.out.println(inDataStream.readFloat());
				System.out.println(inDataStream.readDouble());
				System.out.println(inDataStream.readChar());
				System.out.println(inDataStream.readBoolean());
				// input done, so close the stream
				inDataStream.close();
				inFileStream.close();
			}else {
				System.out.println("Arquivo não existe ou não encontrado!");
				System.out.println("--> Local -->" + file.getPath() + "--> Directory? -->" + file.isDirectory() + "--> Path? -->" + file.exists());
			}
		}catch(IOException e) {
			System.out.println("Nada funcionou! " + e);
		}
	}
	
	public static void crirArquivo(String nome, String escritura){
		try {	
			// set up the streams
			File file = new File(nome);
			if(file.exists() == true) {
				file.delete();
				file.createNewFile();
				FileOutputStream outFileStream = new FileOutputStream(file);
				DataOutputStream outDataStream = new DataOutputStream(outFileStream);
				// write values of primitive data types to the stream
				outDataStream.writeUTF(escritura);
				outDataStream.writeInt(987654321);
				outDataStream.writeLong(11111111L);
				outDataStream.writeFloat(22222222F);
				outDataStream.writeDouble(3333333D);
				outDataStream.writeChar('A');
				outDataStream.writeBoolean(true);
				// output done, so close the stream
				outDataStream.close();
				outFileStream.close();
			}
			System.out.println("--> Local -->" + file.getPath() + "--> Directory? -->" + file.isDirectory() + "--> Path? -->" + file.exists());
		}catch(IOException e) {
			System.out.println("Nada funcionou! ");
		}
	}
	
//	public static File imagem(String diretorio) {
//		JFileChooser fileChooser = new JFileChooser();
//		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens em JPEG e PNG", "jpg", "png");
//		fileChooser.addChoosableFileFilter(filtro);
//		fileChooser.setAcceptAllFileFilterUsed(false);
//		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
//		fileChooser.setCurrentDirectory(new File(diretorio));
//		fileChooser.showOpenDialog(fileChooser);
//		
//		return fileChooser.getSelectedFile();
//	}
	
//	public static byte[] getImagem(File imagem) {
//		boolean isPng = false;
//		byte[] byteArray;
//		
//		if(imagem != null) {
//			isPng = imagem.getName().endsWith("png");
//			
//			try {
//				BufferedImage image = ImageIO.read(imagem);
//				ByteArrayOutputStream out = new ByteArrayOutputStream();
//				
//				if(isPng) {
//					ImageIO.write(image, "png", out);
//				}else {
//					ImageIO.write(image, "jpg", out);
//				}
//				
//				out.flush();
//				byteArray = out.toByteArray();
//				out.close();
//				
//				return byteArray;
//				
//			}catch(IOException e) {
//				System.out.println("conversão errada!");
//			}
//		}
//		return null;
//	}
	
//	public static byte[] getBytesDeArquivo(File arquivo) {
//		byte[] byteArray;
//		try {
//			BufferedImage image = ImageIO.read(arquivo);
//			ByteArrayOutputStream out = new ByteArrayOutputStream();
//			
//			out.flush();
//			byteArray = out.toByteArray();
//			out.close();
//			
//			return byteArray;
//			
//		}catch(IOException e) {
//			System.out.println("conversão errada!");
//		}
//		return null;
//	}
}
