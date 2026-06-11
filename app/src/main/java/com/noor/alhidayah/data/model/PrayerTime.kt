package com.noor.alhidayah.data.model
data class PrayerTime(val name:String,val nameAr:String,val time:String,val timeInMillis:Long,val isNext:Boolean=false,val remainingSeconds:Long=0)
data class PrayerTimesResponse(val code:Int=200,val status:String="OK",val data:PrayerTimesData=PrayerTimesData())
data class PrayerTimesData(val timings:PrayerTimings=PrayerTimings(),val date:PrayerDate=PrayerDate())
data class PrayerTimings(val Fajr:String="",val Sunrise:String="",val Dhuhr:String="",val Asr:String="",val Maghrib:String="",val Isha:String="")
data class PrayerDate(val readable:String="",val timestamp:String="",val hijri:HijriDate=HijriDate())
data class HijriDate(val date:String="",val day:String="",val month:HijriMonth=HijriMonth(),val year:String="")
data class HijriMonth(val number:Int=0,val en:String="",val ar:String="")