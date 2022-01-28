package dev.newv.version.controller;

import dev.newv.version.domain.VersionInfo;
import dev.newv.version.service.VersionInfoService;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("version")
public class VersionController {

    private final VersionInfoService versionInfoService;

    public VersionController(VersionInfoService versionInfoService) {

        this.versionInfoService = versionInfoService;
    }

    @GetMapping("{name}/count")
    public long countByName(@PathVariable String name) {

        return versionInfoService.countAllByName(name);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getInfoByName(@PathVariable String name) {

        return ResponseEntity.ok().body(versionInfoService.getInfoByName(name));
    }

    @GetMapping("/{name}")
    public List<VersionInfo> getListsByName(@PathVariable String name, Pageable pageable) {

        Pageable page =
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                        Sort.by("created").descending());

        return versionInfoService.findAllByName(name, page);
    }
}