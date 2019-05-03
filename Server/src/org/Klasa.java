package org;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Klasa {
	private static int licznik = 0;
	private BufferedImage image;
	private int[] dataBuffInt;
	ArrayList<String> Pliki = new ArrayList();

	public String image(String base64String) {
		String imageString = null;

		try {
			BASE64Decoder decoder = new BASE64Decoder(); // powolanie obiektu dekodera
			String exampleString = new String(decoder.decodeBuffer(base64String)); // zaladowanie obrazka w postaci
																					// stringa
			image = decodeToImage(exampleString); // wrzucanie zdjecia do zmiennej globalnej
			byte[] imgBytes = decoder.decodeBuffer(base64String); // zaladowanie obrazka w postaci bajtow
			BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imgBytes)); // zaladowanie obrazka do zmiennej

			// zapis orginalnego obrazu
			File imgOutFile = new File("C:/JEE/workspace/Server/Upload/java2.png");
			ImageIO.write(bufImg, "png", imgOutFile);

			// zapis obrazu po dylatancji
			File maxFile = new File("C:/JEE/workspace/Server/Upload/maxFile.png");
			Filtr max = new Filtr("max");
			ImageIO.write(max.image, "png", maxFile);

			// zapis obrazu po erozji
			File minFile = new File("C:/JEE/workspace/Server/Upload/minFile.png");
			Filtr min = new Filtr("min");
			ImageIO.write(min.image, "png", minFile);
			return "SADas";
		}

		catch (Exception ex) {
			return "dasad";
		}
	}

	//zamienia String na obraz
	public static BufferedImage decodeToImage(String imageString) {

		BufferedImage image = null;
		byte[] imageByte;
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			imageByte = decoder.decodeBuffer(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

	
	//zwraca string z postacia bitowa nazwy pliku 
	public String getAllFilles(int n) throws IOException {
		String x = "";
		String path = "C:/JEE/workspace/Server/Upload";
		String path2 = "C:/JEE/workspace/Server/Upload/";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		ArrayList listOfPathFiles = new ArrayList();

		// for (int i = 0; i < listOfFiles.length; i++) {
		if (listOfFiles[n].isFile()) {

			InputStream inputStream2 = new FileInputStream(path2 + listOfFiles[n].getName());
			byte[] buffer = new byte[4096];
			int bytesRead = 0;
			BASE64Encoder encoder = new BASE64Encoder();
			ByteArrayOutputStream buffer2 = new ByteArrayOutputStream();
			while (true) {
				bytesRead = inputStream2.read(buffer); 
				if (bytesRead > 0) {
					buffer2.write(buffer, 0, bytesRead);
				} else {
					break;
				}
			}
			buffer2.flush(); 
			String codec;
			codec = encoder.encode(buffer2.toByteArray());
			if (n >= 0) {
				// listOfPathFiles.add("data:image/png;base64,"+codec);
				x = codec;
			}
		}
		if (listOfFiles[n].isDirectory()) {
			System.out.println("Directory " + listOfFiles[n].getName());
		}
		// }
		return x;
		// return listOfPathFiles;
	}

}
