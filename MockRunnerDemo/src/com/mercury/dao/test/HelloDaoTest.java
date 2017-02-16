package com.mercury.dao.test;

import java.sql.SQLException;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mockrunner.jdbc.BasicJDBCTestCaseAdapter;
import com.mockrunner.jdbc.StatementResultSetHandler;
import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockResultSet;

public class HelloDaoTest extends BasicJDBCTestCaseAdapter {
	private void prepareEmptyResultSet() {
        MockConnection connection = getJDBCMockObjectFactory().getMockConnection();
        StatementResultSetHandler statementHandler = connection.getStatementResultSetHandler();
        MockResultSet result = statementHandler.createResultSet();
        statementHandler.prepareGlobalResultSet(result);
    }
    
    public void testSave() throws SQLException {
        prepareEmptyResultSet();
        HelloDao hd = new HelloDao();
        hd.connect();
        hd.save(new User("Cindy", 52));
        hd.disconnect();
        verifySQLStatementExecuted("insert into Sample");
        verifySQLStatementNotExecuted("select name");
        verifyCommitted();
        //verifyRolledBack();
        verifyAllResultSetsClosed();
        //verifyAllStatementsClosed();
        verifyConnectionClosed();
    }
}
