package com.nokia.connect.order;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Xml {

	public static void sendXml(String xmlFile2Send, boolean verifyProxy) throws IOException {

		String SOAPUrl = "http://cfiwn02-app2.nz.alcatel-lucent.com:44006/ilws/InstantLinkSOA?wsdl";
		HttpURLConnection httpConn = null;

		if (verifyProxy == true) {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("135.245.192.7", 8000));

			URL url = new URL(SOAPUrl);
			URLConnection connection = url.openConnection(proxy);
			httpConn = (HttpURLConnection) connection;
		} else if(verifyProxy == false){
			URL url = new URL(SOAPUrl);
			URLConnection connection = url.openConnection();
			httpConn = (HttpURLConnection) connection;

		}

		FileInputStream fin = new FileInputStream(xmlFile2Send);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();

		// Copy the SOAP file to the open connection.
		copy(fin, bout);
		fin.close();

		byte[] b = bout.toByteArray();

		// Set the appropriate HTTP parameters.
		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);

		// Everything's set up; send the XML that was read in to b.
		OutputStream out = httpConn.getOutputStream();
		out.write(b);
		out.close();

		// Read the response

		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);

		String inputLine;

		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);

		in.close();
	}

	public static void copy(InputStream in, OutputStream out) throws IOException {

		// do not allow other threads to read from the
		// input or write to the output while copying is
		// taking place

		synchronized (in) {
			synchronized (out) {

				byte[] buffer = new byte[256];
				while (true) {
					int bytesRead = in.read(buffer);
					if (bytesRead == -1)
						break;
					out.write(buffer, 0, bytesRead);
				}
			}
		}
	}
}
