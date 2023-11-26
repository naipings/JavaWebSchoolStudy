package cn.edu.swu.repository;

import java.sql.ResultSet;

public abstract class ResultSetVisitor {
    public abstract void visit(ResultSet resultSet);
}
