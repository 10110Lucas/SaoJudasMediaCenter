package br.usjt.MediaCenter.test.exemplos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

public class TestUploadimgBase64 {

	private static FileInputStream fileInputStreamReader;

	public static void main(String[] args) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		fileChooser.setCurrentDirectory(
				new File("C:" + File.separator + "Users" + File.separator + "lucas" + File.separator + "Desktop"));
		fileChooser.showOpenDialog(fileChooser);
		fileChooser.getSelectedFile();

		System.out.println("=================Encoder Image to Base 64!=================");

		String base64ImageString = encoder(fileChooser.getSelectedFile().getPath());
		System.out.println("Base64ImageString = " + base64ImageString);

		System.out.println("=================Decoder Base64ImageString to Image!=================");
		decoder(base64ImageString, fileChooser.getSelectedFile().getPath());

		System.out.println("=================Encoder Image to Base 64!=================");

		String base64ImageString1 = encodar(fileChooser.getSelectedFile().getPath());
		System.out.println("Base64ImageString = " + base64ImageString1);

		System.out.println("DONE!");

	}
	
	public static String salvar(MultipartFile arquivo) {
		String dir = "C:" + File.separator + "Users" + File.separator + "lucas" + File.separator + "Documents"
			    	 + File.separator + "Universidade_Sao_Judas_Tadeu" + File.separator+"Eclipse-workspace"
			    	 +File.separator + "MediaCenter" + File.separator + "uploads";
		
		Path diretorioPath = Paths.get(dir);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
			String conteudo = encodar(dir+arquivo.getOriginalFilename());
			System.out.println("\n Img encoder --> " + conteudo);
			return conteudo;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String encoder(String imagePath) {
		String base64Image = "";
		File file = new File(imagePath);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);

		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return base64Image;
	}

	public static void decoder(String base64Image, String pathFile) {
		try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
			imageOutFile.write(imageByteArray);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
	}

	public static String encodar(String imagePath) {
		File originalFile = new File(imagePath);
        String encodedBase64 = null;
        try {
            fileInputStreamReader = new FileInputStream(originalFile);
            byte[] bytes = new byte[(int)originalFile.length()];
            fileInputStreamReader.read(bytes);
//            encodedBase64 = new String(Base64.encodeBase64(bytes));
            encodedBase64 = new String(Base64.getEncoder().encodeToString(bytes));
            
            return encodedBase64;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}
}
