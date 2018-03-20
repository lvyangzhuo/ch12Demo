package com.demo.dao;

import com.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author Lyz
 * @time 2018-3-20 11:23
 */
public interface PersonRepository extends JpaRepository<Person,Long>{
}
