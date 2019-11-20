package com.elhaouari.servicecompany.dao;

import com.elhaouari.servicecompany.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
