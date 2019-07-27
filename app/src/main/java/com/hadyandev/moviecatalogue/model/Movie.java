package com.hadyandev.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String name;
    private int banner;
    private float rating;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie(String name, int banner, float rating, String description) {
        this.name = name;
        this.banner = banner;
        this.rating = rating;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getBanner() {
        return banner;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.banner);
        dest.writeFloat(this.rating);
        dest.writeString(this.description);
    }

    protected Movie(Parcel in) {
        this.name = in.readString();
        this.banner = in.readInt();
        this.rating = in.readFloat();
        this.description = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
