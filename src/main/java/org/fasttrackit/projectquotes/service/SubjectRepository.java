package org.fasttrackit.projectquotes.service;

import org.fasttrackit.projectquotes.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository <Subject, Long> {

    @Query("select s from Subject s where s.name=:subject")
    Subject findByName(@Param("subject") String name);

    @Query("select s from Subject s where(:name=null or lower(s.name) like lower (concat('%',:name,'%')))")
    List<Subject> filterSubjects(@Param("name") String name);

}
