import java.nio.file.{FileSystems, Files}
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

val dir = "/homes/mhm1718/Bitbucket/mhm1718/Experiments/joern-cli/mydir/linux"

importCode(inputPath=dir, projectName="test")
var codes = cpg.method.isExternal(false).filter(_.start.dumpRaw.head.contains("{")).filter(_.start.dumpRaw.head.contain$
var count=0;

for(count<-0 to codes.size-1)
{
    codes(count) |> dir+"/all/linux_"+(count+1)+".c"
}

close
