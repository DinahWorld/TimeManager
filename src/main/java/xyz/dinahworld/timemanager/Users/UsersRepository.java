package xyz.dinahworld.timemanager.Users;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface UsersRepository extends CassandraRepository<Users,UUID> {
}
