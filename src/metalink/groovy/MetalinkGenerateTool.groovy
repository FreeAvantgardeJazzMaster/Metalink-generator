package metalink.groovy

import metalink.groovy.Model.FileMetalink
import metalink.groovy.Model.Metalink
import metalink.groovy.Utils.XmlGenerator
import org.apache.tools.ant.BuildException
import org.apache.tools.ant.Task
import org.apache.tools.ant.types.FileSet

class MetalinkGenerateTool extends Task{

    String file
    String url
    Vector filesets = new Vector()
    Metalink metalink = new Metalink()

    @Override
    void execute() throws BuildException {
        if (file == null){
            file = project.properties["file.directory"]
        }
        if (url == null){
            url = project.properties["url.directory"]
        }

        filesets.each {FileSet fileSet -> generateMetalink(fileSet.getDir()) }

        /*
        println(metalink.toXML())
        def outFile = new File(file + ".xml")
        outFile.text = metalink.toXML()

        */

        XmlGenerator xmlGenerator = new XmlGenerator(metalink, new File(file))
        xmlGenerator.generate()
    }

    void generateMetalink(File dir){
        for(File file : dir.listFiles()){
            if(file.isFile()){
                metalink.add(new FileMetalink(file))
            }
        }
    }

    void setUrl(String url){
        this.url = url
    }

    void setFile(String file){
        this.file = file
    }

    void setFilesets(Vector filesets){
        this.filesets = filesets
    }

    void addFileset(FileSet fileset) {
        filesets.add(fileset)
    }
}
