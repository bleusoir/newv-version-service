package dev.newv.version.repository;

import dev.newv.version.domain.VersionInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface VersionInfoRepository extends MongoRepository<VersionInfo, String> {

    List<VersionInfo> findAllBy();

    List<VersionInfo> findAllBy(Sort sort);

    Slice<VersionInfo> findAllByName(String name, Pageable pageable);

    List<VersionInfo> findAllBy(Example<VersionInfo> example, Sort sort);

    Slice<VersionInfo> findAllBy(Example<VersionInfo> example, Pageable pageable);

    long countAllByName(String name);
}