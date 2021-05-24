import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
	
	String regex = "^(.+)@(.+)$";
	
	public boolean getRes(String pattern, String line) {
		Pattern r = Pattern.compile(regex); //used to compile the given regular expression passed as the string
        Matcher m = r.matcher(line); //match the entire input sequence against the pattern
       
        boolean results = true;
          
        boolean found = false;    
        while (m.find()) {          
            found = true;    
        }    
        if(!found){    
            return results;    
        }  
        else {
      	  return results;    
        }
	}

}