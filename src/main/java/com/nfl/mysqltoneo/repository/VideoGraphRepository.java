package com.nfl.mysqltoneo.repository;

import com.nfl.dm.shield.domain.graph.node.content.video.Video;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Component;

@Component
@Lazy(value = true)
public interface VideoGraphRepository extends GraphRepository<Video> {
    Video findOneByUuid(String uuid);
}
