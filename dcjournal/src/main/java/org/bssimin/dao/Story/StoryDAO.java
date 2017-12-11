package org.bssimin.dao.Story;

import org.bssimin.domain.storyContent.StoryContent;
import org.bssimin.domain.storyContent.StoryQuestion;

public interface StoryDAO {
    public StoryQuestion readQuestion(int step);
    public StoryContent readContent(int step,String answer);
}
