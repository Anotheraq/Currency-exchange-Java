package Lab1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import java.io.IOException;
import java.net.URL;

public class XMLParser{

    private static final ExchangeRateTable exchangeRateTable = ExchangeRateTable.getInstance();

    public static void XMLParse(String url) throws IOException, ParserConfigurationException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(url).openStream());

        doc.getDocumentElement().normalize();

        String tableNumber = doc.getElementsByTagName("numer_tabeli").item(0).getTextContent();
        exchangeRateTable.setTableNumber(tableNumber);
        String dateOfPublication = doc.getElementsByTagName("data_publikacji").item(0).getTextContent();
        exchangeRateTable.setDateOfPublication(dateOfPublication);


        NodeList list = doc.getElementsByTagName("pozycja");
        for(int i = 0; i < list.getLength(); i++){
            Node node = list.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;

                String nazwaWaluty = element.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                String przelicznik = element.getElementsByTagName("przelicznik").item(0).getTextContent();
                String kodWaluty = element.getElementsByTagName("kod_waluty").item(0).getTextContent();
                String kursSredni = element.getElementsByTagName("kurs_sredni").item(0).getTextContent();

                Currency currency = new Currency(nazwaWaluty, Float.parseFloat(przelicznik.replace(",", "."))
                        , kodWaluty, Float.parseFloat(kursSredni.replace(",", ".")));
                exchangeRateTable.add(currency);
            }
        }
    }
}
