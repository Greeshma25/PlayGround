import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;  
public class InputData
{  
     public static void main(String args[])
     {  Map<String,String> varMap=fillMap();
     Path path=Paths.get("D:\\\\testdata.txt");
     Stream<String> lines;
     try {
    lines=Files.lines(path,Charset.forName("UTF-8"));
    List<String> replacedLines=lines.map(line -> replaceTag(line,varMap)).collect(Collectors.toList());
    Files.write(path,replacedLines,Charset.forName("UTF-8"));
    lines.close();
    System.out.println("Replaced Successfully");
     }
     catch(IOException e)
     {
    e.printStackTrace();
     }
     }
     public static Map<String,String> fillMap()
     {
    Map<String,String> map=new HashMap<String,String>();
    map.put("consectetur adipiscing elit","########### ########## ####");
    return map;
     }
         
private static String replaceTag(String st,Map<String,String> map)
{
for(Map.Entry<String,String> entry: map.entrySet())
{
if(st.contains(entry.getKey()))
{
st=st.replace(entry.getKey(),entry.getValue());
}
}
return st;
}
}
