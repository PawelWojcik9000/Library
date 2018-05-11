package library.xml.crud;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import library.entities.Author;

public class AuthorsXmlDAO {

	public void createNewAuthorsXml() {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element rootElement = doc.createElement("authors");
			doc.appendChild(rootElement);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					"C:\\Users\\pawelw\\Desktop\\workspace\\libraryWeb\\src\\library\\xml\\data\\authors.xml"));
			transformer.transform(source, result);

		} catch (ParserConfigurationException | TransformerException e) {

			e.printStackTrace();
		}

	}

	public List<Author> getAuthorsXml() {

		List<Author> authors = new ArrayList<>();

		try {
			File inputFile = new File(
					"C:\\Users\\pawelw\\Desktop\\workspace\\libraryWeb\\src\\library\\xml\\data\\authors.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("author");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				// System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					authors.add(new Author(Integer.parseInt(eElement.getAttribute("id")),
							eElement.getElementsByTagName("firstName").item(0).getTextContent(),
							eElement.getElementsByTagName("lastName").item(0).getTextContent()));
				}
			}
		} catch (FileNotFoundException e) {
			createNewAuthorsXml();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return authors;

	}

	public void addAuthorXml(String name, String surname) {

		Integer id = null;

		try {
			File inputFile = new File(
					"C:\\Users\\pawelw\\Desktop\\workspace\\libraryWeb\\src\\library\\xml\\data\\authors.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("author");
			if (nList.getLength() == 0) {
				id = 1;
			} else {
				System.out.println(nList.item(nList.getLength() - 1).getAttributes().item(0).getTextContent());
				id = Integer.parseInt(nList.item(nList.getLength() - 1).getAttributes().item(0).getTextContent());
				id++;
			}
			Element authors = (Element) doc.getElementsByTagName("authors").item(0);

			// setting id
			Element authorElement = doc.createElement("author");
			Attr attr = doc.createAttribute("id");
			attr.setValue(id.toString());
			authorElement.setAttributeNode(attr);

			// setting name
			Element authorName = doc.createElement("firstName");
			authorName.appendChild(doc.createTextNode(name));
			authorElement.appendChild(authorName);

			// setting surname
			Element authorSurname = doc.createElement("lastName");
			authorSurname.appendChild(doc.createTextNode(surname));
			authorElement.appendChild(authorSurname);

			authors.appendChild(authorElement);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					"C:\\Users\\pawelw\\Desktop\\workspace\\libraryWeb\\src\\library\\xml\\data\\authors.xml"));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);

		} catch (FileNotFoundException e) {
			createNewAuthorsXml();
		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteAuthorXml(String id) {
		try {
			File inputFile = new File(
					"C:\\Users\\pawelw\\Desktop\\workspace\\libraryWeb\\src\\library\\xml\\data\\authors.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("author");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				// System.out.println("\nCurrent Element: " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println(eElement.getAttribute("id"));
					if (eElement.getAttribute("id").equals(id)) {
						Node rootElement = eElement.getParentNode();
						rootElement.removeChild(eElement);
					}
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					"C:\\Users\\pawelw\\Desktop\\workspace\\libraryWeb\\src\\library\\xml\\data\\authors.xml"));
			transformer.transform(source, result);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editAuthorXml(String id, String name, String surname) {

		try {
			File inputFile = new File(
					"C:\\Users\\pawelw\\Desktop\\workspace\\libraryWeb\\src\\library\\xml\\data\\authors.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("author");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				// System.out.println("\nCurrent Element: " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println(eElement.getAttribute("id"));
					if (eElement.getAttribute("id").equals(id)) {
						eElement.getElementsByTagName("firstName").item(0).setTextContent(name);
						eElement.getElementsByTagName("lastName").item(0).setTextContent(surname);
					}
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					"C:\\Users\\pawelw\\Desktop\\workspace\\libraryWeb\\src\\library\\xml\\data\\authors.xml"));
			transformer.transform(source, result);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Author getAuthorByIdXml(String id) {
		Author author = new Author();
		
		List<Author> authors = getAuthorsXml();
		for (Author auth : authors) {
			if(auth.getId() == Integer.parseInt(id) ) {
				author = auth;
			}
		}
		return author;
	}

}
