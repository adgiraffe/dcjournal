package org.bssimin.dao.Story;

import org.apache.ibatis.session.SqlSession;
import org.bssimin.domain.storyContent.StoryContent;
import org.bssimin.domain.storyContent.StoryQuestion;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.inject.Named;

@Repository
public class StoryDAOImpl implements StoryDAO{
    @Named("db1SqlSessionTemplate")
    @Inject
    SqlSession session;

    private static String storyNamespace="org.bssimin.mybatis.mapper.storyMapper.xml";

    @Override
    public StoryQuestion readQuestion(int step) {
        return null;
    }

    @Override
    public StoryContent readContent(int step, String answer) {
        return null;
    }
}
