package com.websiteMonitor.strategy;

public interface ComparisonStrategy {
    boolean isContentChanged(String oldContent, String newContent);
}
