package org.imu.springtutorials.repository;

import java.io.Serializable;

import org.imu.springtutorials.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Serializable>
{
}
