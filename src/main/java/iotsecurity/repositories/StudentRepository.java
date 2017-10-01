package iotsecurity.repositories;

import iotsecurity.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Burak on 9/24/17.
 */
public interface StudentRepository extends MongoRepository<Student,Integer> {
    Student findOneByPantherId(int pantherID);
}
