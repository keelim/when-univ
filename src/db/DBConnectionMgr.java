package db;

import java.sql.*;
import java.util.Properties;
import java.util.Vector;

public class DBConnectionMgr {
    private static DBConnectionMgr instance = null;
    public final String _driver = "com.mysql.jdbc.Driver";
    public final String _url = "jdbc:mysql://localhost:3307/library"; //
    private final Vector<ConnectionObject> connections = new Vector<>(10);
    private String _user = "root"; //
    private String _password = "1234"; //
    private final boolean _traceOn = false;
    private boolean initialized = false;
    private final int _openConnections = 50;

    public static DBConnectionMgr getInstance() {
        if (instance == null) {
            synchronized (DBConnectionMgr.class) {
                if (instance == null) {
                    instance = new DBConnectionMgr();
                }
            }
        }

        return instance;
    }

    public synchronized Connection getConnection()
            throws Exception {
        if (!initialized) {
            Class<?> c = Class.forName(_driver);
            DriverManager.registerDriver((Driver) c.newInstance());
            initialized = true;
        }

        Connection c = null;
        ConnectionObject co;
        boolean badConnection;

        for (int i = 0; i < connections.size(); i++) {
            co = connections.elementAt(i);

            if (!co.inUse) {
                try {
                    badConnection = co.connection.isClosed();
                    if (!badConnection)
                        badConnection = (co.connection.getWarnings() != null);
                } catch (Exception e) {
                    badConnection = true;
                    e.printStackTrace();
                }

                if (badConnection) {
                    connections.removeElementAt(i);
                    trace("ConnectionPoolManager: Remove disconnected DB connection #" + i);
                    continue;
                }

                c = co.connection;
                co.inUse = true;

                trace("ConnectionPoolManager: Using existing DB connection #" + (i + 1));
                break;
            }
        }

        if (c == null) {
            c = createConnection();
            co = new ConnectionObject(c, true);
            connections.addElement(co);
            trace("ConnectionPoolManager: Creating new DB connection #" + connections.size());
        }
        return c;
    }

    public synchronized void freeConnection(Connection c) {
        if (c == null)
            return;

        ConnectionObject co;

        for (int i = 0; i < connections.size(); i++) {
            co = connections.elementAt(i);
            if (c == co.connection) {
                co.inUse = false;
                break;
            }
        }

        for (int i = 0; i < connections.size(); i++) {
            co = connections.elementAt(i);
            if ((i + 1) > _openConnections && !co.inUse)
                removeConnection(co.connection);
        }
    }

    public void freeConnection(Connection c, PreparedStatement p, ResultSet r) {
        try {
            if (r != null) r.close();
            if (p != null) p.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, Statement s, ResultSet r) {
        try {
            if (r != null) r.close();
            if (s != null) s.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, PreparedStatement p) {
        try {
            if (p != null) p.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, Statement s) {
        try {
            if (s != null) s.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public synchronized void removeConnection(Connection c) {
        if (c == null)
            return;

        ConnectionObject co;
        for (int i = 0; i < connections.size(); i++) {
            co = connections.elementAt(i);
            if (c == co.connection) {
                try {
                    c.close();
                    connections.removeElementAt(i);
                    trace("Removed " + c.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            }
        }
    }


    private Connection createConnection()
            throws SQLException {
        Connection con;

        try {
            if (_user == null)
                _user = "";
            if (_password == null)
                _password = "";

            Properties props = new Properties();
            props.put("user", _user);
            props.put("password", _password);

            con = DriverManager.getConnection(_url, props);
        } catch (Throwable t) {
            throw new SQLException(t.getMessage());
        }

        return con;
    }


    public void finalize() {
        trace("ConnectionPoolManager.finalize()");

        @SuppressWarnings("unused")
        Connection c = null;
        ConnectionObject co;

        for (int i = 0; i < connections.size(); i++) {
            co = connections.elementAt(i);
            try {
                co.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        connections.removeAllElements();
    }


    private void trace(String s) {
        if (_traceOn)
            System.err.println(s);
    }

    class ConnectionObject {
        Connection connection;
        boolean inUse;

        ConnectionObject(Connection c, boolean useFlag) {
            connection = c;
            inUse = useFlag;
        }
    }
}



