
function fuck(){
    var rows = 5;
    var cols = 10;
    document.write("<table border = \"1\">");
    for (i = 0 ; i < rows ; i ++){
        document.write("<tr>");
       for (j = 0 ; j < cols ; j ++){
           document.write("<td>" + i*j + "</td>");
       }
       document.write("</tr>");
    }
    document.write("</table>");

}