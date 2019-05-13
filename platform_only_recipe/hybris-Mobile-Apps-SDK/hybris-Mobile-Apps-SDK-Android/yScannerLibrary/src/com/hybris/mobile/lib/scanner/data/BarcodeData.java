package com.hybris.mobile.lib.scanner.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Barcode data
 */
public class BarcodeData implements Parcelable {

    private String data;
    private String format;

    public BarcodeData() {
    }

    public BarcodeData(Parcel source) {
        data = source.readString();
        format = source.readString();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(data);
        dest.writeString(format);
    }

    public static final Parcelable.Creator<BarcodeData> CREATOR = new Parcelable.Creator<BarcodeData>() {
        @Override
        public BarcodeData createFromParcel(Parcel source) {
            return new BarcodeData(source);
        }

        @Override
        public BarcodeData[] newArray(int size) {
            return new BarcodeData[size];
        }
    };

}
