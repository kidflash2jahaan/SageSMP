package com.systemerr.sagesmp.chatfilter;

import java.util.List;
import java.util.regex.Pattern;

import com.systemerr.sagesmp.chatfilter.donotread.BlockedWords;

public class StringFilter {
    public static String filter(String unfiltered) {
        String filtered = unfiltered;

        List<String> blockedWords = BlockedWords.blockedWords;
        blockedWords.sort(new StringLengthComparator());

        for (int blockedWordsIndex = 0; blockedWordsIndex < blockedWords.size(); blockedWordsIndex++) {
            filtered = filtered.replaceAll("(?i)" + Pattern.quote(blockedWords.get(blockedWordsIndex)), "*".repeat(blockedWords.get(blockedWordsIndex).length()));
        }

        return filtered;
    }
}
