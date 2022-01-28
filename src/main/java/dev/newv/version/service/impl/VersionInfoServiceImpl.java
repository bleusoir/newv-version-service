package dev.newv.version.service.impl;

import dev.newv.version.domain.Spec;
import dev.newv.version.domain.VersionInfo;
import dev.newv.version.repository.SpecRepository;
import dev.newv.version.repository.VersionInfoRepository;
import dev.newv.version.service.VersionInfoService;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VersionInfoServiceImpl implements VersionInfoService {

    private final SpecRepository specRepo;
    private final VersionInfoRepository versionInfoRepo;

    public VersionInfoServiceImpl(SpecRepository specRepo, VersionInfoRepository versionInfoRepo) {

        this.specRepo = specRepo;
        this.versionInfoRepo = versionInfoRepo;
    }


    @Override
    public Long countAllByName(String name) {

        return versionInfoRepo.countAllByName(name);
    }

    @Override
    public List<VersionInfo> findAllByName(String name, Pageable page) {

        return versionInfoRepo.findAllByName(name, page).getContent();
    }

    @Override
    public JSONObject getInfoByName(String name) {

        Spec spec = specRepo.findByName(name);

        if (spec != null) {
            return new JSONObject()
                    .appendField("name", name)
                    .appendField("type", spec.getType())
                    .appendField("siteUrl", spec.getSiteUrl())
                    ;
        }

        return null;
    }
}