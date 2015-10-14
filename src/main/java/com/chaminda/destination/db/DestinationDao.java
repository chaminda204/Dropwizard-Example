package com.chaminda.destination.db;


import com.chaminda.destination.core.Destination;
import com.chaminda.destination.core.mapper.DestinationMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(DestinationMapper.class)
public interface DestinationDao {

    @SqlQuery("select * from DESTINATION")
    List<Destination> getAll();

    @SqlQuery("select * from DESTINATION where ID = :id")
    Destination findById(@Bind("id") int id);

    @SqlUpdate("delete from DESTINATION where ID = :id")
    int deleteById(@Bind("id") int id);

    @SqlUpdate("update into DESTINATION set NAME = :name, DESCRIPTION = :description where ID = :id")
    int update(@BindBean Destination destination);

    @SqlUpdate("insert into DESTINATION (ID, NAME ,DESCRIPTION ) values (:id, :name, :description)")
    int insert(@BindBean Destination destination);
}
