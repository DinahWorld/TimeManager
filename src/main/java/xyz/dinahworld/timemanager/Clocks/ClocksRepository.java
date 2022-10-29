package xyz.dinahworld.timemanager.Clocks;

import org.springframework.data.cassandra.repository.CassandraRepository;
import xyz.dinahworld.timemanager.Users.Users;

import java.util.UUID;

public interface ClocksRepository extends CassandraRepository<Clocks, UUID> {
}
