package Database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.sql.ResultSet;

public class CallableProcedure {

    private String template = "CALL %s(%s)";
    private String procedureName;
    private Queue<String> parameters = new LinkedList<>();

    public void execute() throws Exception {
        int parameterCount = parameters.size();
        String parameterPlaceholders = String.join(",", Collections.nCopies(parameterCount, "?"));
        String callString = String.format(template, procedureName, parameterPlaceholders);

        Connection conn = DbConnection.getInstance().getConnection();

        CallableStatement cstmt = conn.prepareCall(callString);

        int i = 1;
        for (String param : parameters) {
            cstmt.setString(i++, param);
        }

        cstmt.execute();
    }

    public ResultSet executeWithResultSet() throws Exception {
        int parameterCount = parameters.size();
        
        Connection conn = DbConnection.getInstance().getConnection();
        String callString;
        CallableStatement cstmt;
        
        if (parameterCount > 0) {
            String parameterPlaceholders = String.join(",", Collections.nCopies(parameterCount, "?"));
            callString = String.format(template, procedureName, parameterPlaceholders);

            cstmt = conn.prepareCall(callString);
            
            int i = 1;
            for (String param : parameters) {
                cstmt.setString(i++, param);
            }
            
        } else {
           callString = String.format(template, procedureName, "");

           cstmt = conn.prepareCall(callString);
        }

        cstmt.execute();
        
        return cstmt.getResultSet();
    }

    public CallableProcedure(String procedureName) {
        this.procedureName = procedureName;
    }

    public CallableProcedure addParameter(String value) {
        parameters.add(value);

        return this;
    }

    public CallableProcedure addParameter(int value) {
        parameters.add(String.valueOf(value));

        return this;
    }

}
