package com.company.main.entities.log.concretes;

public class LogContent
{
    public final String forDatabase;
    public final String forFeedback;


    public LogContent(String forDatabase, String forFeedback)
    {
        this.forDatabase = forDatabase;
        this.forFeedback = forFeedback;
    }
}
