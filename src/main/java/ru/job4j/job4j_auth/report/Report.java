package ru.job4j.job4j_auth.report;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.job4j.job4j_auth.domain.Person;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Report {

    private int id;

    private String name;

    private Timestamp created;

    private Person person;

    public static Report of(int id, String name, Person person) {
        Report r = new Report();
        r.id = id;
        r.name = name;
        r.person = person;
        r.created = new Timestamp(System.currentTimeMillis());
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Report report = (Report) o;
        return id == report.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
