package com.websiteMonitor.strategy;

public class ContentSizeStrategy  implements ComparisonStrategy{
    @Override
    public boolean isContentChanged(String oldContent, String newContent) {
        return oldContent.length() != newContent.length();
    }
}
