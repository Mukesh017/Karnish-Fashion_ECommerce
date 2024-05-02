package com.karnish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karnish.modal.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
