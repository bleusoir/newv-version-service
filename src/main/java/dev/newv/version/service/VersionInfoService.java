package dev.newv.version.service;

import dev.newv.version.domain.VersionInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VersionInfoService {

    Long countAllByName(String name);

    List<VersionInfo> findAllByName(String name, Pageable page);
}