package com.toba.nick2905.kubatak.data.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mataangin (
    var namaBatakMataangin: String,
    var namaAksaraMataangin: String,
    var namaBahasaMataangin: String
):Parcelable