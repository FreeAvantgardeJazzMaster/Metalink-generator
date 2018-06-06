package metalink.groovy.Model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.xml.bind.annotation.*


@XmlRootElement
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
class Hash {
    @XmlAttribute(name = "type")
    String type
    @XmlValue
    String value

    Hash(String type, String value) {
        this.type = type
        this.value = value
    }

    Hash() {
    }
}
