package app.controller.toXml;

import app.model.Trainer;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XmlWritter {
    static String ruta = "adestradores.xml";
    static XMLOutputFactory factory = XMLOutputFactory.newInstance();
    static FileWriter fileWriter = getFileWriter();
    static XMLStreamWriter writer = getXMLStreamWriter(fileWriter, factory);

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

    public static void escribirXML(ArrayList<Trainer> trainers) {
        try {
            writer.writeStartDocument("1.0");
            writer.writeStartElement("adestradores");
            for (Trainer trainer : trainers) {
                writer.writeStartElement("adestrador");
                writer.writeStartElement("id");
                writer.writeCharacters(String.valueOf(trainer.getId()));
                writer.writeEndElement();
                writer.writeStartElement("nome");
                writer.writeCharacters(trainer.getNome());
                writer.writeEndElement();
                writer.writeStartElement("nacemento");
                writer.writeCharacters(String.valueOf(trainer.getNacemento()));
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush(); 
            writer.close();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

}
