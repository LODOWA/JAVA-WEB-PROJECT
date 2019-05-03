package org;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Filtr {
	public BufferedImage image;
	private int[] dataBuffInt;

	
	
	// Funkcja pobiera rodzaj konwersji jako string i wywo³uje funkcje  filt 
	public Filtr(String x) {
		super();
		//System.out.println(255 << 24 | 255 << 16 | 255 << 8 | 255);

		File imageFile = new File("C:/JEE/workspace/Server/Upload/java2.png");
		try {
			image = ImageIO.read(imageFile); //za³adownie obrazka
			// image = getGrayScale(image);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

		try {
			filt(image, x);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	
	//funkcja filtruje obraz
	public void filt(BufferedImage image, String mode) throws IOException {
		BufferedImage img = image;
		dataBuffInt = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth()); //zapis obrazu jako integeery 
		int x = image.getWidth(); // pobranie szerokosci obrazka
		int y = image.getHeight(); // pobranie wysokosci obrazka
		//System.out.println(image.toString());
		if (mode.equals("max")) {
			for (int i = 1; i < y - 1; i++) {
				for (int j = 1; j < x - 1; j++) {
					img.setRGB(j, i, findmax(i * x + j, image));
				}
			}
		}
			if (mode.equals("min")) {
				for (int i = 1; i < y - 1; i++) {
					for (int j = 1; j < x - 1; j++) {
						img.setRGB(j, i, findmin(i * x + j, image));
					}
				}
			
		}
		//BufferedImage img2 = img;
		//File f = new File("C:/JEE/workspace/Server/Upload/java4.png");
		//ImageIO.write(img2, "PNG", f);
	}

	
	//funkcja znajduje wartosc minimalna w podanym buforze 
	public int findmax(int n, BufferedImage image) { 
		int x = image.getWidth();  
		int[] val = {n-x-1, n-x, n-x+1, n-1, n+1, n+x-1, n+x, n+x+1};
		int col = dataBuffInt[val[0]];
		for (int i = 1; i<val.length; i++) {
		if (col > dataBuffInt[val[i]]) col = dataBuffInt[val[i]];
		}
		return col; 
	}

	
	//funkcja znajduje wartosc minimalna w podanym buforze 
	public int findmin(int n, BufferedImage image) {
		int x = image.getWidth();
		int[] val = { n - x - 1, n - x, n - x + 1, n - 1, n + 1, n + x - 1, n + x, n + x + 1 };
		int col = dataBuffInt[val[0]];
		for (int i = 1; i < val.length; i++) {
			if (col < dataBuffInt[val[i]]) col = dataBuffInt[val[i]];
		}
		return col;
	}
}
