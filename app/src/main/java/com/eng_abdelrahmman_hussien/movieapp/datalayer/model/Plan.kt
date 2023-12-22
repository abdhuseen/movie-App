package com.eng_abdelrahmman_hussien.movieapp.datalayer.model

data class Plan(private var id:Int,private var type:String,private var price:String,private var resolution:String){

    var idProp:Int
        get() = id
        set(value) {id=value}
    var typeProp:String
        get() = type
        set(value) {type=value}
    var priceProp:String
        get() = price
        set(value) {price=value}
    var resolutionProp:String
        get() = resolution
        set(value) {resolution=value}


}
