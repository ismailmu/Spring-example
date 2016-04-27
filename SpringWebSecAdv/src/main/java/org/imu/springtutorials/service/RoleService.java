package org.imu.springtutorials.service;

import org.imu.springtutorials.domain.Role;
import org.imu.springtutorials.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role create(Role role) {
		return roleRepository.save(role);
	}
}
