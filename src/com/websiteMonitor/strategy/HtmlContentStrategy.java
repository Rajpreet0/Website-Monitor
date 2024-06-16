package com.websiteMonitor.strategy;

public class HtmlContentStrategy implements ComparisonStrategy{
    @Override
    public boolean isContentChanged(String oldContent, String newContent) {
        return !oldContent.equals(newContent);
    }
}
