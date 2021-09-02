package com.example.Nuwi.Adapters

// holds the data for each progress.
class DataModel(name: String, progress: Int) {
    private var name: String? = name
    private var progress: Int? = progress;
//    private var type: String? = type
//    private var version_number: String? = version_number
//    private var feature: String? = feature



//    fun DataModel(name: String?, type: String?, version_number: String?, feature: String?) {
//        this.name = name!!
//        this.type = type
//        this.version_number = version_number
//        this.feature = feature
//    }

    fun getName() : String?{
        return name
    }

    fun getprogress(): Int? {
        return progress
    }
//
//    fun getVersion_number(): String? {
//        return version_number
//    }
//
//    fun getFeature(): String? {
//        return feature
//    }

}