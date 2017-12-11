package org.bssimin.service.storyService;

import org.bssimin.domain.storyContent.StoryContent;
import org.bssimin.domain.storyContent.StoryQuestion;

public interface StoryService {
    public StoryQuestion getTitle(int step) throws Exception;
    public StoryContent getContent(int step,String answer) throws Exception;
}
