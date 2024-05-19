package org.server.fiftybees.service;

import org.server.fiftybees.domain.Authority;

import java.util.List;

public interface AuthorityService {
    Authority add(Authority authority);

    List<Authority> getAll();
}
