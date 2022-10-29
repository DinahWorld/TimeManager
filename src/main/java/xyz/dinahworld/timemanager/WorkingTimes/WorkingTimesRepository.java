package xyz.dinahworld.timemanager.WorkingTimes;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public interface WorkingTimesRepository extends CassandraRepository<WorkingTimes,UUID> {

}
