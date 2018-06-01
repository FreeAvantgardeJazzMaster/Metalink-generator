package metalink.groovy

class FileMetalink {

    String name
    String url
    String hash
    long size

    FileMetalink(File file) {
        this.name = file.getName()
        this.hash = MD5.generate(file)
        this.url = file.getAbsolutePath()
        this.size = file.length()
    }

    @Override
    String toString() {
        return "name=" + name + ", url=" + url + ", hash=" + hash + ", size=" + size
    }

    def toXML() {
        return "\t<file name=\"" + name + "\">\n" +
                "\t\t<size>" + size + "<size>\n" +
                "\t\t<hash type=\"md5\">" + hash + "</hash>\n" +
                "\t\t<url>" + url + "</url>\n" +
                "\t</file>\n"
    }
}
