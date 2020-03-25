package alararestaurant.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class XmlParserImpl implements XmlParser {

    public XmlParserImpl() {
    }

    @Override
    public <T> T objectFromFile(Class<T> tClass, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new FileReader(path));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> void objectToFile(T object, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, new FileWriter(path));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
