package ru.evgenysidorov.notepad;

import java.util.Date;
import java.util.UUID;


public class Note {

    private String nTitle;
    private UUID nId;
    private Date nDate;
    private String nDescription;


    public String getnDescription() {
        return nDescription;
    }

    public void setnDescription(String nDescription) {
        this.nDescription = nDescription;
    }

    public Note(String nTitle, String nDescription){
        nId = UUID.randomUUID();
        this.nTitle=nTitle;
        this.nDescription=nDescription;
        nDate= new Date();
    }



    public Date getnDate() {
        return nDate;
    }

    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }

    public UUID getnId() {
        return nId;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }
}