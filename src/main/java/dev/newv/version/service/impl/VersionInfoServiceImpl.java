package dev.newv.version.service.impl;

import dev.newv.version.domain.VersionInfo;
import dev.newv.version.repository.VersionInfoRepository;
import dev.newv.version.service.VersionInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VersionInfoServiceImpl implements VersionInfoService {

    private final VersionInfoRepository versionInfoRepo;

    public VersionInfoServiceImpl(VersionInfoRepository versionInfoRepo) {

        this.versionInfoRepo = versionInfoRepo;
    }


    @Override
    public Long countAllByName(String name) {
        return null;
    }

    @Override
    public List<VersionInfo> findAllByName(String name, Pageable page) {

        return versionInfoRepo.findAllByName(name, page).getContent();
    }
}