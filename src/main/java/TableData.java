import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TableData {
    private final List<String> tHeadData = new ArrayList<>();
    private final List<String[]> tBodyData = new ArrayList<>();
    private final List<String> tFootData = new ArrayList<>();

    private final List<String> tHeadClasses = new ArrayList<>();
    private final List<String> tBodyClasses = new ArrayList<>();
    private final List<String> tFootClasses = new ArrayList<>();

    private final List<String> tHeadId = new ArrayList<>();
    private final List<String> tBodyId = new ArrayList<>();
    private final List<String> tFootId = new ArrayList<>();

    private final List<String> tableClasses = new ArrayList<>();
    public List<String> tableIDs = new ArrayList<>();
}
