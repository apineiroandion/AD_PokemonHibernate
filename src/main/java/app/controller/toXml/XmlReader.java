package app.controller.toXml;

import app.model.Trainer;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.util.ArrayList;

public class XmlReader {
    static XMLInputFactory factory = XMLInputFactory.newInstance();
    static FileReader fileReader = getFileReader();
     XMLStreamReader reader = getXMLStreamReader(fileReader, factory);

    public static FileReader getFileReader() {
        try {
            return new FileReader(XmlWritter.ruta);
        } catch (Exception e) {
            System.out.println("Error al crear el archivo "+ e.getMessage());
        }
        return null;
    }

    public static XMLStreamReader getXMLStreamReader(FileReader fileReader, XMLInputFactory factory) {
        try {
            return factory.createXMLStreamReader(fileReader);
        } catch (Exception e) {
            System.out.println("Error al crear el XMLStreamReader "+ e.getMessage());
        }
        return null;
    }

    public ArrayList<Trainer> readXML() {
        ArrayList<Trainer> trainers = new ArrayList<>();
        Trainer trainer = null;
        try {
            while (reader.hasNext()) {
                int tipo = reader.next();
                switch (tipo) {
                    case XMLStreamReader.START_ELEMENT:
                        if (reader.getLocalName().equals("adestrador")) {
                            trainer = new Trainer();
                        } else if (trainer != null) {
                            switch (reader.getLocalName()) {
                                case "id":
                                    trainer.setId(Integer.parseInt(reader.getElementText()));
                                    break;
                                case "nome":
                                    trainer.setNome(reader.getElementText());
                                    break;
                                case "nacemento":
                                    trainer.setNacementoText(reader.getElementText());
                                    break;
                            }
                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        if (reader.getLocalName().equals("adestrador")) {
                            trainers.add(trainer);
                        }
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo "+ e.getMessage());
        }
        System.out.println("Lectura completada.");
        return trainers;
    }
}
