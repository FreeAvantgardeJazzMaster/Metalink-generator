package metalink.groovy


class Metalink {
    Date date
    def files = []

    Metalink() {
        date = new Date()
    }

    def add(FileMetalink metalinkFile) {
        files.add(metalinkFile)
    }

    def print() {
        files.each {f -> println(f)}
    }

    def toXML() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                     "<metalink xmlns=\"urn:ietf:params:xml:ns:metalink\">\n" +
                        "\t<published>" + date +"</published>\n"

        files.each{file -> xml += file.toXML()}

        xml += "</metalink>"

        return xml
    }
}
