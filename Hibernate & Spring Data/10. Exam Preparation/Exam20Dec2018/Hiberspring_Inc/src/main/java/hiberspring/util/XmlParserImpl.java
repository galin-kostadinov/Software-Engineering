package hiberspring.util;

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
    public <O> O parseXml(Class<O> objectClass, String filePath) throws JAXBException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (O) unmarshaller.unmarshal(new FileReader(filePath));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
