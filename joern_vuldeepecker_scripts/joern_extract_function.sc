import java.nio.file.{FileSystems, Files}
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

def printMe( dirList:List[String]) : Unit = {

	var sizeAll = dirList.size
	var filecount = 1

	for(dir<-dirList)
	{
		println(filecount+"/"+sizeAll)
		importCode(inputPath=dir, projectName="test")

		var codes = cpg.method.isExternal(false).filter(_.start.dumpRaw.head.contains("{")).filter(_.start.dumpRaw.head.contains("}")).dumpRaw
		var lineStart = cpg.method.isExternal(false).filter(_.start.dumpRaw.head.contains("{")).filter(_.start.dumpRaw.head.contains("}")).lineNumber.l
		var lineEnd = cpg.method.isExternal(false).filter(_.start.dumpRaw.head.contains("{")).filter(_.start.dumpRaw.head.contains("}")).lineNumberEnd.l
		var filename = new ListBuffer[String]()
		cpg.method.isExternal(false).filter(_.start.dumpRaw.head.contains("{")).filter(_.start.dumpRaw.head.contains("}")).filename.foreach(filename +=_.split("/").last)

		var count=0;
		for(count<-0 to codes.size-1)
		{
		    codes(count) |> dir+"/myfile_"+(count+1)+".c"
		    var metadata = dir+"/myfile_"+(count+1)+".c,"+filename.toList(count)+","+lineStart(count)+","+lineEnd(count)
		    metadata |>> dir+"/metadata.csv"

		}

		close
		filecount += 1

	}

}

val dir = FileSystems.getDefault.getPath("/mnt/d/Projects/joern/joern-cli/mydir/CWE-119/source_files") 
var filenames = Files.walk(dir).iterator.filter(Files.isRegularFile(_)).l.filter(_.toString.split("\\\\.").last.contains(".c"))
var dirList = new ListBuffer[String]()
filenames.foreach(dirList +=_.getParent.toString)

printMe(dirList.toList.distinct)
println("End of file successfull")