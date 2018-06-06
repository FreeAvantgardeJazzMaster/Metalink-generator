package metalink.groovy.Model

import groovy.transform.EqualsAndHashCode
import metalink.groovy.Model.FileMetalink

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement (name = "metalink")
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
class Metalink {
    @XmlElement(name = "published")
    Date date
    @XmlElement(name = "file")
    @XmlElementWrapper(name = "files")
    List<FileMetalink> files = new ArrayList<>();

    Metalink() {
        date = new Date()
    }

    def add(FileMetalink metalinkFile) {
        files.add(metalinkFile)
    }

    def print() {
        files.each {f -> println(f)}
    }

    //previous method to generate xml
    def toXML() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                     "<metalink xmlns=\"urn:ietf:params:xml:ns:metalink\">\n" +
                        "\t<published>" + date +"</published>\n"

        files.each{file -> xml += file.toXML()}

        xml += "</metalink>"

        return xml
    }
}
