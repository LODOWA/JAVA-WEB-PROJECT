package org;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import org.apache.commons.codec.binary.Base64;
import com.ibm.wsdl.util.IOUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import org.KlasaProxy;
//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class Bean {
	BASE64Decoder decoder = new BASE64Decoder();
	KlasaProxy proxy = new KlasaProxy();
	private String foto = "";
	private ArrayList tradycyjnyPlik;
	private String tradycja = "";
	private String tableString0 = "";
	private Part file = null;
	private String taki;
	private String original;
	private String min;
	private String max;
	private String fileContent = "";
	public String codec = "";
	private static int licznik = 0;
	int iloscfot;

// funkcja wysylajaca obraz na serwer
	public void upload() throws IOException {
		if (file.getSize() > 0) {
			InputStream inputStream = file.getInputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = 0;
			BASE64Encoder encoder = new BASE64Encoder(); 
			ByteArrayOutputStream buffer2 = new ByteArrayOutputStream();
			while (true) {
				bytesRead = inputStream.read(buffer);
				if (bytesRead > 0) {
					buffer2.write(buffer, 0, bytesRead);
				} else {
					break;
				}
			}
			buffer2.flush();
			codec = encoder.encode(buffer2.toByteArray());
			inputStream.close();
			taki = codec;
			proxy.image(codec); // wys³anie stringu na serwer
			file.delete();
		}
	}

	
	
	//koduje obraz do postaci sringu 
	public static String encodeToString(BufferedImage image, String type) {
		String imageString = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); //powolanie obiektu bufora

		try {
			ImageIO.write(image, type, bos);   //wyslanie obrazu do bufora
			byte[] imageBytes = bos.toByteArray();  //pobranie obrazku ze strunienia
			BASE64Encoder encoder = new BASE64Encoder();
			imageString = encoder.encode(imageBytes); //dekodowanie obrazka do stringu 
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageString;
	}

	public Part getfile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	
	private static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE
																													// fix.
			}
		}
		return null;
	}

	public void setTaki(String taki) {
		this.taki = taki;
	}

	public String getTaki() {

		if (codec.length() != 0) {
			return "data:image/png;base64," + codec;
		}
		return null;

	}

	// pobiera obraz orginalny
	public String getOriginal() {
		try {
			//System.out.println("DobrzeDobrzeDObrze");
			//System.out.println(proxy.getAllFilles(0));
			return "data:image/png;base64," + proxy.getAllFilles(0);

		} catch (RemoteException e) {
			System.out.println("???????????????");
			System.out.println(e);
			return "Bladblad bladdddddddddd";
		}
	}

	// pobiera obraz po dylatacji
	public String getMin() {
		try {
			return "data:image/png;base64," + proxy.getAllFilles(1);

		} catch (RemoteException e) {
			System.out.println(e);
			return "";
		}
	}

	// pobiera obraz po erozji
	public String getMax() {
		try {
			return "data:image/png;base64," + proxy.getAllFilles(2);

		} catch (RemoteException e) {

			System.out.println(e);
			return "";
		}
	}

	public void settableString(String tableString) {
		this.tableString0 = tableString;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public void setMax(String max) {
		this.max = max;
	}
}
