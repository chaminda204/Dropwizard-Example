package com.chaminda.destination.core.mapper;


import com.chaminda.destination.core.Destination;
import com.chaminda.destination.core.DestinationBuilder;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DestinationMapper implements ResultSetMapper<Destination> {

    @Override
    public Destination map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new DestinationBuilder()
                .withId(resultSet.getInt("ID"))
                .withDescription(resultSet.getString("DESCRIPTION"))
                .withName(resultSet.getString("NAME")).build();
    }
}
