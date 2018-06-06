package metalink.groovy.Utils

import metalink.groovy.Model.Metalink

import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Marshaller

class XmlGenerator {
    File destFile
    Metalink metalink

    XmlGenerator(Metalink metalink, File destDir) {
        this.destFile = destDir
        this.metalink = metalink
    }

    void generate() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(metalink.getClass())
        Marshaller m = context.createMarshaller()
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        m.marshal(metalink, destFile)
    }
}
