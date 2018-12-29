package my.newspring.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import my.newspring.project.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
