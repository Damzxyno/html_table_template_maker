import java.util.Arrays;
import java.util.List;

public class TableMaker {
   private final TableData tableData = new TableData();
    private String TBodyData = "";
    private String THeadData = "";
    private String TFootData = "";

    public void addTableClasses (String ...Data){
        for (var data : Data)
            tableData.getTableClasses().add(data);
    }

    public void addTableIDs (String ...Data){
        for (var data : Data)
            tableData.getTableIDs().add(data);
    }

    public void addTableHeaderClasses (String ...Data){
        for (var data : Data)
            tableData.getTHeadClasses().add(data);
    }

    public void addTableBodyClasses (String ...Data){
        for (var data : Data)
            tableData.getTBodyClasses().add(data);
    }

    public void addTableFooterIDs (String ...Data){
        for (var data : Data)
            tableData.getTFootId().add(data);
    }

    public void addTableHeaderIDS (String ...Data){
        for (var data : Data)
            tableData.getTFootId().add(data);
    }

    public void addTableBodyIDS (String ...Data){
        for (var data : Data)
            tableData.getTBodyId().add(data);
    }

    public void addTableFooterClasses (String ...Data){
        for (var data : Data)
            tableData.getTFootClasses().add(data);
    }

    public void addDataToHead(String ...Data){
       for (var data : Data)
           tableData.getTHeadData().add(data);
   }

    public void addDataToBody(String ...Data){
       tableData.getTBodyData().add(Data);
    }

    public void addDataToFoot(String ...Data){
       for (var data : Data)
           tableData.getTFootData().add(data);
    }

    private void constructTBodyData(){
        StringBuilder TBodyData = new StringBuilder();
        TBodyData.append("\n\t<tBody")
                .append(constructClassOrID(tableData.getTBodyClasses(), "class"))
                .append(constructClassOrID(tableData.getTBodyId(), "id"))
                .append(">");
        for (var bodyContent: tableData.getTBodyData()){
                List<String> list = Arrays.asList(bodyContent);
                TBodyData.append(constructRow(list));
        }
        TBodyData.append("\n\t</tBody>");
        this.TBodyData = TBodyData.toString();
    }

    private void constructTHeadData(){
        this.THeadData = "\n\t<tHead " +
                constructClassOrID(tableData.getTHeadClasses(), "class") +
                constructClassOrID(tableData.getTHeadId(), "id") +
                ">" +
                constructRow(tableData.getTHeadData()) +
                "\n\t</tHead>";
    }

    private void constructTFootData(){
        this.TFootData = "\n\t<tFoot " +
                constructClassOrID(tableData.getTHeadClasses(), "class") +
                constructClassOrID(tableData.getTHeadId(), "id") +
                ">" +
                constructRow(tableData.getTFootData()) +
                "\n\t</tFoot>";
    }

    private String constructRow(List<String> data){
        StringBuilder content = new StringBuilder();
        content.append("\n\t\t<tr>");
        for (String column : data){
            content.append("\n\t\t\t<td>")
                    .append(column)
                    .append("</td>");
        }
        content.append("\n\t\t</tr>");
        return content.toString();
    }

    private String constructClassOrID(List<String> Data, String classOrID){
        StringBuilder classContent = new StringBuilder();
            classContent.append(classOrID).append(" = '");
            for (var data : Data) {
                classContent.append(data).append(" ");
            }
            classContent.append("' ");
            return classContent.toString();
    }




    public String getTableConstruct(){
        constructTHeadData();
        constructTBodyData();
        constructTFootData();

       return "<table " + constructClassOrID(tableData.getTableClasses(), "class")
               + constructClassOrID(tableData.getTableIDs(), "id")
               + ">"
               + THeadData + TBodyData + TFootData + "\n</table>";
    }

}
