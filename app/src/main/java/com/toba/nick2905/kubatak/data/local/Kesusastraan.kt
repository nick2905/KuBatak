package com.toba.nick2905.kubatak.data.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kesusastraan (
    var judul : String,
    var desc : String
): Parcelable {
}