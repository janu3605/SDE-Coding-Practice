package DeltaX_Codes;

import java.util.*;

public class urlParameterParsing {
    public static void main(String args[]) {
        String inpt = "[https://mywebsite.com/api/users?name=jaswanth&role=student&active=true]";

        Dictionary<String, String> params = new Hashtable<String, String>();

        inpt = inpt.substring(inpt.indexOf("?") + 1, inpt.indexOf("]"));
        String[] paramList = inpt.split("&");
        for (String param : paramList) {
            String[] keyValue = param.split("=");
            params.put(keyValue[0], keyValue[1]);
        }
        System.out.println(params);
    }
}
