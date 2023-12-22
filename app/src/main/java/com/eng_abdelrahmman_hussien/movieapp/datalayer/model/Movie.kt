package com.eng_abdelrahmman_hussien.movieapp.datalayer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(@SerializedName("id")private var id:String,@SerializedName("title")private var name:String,@SerializedName("rating")private var rating:Float,@SerializedName("image")private var imgURL:String,@SerializedName("imdb_link")private var imdbURL:String,@SerializedName("rank")private var rank:Int,@SerializedName("description")private var description:String,@SerializedName("big_image")private var bigImgURL:String,@SerializedName("year")private var year:Int,@SerializedName("imdbid")private var imdbid:String,
@SerializedName("trailer")private var trailer_youtubelink:String,
    @SerializedName("trailer_embed_link")private var trailer_embed_link:String,
    @SerializedName("trailer_youtube_id")private var trailer_youtube_id:String
,){
    var idProp:String
        get() = id
        set(value) {id=value}
    var nameProp:String
        get() = name
        set(value) {name=value}
    var ratingProp:Float
        get() = rating
        set(value) {rating=value}
    var imgUrlProp:String
        get() = imgURL
        set(value) {imgURL=value}
    var imdbURLProp:String
        get() = imdbURL
        set(value) {imdbURL=value}
    var rankProp:Int
        get() =rank
        set(value) {rank=value}
    var descriptionProp:String
        get() =description
        set(value) {description=value}
    var bigImgURLProp:String
        get() =bigImgURL
        set(value) {bigImgURL=value}
    var yearProp:Int
        get() =year
        set(value) {year=value}
    var imdbidProp:String
        get() =imdbid
        set(value) {imdbid=value}
    var trailer_youtubelinkProp:String
        get() =trailer_youtubelink
        set(value) {trailer_youtubelink=value}
    var trailer_embed_linkProp:String
        get() =trailer_embed_link
        set(value) {trailer_embed_link=value}
    var trailer_youtube_idProp:String
        get() =trailer_youtube_id
        set(value) {trailer_youtube_id=value}


}
