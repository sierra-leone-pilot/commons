package io.mosip.kernel.emailnotification.util;

import org.springframework.stereotype.Component;

@Component
public class HTMLFormatter {

    public String formatText(String content) {
        String formattedMessage = "<p>";

        String var1 = content.trim();
        String[] var2 = var1.split("\n");
        System.out.println(var2);
        int noofEmptyLines = 0;

        for(String v : var2) {
            if (!v.isEmpty()) {
                String var3 = v.replace("\t", "#[TAB]#").trim().replace("#[TAB]#", "&emsp;");

                if (noofEmptyLines > 1) {
                    noofEmptyLines = 0;
                    var3 = "</p><br><p>" + var3;
                }
                formattedMessage += "<br>"+ var3;
            }

            if(v.isEmpty())
                noofEmptyLines++;
        }
        formattedMessage+="</p>";

        return  formattedMessage;
    }
}
