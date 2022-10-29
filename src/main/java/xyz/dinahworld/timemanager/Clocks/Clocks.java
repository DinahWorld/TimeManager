package xyz.dinahworld.timemanager.Clocks;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(value = "clocks")
public class Clocks {

    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    private LocalDateTime time;

    @CassandraType(type = CassandraType.Name.BOOLEAN)
    private Boolean status;

    public Clocks(LocalDateTime time, Boolean status, UUID user_id) {
        this.time = time;
        this.status = status;
        this.user_id = user_id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }
}
