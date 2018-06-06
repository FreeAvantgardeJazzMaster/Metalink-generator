package metalink.groovy.Model

import groovy.transform.EqualsAndHashCode
import metalink.groovy.Utils.MD5

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "file")
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
class FileMetalink {
    @XmlAttribute(name = "name")
    String name
    String url
    Hash hash
    long size

    FileMetalink(File file) {
        this.name = file.getName()
        this.hash = new Hash("M5", MD5.generate(file))
        this.url = file.getAbsolutePath()
        this.size = file.length()
    }

    FileMetalink(){}

    //previous method to generate xml
    def toXML() {
        return "\t<file name=\"" + name + "\">\n" +
                "\t\t<size>" + size + "</size>\n" +
                "\t\t<hash type=\"md5\">" + hash.value + "</hash>\n" +
                "\t\t<url>" + url + "</url>\n" +
                "\t</file>\n"
    }
}
