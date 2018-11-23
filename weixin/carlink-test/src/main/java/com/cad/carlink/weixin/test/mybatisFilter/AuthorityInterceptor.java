package com.cad.carlink.weixin.test.mybatisFilter;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.*;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
/**
 * 权限拦截器
 */
public class AuthorityInterceptor implements Interceptor {
    private static final String SELECT_ID="findList";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("AuthorityInterceptor -- intercept");
        if (invocation.getTarget() instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            MappedStatement mappedStatement=(MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
            String selectId=mappedStatement.getId();

            if(SELECT_ID.equals(selectId.substring(selectId.lastIndexOf(".")+1))){
                BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
                // 分页参数作为参数对象parameterObject的一个属性
                String sql = boundSql.getSql();
                // 重写sql
                String pageSql=concatPageSql(sql);
                System.out.println("重写的 select sql		:"+pageSql);
                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
            }
        }
        return invocation.proceed();
    }

    /**
     * 拦截类型StatementHandler
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }


    public String concatPageSql(String sql){
        StringBuffer sb=new StringBuffer();
        sb.append(sql);
        sb.append("  where areaType=1");
        return sb.toString();
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
