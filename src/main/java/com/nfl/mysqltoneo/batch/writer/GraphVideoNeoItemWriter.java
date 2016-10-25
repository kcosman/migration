package com.nfl.mysqltoneo.batch.writer;

import com.nfl.dm.shield.domain.graph.node.content.video.Video;
import com.nfl.mysqltoneo.repository.VideoGraphRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy(value = true)
public class GraphVideoNeoItemWriter implements ItemWriter<Video> {
    @Autowired
    private VideoGraphRepository videoGraphRepository;

    @Override
    public void write(List<? extends Video> items) throws Exception {

    }
}
