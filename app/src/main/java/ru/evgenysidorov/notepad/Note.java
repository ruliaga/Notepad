package ru.evgenysidorov.notepad;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.UUID;


public class Note implements Parcelable {

    private String nTitle;
    private UUID nId;
    private Date nDate;
    private String nDescription;


    protected Note(Parcel in) {
        nTitle = in.readString();
        nDescription = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nTitle);
        dest.writeString(nDescription);
    }
}