package com.whoisashif.universitymanagementsystem.repository;

import com.whoisashif.universitymanagementsystem.dto.ProfessorCompensationDto;
import com.whoisashif.universitymanagementsystem.entity.Professor;
import com.whoisashif.universitymanagementsystem.entity.ProfessorCompensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorCompensationRepository extends JpaRepository<ProfessorCompensation, Long> {

    Optional<ProfessorCompensation> findByProfessorId(Long professorId);

}
