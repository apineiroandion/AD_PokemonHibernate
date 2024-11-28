package app.controller.toXml;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XmlWritter {
    static String ruta = "adestradores.xml";
    XMLOutputFactory factory = XMLOutputFactory.newInstance();
    FileWriter fileWriter = getFileWriter();
    XMLStreamWriter writer = getXMLStreamWriter(fileWriter, factory);

    public static FileWriter getFileWriter() {
        try {
            return new FileWriter(ruta);
        } catch (IOException e) {
            System.out.println("Error al crear el archivo "+ e.getMessage());
        }
        return null;
    }

    public static XMLStreamWriter getXMLStreamWriter (FileWriter fileWriter, XMLOutputFactory factory) {
        try {
            return factory.createXMLStreamWriter(fileWriter);
        } catch (Exception e) {
            System.out.println("Error al crear el XMLStreamWriter "+ e.getMessage());
        }
        return null;
    }

    public static void escribirXML(XMLStreamWriter writer) {
        //TODO: metodo que escribe los adestradores en xml
    }
}
