package com.programmingcamp.simplediary;


public class DiaryModel {
    private String DiaryDate;
    private String DiaryContent;

    public void setDiaryContent(String diaryContent) {
        DiaryContent = diaryContent;
    }

    public String getDiaryContent() {
        return DiaryContent;
    }

    public void setDiaryDate(String diaryDate) {
        DiaryDate = diaryDate;
    }

    public String getDiaryDate() {
        return DiaryDate;
    }
}
