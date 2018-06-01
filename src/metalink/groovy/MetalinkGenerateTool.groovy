package metalink.groovy

import org.apache.tools.ant.BuildException
import org.apache.tools.ant.Task

class MetalinkGenerateTool extends Task{

    @Override
    void execute() throws BuildException {
        String sourceDir = project.properties["source.directory"]

        def dir = new File(sourceDir)
        Metalink metalink = new Metalink()
        for(File file : dir.listFiles()){
            if(file.isFile()){
                metalink.add(new FileMetalink(file))
            }
        }
        //metalink.print()
        println(metalink.toXML())
    }

}
