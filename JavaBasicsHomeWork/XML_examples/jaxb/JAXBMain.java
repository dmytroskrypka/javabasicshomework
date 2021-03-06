package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;

public class JAXBMain {
    
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.add(new Book("Author1", "Title1", 14.55, new Date()));
        catalog.add(new Book("Author2", "Title2", 66, new Date()));

        try {
            File file = new File("output.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            // читабельное форматирование
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // пишем в файл
            marshaller.marshal(catalog, file);
            marshaller.marshal(catalog, System.out);

            // читаем из файла
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            catalog = (Catalog) unmarshaller.unmarshal(file);
            System.out.print("println( get Author[2] ) :\t");
            System.out.println(catalog.getBooks().get(2).getAuthor());
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }  
}